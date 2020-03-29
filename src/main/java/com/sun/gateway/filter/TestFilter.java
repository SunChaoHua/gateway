package com.sun.gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 先于所有下游服务的 Filter，用于处理类似授权和认证的处理
 * @该类暂时没有业务
 */
@Component
public class TestFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(doSomething(exchange));
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private ServerWebExchange doSomething(ServerWebExchange exchange){
        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//        System.out.println("***doSomething "+request.getPath().value()+"***");

        return exchange.mutate().build();
    }
}
