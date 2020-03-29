package com.sun.gateway.reponse;

import com.sun.gateway.entity.MyException;

public class MyResponse {
    public static MyException success(int code,String message){
        return new MyException(code,message);
    }

    public static MyException failure(int code,String message){
        return new MyException(code,message);
    }
}
