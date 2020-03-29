package com.sun.gateway.exception;

import com.sun.gateway.entity.MyException;
import com.sun.gateway.reponse.MyResponse;
import com.sun.gateway.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MyException exceptionHandler(ServerHttpRequest request, Exception e) {
//        String ip = IpUtil.getIpAddress(request);
//        logger.info("调用者IP：" + ip);
        String errorMessage = String.format("Url:[%s]%n{%s}", request.getPath().toString(), e.getMessage());
        logger.error(errorMessage, e);
        return MyResponse.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
