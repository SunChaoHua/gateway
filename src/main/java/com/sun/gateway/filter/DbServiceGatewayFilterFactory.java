package com.sun.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * 路由到 test_router服务之前对所有到 test_router服务上的请求进行处理的 Filter
 */
@Component
public class DbServiceGatewayFilterFactory extends AbstractGatewayFilterFactory<DbServiceGatewayFilterFactory.Config> {

    private Logger logger = LoggerFactory.getLogger(DbServiceGatewayFilterFactory.class);

    public DbServiceGatewayFilterFactory() {
        // 这里需要将自定义的config传过去，否则会报告ClassCastException
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
       return (exchange, chain) -> {
           ServerHttpRequest request = exchange.getRequest();
           String url = request.getPath().value();
           logger.info("***apply "+url+"***");

           return chain.filter(exchange);
       };
    }


    public static class Config{

    }
}
