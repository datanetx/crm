package com.datanetx.settings.test;

import com.datanetx.crm.utils.DateTimeUtil;
import com.datanetx.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {
        String expireTime="2019-10-10 10:10:10";//失效时间
        String currentTime= DateTimeUtil.getSysTime();//当前系统时间

        int count=expireTime.compareTo(currentTime);//通过字符串比较日期，大于0则未失效，小于0则失效
        System.out.println(count);

        String lockState="0";
        if("0".equals(lockState)){
            System.out.println("账号已锁定");
        }

        String ip="192.168.1.1";//浏览器端的ip地址
        String allowIps="192.168.1.10,192.168.1.2,127.0.0.1";
        if(allowIps.contains(ip)){
            System.out.println("有效的ip地址，允许访问系统");
        }else {
            System.out.println("ip地址受限，请联系管理员");
        }

        System.out.println(MD5Util.getMd5("lspwd"));
        System.out.println(MD5Util.getMd5("123"));
    }
}
