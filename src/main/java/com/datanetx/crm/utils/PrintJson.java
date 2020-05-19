package com.datanetx.crm.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PrintJson {

    private PrintJson() {}
    //功能将boolean值解析为json串，用于返回成功与否的标记。
    public static void printJsonFlag(HttpServletResponse response,boolean flag) {
        Map<String,Boolean> map=new HashMap<>();
        map.put("success",flag);

        ObjectMapper om=new ObjectMapper();
        try {
            //{"success":true}
            String json=om.writeValueAsString(map);
            response.getWriter().print(json);
        }catch (JsonGenerationException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 功能：将对象解析为json串。
     * 能把 person p --> id name age解析为 {"id":"?","name":"?","age":"?"} 的json串
     * 能把 List<Person> plist 列表解析为 [{"id":"?","name":"?","age":"?"},{"id":"?","name":"?","age":"?"},...] 的json串
     * 能把 Map --> key value 解析为 {key:value} 的json串
     */
    public static void printJsonObj(HttpServletResponse response,Object obj){
        ObjectMapper om=new ObjectMapper();
        try {
            String json=om.writeValueAsString(obj);
            response.getWriter().print(json);
        }catch (JsonGenerationException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
