package com.dingjiaxiong.core.core;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.dingjiaxiong.core.config.GenConfig;
import com.dingjiaxiong.core.config.MapperConfig;
import com.dingjiaxiong.core.core.impl.JdbcPutContextHandler;
import com.dingjiaxiong.core.core.sdk.FilePutContextHandler;
import com.dingjiaxiong.core.core.sdk.PostCurFiledContextAware;
import com.dingjiaxiong.core.entity.Context;
import com.dingjiaxiong.core.entity.MapperInfo;
import com.dingjiaxiong.core.utils.*;
import org.apache.velocity.VelocityContext;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CodeGenerationCode {

    public static void doGenCode() {
        doGenCode(null);
    }

    public static void doGenCode(PostCurFiledContextAware aware) {

        try {
            // 01 获取入口配置文件
            GenConfig genConfig = YamlUtils.loadYaml("genCode/gen.yml", GenConfig.class);

            // 02 获取全局的配置上下文
            assert genConfig != null;
            VelocityContext context = getGlobalContext(genConfig);
            Map<String, Object> contexts = new HashMap<>();
            for (String key : context.getKeys()) {
                Object value = context.get(key);
                if (value instanceof String && FunctionUtils.isFunction(value)) {
                    value = FunctionUtils.doFunction(value);
                    context.put(key, value);
                }
                contexts.put(key, context.get(key));
            }
            System.out.println("==========> getGlobalContext:" + System.lineSeparator() + JSONObject.toJSONString(contexts));
            System.out.println();

            // 03 获取 模板与生成文件的映射关系
            List<MapperInfo> infos = getMapperInfos(genConfig, context, aware);

            // 04 通过映射关系生成代码文件
            genCode(infos, genConfig.getParams().getOrDefault("templateBasePath", "").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void genCode(List<MapperInfo> infos, String templateBasePath) {

        AtomicInteger count = new AtomicInteger(1);
        infos.forEach(info -> {
            CodeGeneratorUtils codeGenerator = new CodeGeneratorUtils(templateBasePath);
            codeGenerator.generateCode(
                    info.getContext(),
                    info.getTemplatePath(),
                    info.getOutPutPath(),
                    count);
        });

    }

    private static List<MapperInfo> getMapperInfos(GenConfig genConfig, VelocityContext context, PostCurFiledContextAware aware) {

        MapperConfig mapperConfig = YamlUtils.loadYaml(genConfig.getMapperInfos(), MapperConfig.class);
        assert mapperConfig != null;
        // 允许在生成文件前对上下文中的数据进行修改 处理一些导包之类的不好控制业务
        if (Objects.nonNull(aware)) {
            aware.doAware(genConfig, mapperConfig, context);
            Map<String, Object> contexts = new HashMap<>();
            for (String key : context.getKeys()) {
                Object value = context.get(key);
                contexts.put(key, value);
            }
            System.out.println("==========> modify file context :" + System.lineSeparator() + JSONObject.toJSONString(contexts));
        }

        AtomicInteger count = new AtomicInteger(1);
        return mapperConfig.getMappers().stream().filter(Objects::nonNull).map(item -> {
            MapperInfo info = new MapperInfo();
            info.setTemplatePath(getResPath(item.getTemplate()));
            String cName = item.getName();

            if (cName.contains("$")) {
                cName = replace$key(context, cName);
            }
            String pkg = item.getPackageName();
            if (StrUtil.isNotEmpty(pkg) && pkg.contains("$")) {
                pkg = replace$key(context, pkg);
            }
            String filePath = item.getFilePath();
            if (StrUtil.isNotEmpty(filePath) && filePath.contains("$")) {
                filePath = replace$key(context, filePath);
            }
            String outPutPath = getTargetPath(mapperConfig.getModule(), pkg, filePath);
            File file = new File(outPutPath);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                System.out.println("==========> mkdir " + mkdirs + " " + file.getAbsolutePath());
                System.out.println();
            }
            outPutPath += ("/" + cName + "." + item.getExt());
            VelocityContext cloneCtx = (VelocityContext) context.clone();
            info.setOutPutPath(outPutPath);
            if (StrUtil.isNotBlank(genConfig.getFilePutHandler())) {
                try {
                    FilePutContextHandler handler = (FilePutContextHandler) Class.forName(genConfig.getFilePutHandler()).newInstance();
                    handler.put(cloneCtx, item.getFileId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            cloneCtx.put("className", cName);
            cloneCtx.put("packageName", pkg);
            System.out.println("==========> " + count.get() + " MapperInfo : " + System.lineSeparator() + info);
            System.out.println();
            Map<String, Object> contexts = new HashMap<>();
            for (String key : cloneCtx.getKeys()) {
                contexts.put(key, cloneCtx.get(key));
            }
            System.out.println("==========> MapperInfo context : " + System.lineSeparator() + JSONObject.toJSONString(contexts));
            System.out.println();
            System.out.println("=============================================================================================================================================");
            System.out.println();
            info.setContext(cloneCtx);
            return info;
        }).collect(Collectors.toList());
    }

    private static String replace$key(VelocityContext velocityContext, String conextkey) {

        String key = conextkey.substring(conextkey.indexOf("${") + 2, conextkey.indexOf("}"));
        Object value = velocityContext.get(key);
        conextkey = conextkey.replace("${" + key + "}", value.toString());
        if (conextkey.contains("$")) {
            conextkey = replace$key(velocityContext, conextkey);
        }
        return conextkey;

    }

    private static VelocityContext getGlobalContext(GenConfig genConfig) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Context context = ConfigUtils.getContext();
        boolean putData = false;

        // 01 处理优先级第一的处理器
        if (StrUtil.isNotBlank(genConfig.getHandler())) {
            JdbcPutContextHandler jdbcPutContextHandler = (JdbcPutContextHandler) Class.forName(genConfig.getHandler()).newInstance();
            putData = jdbcPutContextHandler.put();
        }

        // 02 处理优先级第二的json导入
        if (!putData && StrUtil.isNotBlank(genConfig.getJson())) {
            List<String> lines = FileUtil.readLines(getRealResPath(genConfig.getJson()), "UTF-8");
            StringBuilder json = new StringBuilder();
            for (String line : lines) {
                json.append(line);
            }
            context = ContextUtils.buildContext(json.toString());
            ConfigUtils.reSetContext(context);
            putData = true;
        }

        // 03 处理优先级第三的mysql导入
        if (!putData) {
            JdbcPutContextHandler jdbcPutContextHandler = new JdbcPutContextHandler();
            jdbcPutContextHandler.put();
        }

        // 04 添加配置中的全局参数
        Map<String, Object> params = genConfig.getParams();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            context.put(entry.getKey(), entry.getValue());
        }
        return context.get();

    }

    private static String getTargetPath(String module, String packageName, String filePath) {

        if (StrUtil.isEmpty(module)) {
            module = "/";
        }
        if (SystemUtils.isMacOs()) {
            if (StrUtil.isEmpty(filePath)) {
                return getCurPath().substring(0, getCurPath().length() - 2) + module + "src/main/java/" + packageName.replaceAll("\\.", "/");
            } else {
                return getCurPath().substring(0, getCurPath().length() - 2) + module + filePath;
            }
        } else {
            if (StrUtil.isEmpty(filePath)) {
                return getCurPath() + module + "src/main/java/" + packageName.replaceAll("\\.", "\\");
            } else {
                return getCurPath() + module + filePath;
            }
        }

    }

    private static URL getRealResPath(String res) {
        ClassLoader classLoader = CodeGenerationCode.class.getClassLoader();
        return classLoader.getResource(res);
    }

    private static String getResPath(String res) {

        if (SystemUtils.isMacOs()) {
            ClassLoader classLoader = CodeGenerationCode.class.getClassLoader();
            return classLoader.getResource(res).getPath()
                    .replaceAll(getCurPath().substring(0, getCurPath().length() - 1), "");
        } else {
            return res;
        }

    }

    private static String getCurPath() {
        if (SystemUtils.isMacOs()) {
            return new File("./").getAbsolutePath();
        } else {
            return System.getProperty("user.dir");
        }
    }

}
