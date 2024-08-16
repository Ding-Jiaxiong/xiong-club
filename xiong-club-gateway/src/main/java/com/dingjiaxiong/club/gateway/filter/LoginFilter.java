package com.dingjiaxiong.club.gateway.filter;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 登录拦截器
 *
 * @author: Ding Jiaxiong
 * @date: 2023/11/26
 */
@Component
@Slf4j
public class LoginFilter implements GlobalFilter {

    @Override
    @SneakyThrows
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String url = request.getURI().getPath();
        log.info("LoginFilter.filter.url:{}", url);
        if (url.equals("/auth/user/doLogin")) {
            chain.filter(exchange);
        }
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        log.info("LoginFilter.filter.url:{}", new Gson().toJson(tokenInfo));
        String loginId = (String) tokenInfo.getLoginId();
        mutate.header("loginId", loginId);
        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }

}
