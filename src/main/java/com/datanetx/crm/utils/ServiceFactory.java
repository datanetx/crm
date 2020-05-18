package com.datanetx.crm.utils;

public class ServiceFactory {
    //传递类后得到功能扩充后的代理类
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
