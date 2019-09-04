package com.lz.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liizzz
 * @Data 2019/9/4 22:12
 */

@Getter
@Setter
public class JsonData {

    private boolean ret;
    private String msg;
    private Object data;

    private JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData success(Object object, String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    /**
     * 把 JsonData 的属性值封装成一个MAP
     */
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }
}
