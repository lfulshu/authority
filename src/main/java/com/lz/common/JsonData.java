package com.lz.common;

import lombok.Getter;
import lombok.Setter;

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

}
