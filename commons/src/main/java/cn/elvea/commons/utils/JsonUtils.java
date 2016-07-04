package cn.elvea.commons.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json相关的工具类
 */
@SuppressWarnings({"unchecked"})
public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws Exception {
        return objectMapper.readValue(json, clazz);
    }

    public static Map<String, Object> toMap(String json) throws Exception {
        return objectMapper.readValue(json, Map.class);
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clazz)
            throws Exception {
        Map<String, Map<String, Object>> map = objectMapper.readValue(json,
                new TypeReference<Map<String, T>>() {
                }
        );

        Map<String, T> result = new HashMap<String, T>();
        for (Map.Entry<String, Map<String, Object>> entry : map.entrySet()) {
            result.put(entry.getKey(), mapToObject(entry.getValue(), clazz));
        }
        return result;
    }

    public static <T> List<T> toList(String json, Class<T> clazz)
            throws Exception {
        List<Map<String, Object>> list = objectMapper.readValue(json,
                new TypeReference<List<T>>() {
                }
        );
        List<T> result = new ArrayList<T>();
        for (Map<String, Object> map : list) {
            result.add(mapToObject(map, clazz));
        }
        return result;
    }

    public static <T> T mapToObject(Map map, Class<T> clazz) {
        return objectMapper.convertValue(map, clazz);
    }
}
