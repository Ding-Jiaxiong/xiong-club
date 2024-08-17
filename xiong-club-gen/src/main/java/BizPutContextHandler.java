

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.dingjiaxiong.core.config.GenConfig;
import com.dingjiaxiong.core.config.MapperConfig;
import com.dingjiaxiong.core.core.sdk.PostCurFiledContextAware;
import com.dingjiaxiong.core.entity.TableInfo;
import com.dingjiaxiong.core.utils.MySQLToJavaTypeConverter;
import org.apache.velocity.VelocityContext;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BizPutContextHandler implements PostCurFiledContextAware {

    public static String underlineToHump(String str, boolean removePre) {
        if (removePre) {
            str = str.substring(str.indexOf("_"));
        }
        str = str.toLowerCase();
        Pattern compile = Pattern.compile("_[a-z]");
        Matcher matcher = compile.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(0).toUpperCase().replace("_", ""));
        }
        matcher.appendTail(sb);
        return StrUtil.upperFirst(sb.toString());
    }

    private static String convert(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        char firstChar = str.charAt(0);
        char lowerFirstChar = Character.toLowerCase(firstChar);
        return lowerFirstChar + str.substring(1);
    }

    @Override
    public void doAware(GenConfig genConfig, MapperConfig mapperConfig, VelocityContext context) {

        // 处理导包标志位
        List<TableInfo> files = JSONObject.parseArray(JSONObject.toJSONString(context.get("fields")), TableInfo.class);
        for (TableInfo tableInfo : files) {
            MySQLToJavaTypeConverter.Item typeInfo = tableInfo.getTypeInfo(tableInfo.getType());
            if (typeInfo.isFlag()) {
                context.put("import" + typeInfo.getType(), true);
            }
        }
        context.put("modelName", underlineToHump(genConfig.getJdbc().getTableName(), Convert.toBool(context.get("removePre"))));
        context.put("_modelName", convert(context.get("modelName").toString()));
        context.put("tableName", genConfig.getJdbc().getTableName());

    }

}
