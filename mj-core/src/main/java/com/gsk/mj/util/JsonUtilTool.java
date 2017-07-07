package com.gsk.mj.util;



import com.alibaba.fastjson.JSON;
import java.util.*;

/**
 * JSON转换工具类
 *
 * @author kevin
 * @date 2014-04-04
 */
public class JsonUtilTool {



    /**
     * 对象转换成JSON字符串
     *
     * @param obj
     *            需要转换的对象
     * @return 对象的string字符
     */
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * JSON字符串转换成对象
     *
     * @param jsonString
     *            需要转换的字符串
     * @param type
     *            需要转换的对象类型
     * @return 对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String jsonString, Class<T> type) {
        return (T) JSON.parseObject(jsonString , type);
    }

    /**
     * 将JSONArray对象转换成list集合
     *
     * @param jsonArr
     * @return
     */
    public static List<Object> jsonToList(String jsonArr) {

        return JSON.parseArray(jsonArr);
    }

    /**
     * 将json字符串转换成map对象
     *
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(String json) {
        return (Map<String,Object>) JSON.parse(json);
    }


}
