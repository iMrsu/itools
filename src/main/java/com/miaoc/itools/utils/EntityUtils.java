package com.miaoc.itools.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntityUtils {

    private static Logger logger = LoggerFactory.getLogger(BaseUtils.class);
    /**
     * 实体类转Map
     * @param object
     * @return
     */
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> map = new HashMap();
        for (Field field : object.getClass().getDeclaredFields()){
            try {
                boolean flag = field.isAccessible();
                field.setAccessible(true);
                Object o = field.get(object);
                map.put(field.getName(), o);
                field.setAccessible(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * Map转实体类
     * @param map 需要初始化的数据，key字段必须与实体类的成员名字一样，否则赋值为空
     * @param entity  需要转化成的实体类
     * @return
     */
    public static <T> T mapToEntity(Map<String, Object> map, Class<T> entity) {
        T t = null;
        try {
            t = entity.newInstance();
            for(Field field : entity.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object!= null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public static String HumpToUnderline(String para){
        StringBuilder sb=new StringBuilder(para);
        int temp=0;//偏移量，第i个下划线的位置是 当前的位置+ 偏移量（i-1）,第一个下划线偏移量是0
        for(int i=0;i<para.length();i++){
            if(Character.isUpperCase(para.charAt(i))){
                sb.insert(i+temp, "_");
                temp+=1;
            }
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 将对象的大写转换为下划线加小写，例如：userName-->user_name
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String toUnderlineJSONString(Object object) {
        String reqJson = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            reqJson = mapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("转换失败",e);
        }

        return reqJson;
    }

    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toSnakeObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//　　        mapper的configure方法可以设置多种配置（例如：多字段 少字段的处理）
//　　　　　　 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        T reqJson =  mapper.readValue(json, clazz);
        return reqJson;
    }

    /**
     * 将对象属性转化为map结合
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map集合中的数据转化为指定对象的同名属性中
     */
    public static <T> T mapToBean(Map<String, Object> map,Class<T> clazz) throws Exception {
        T bean = clazz.newInstance();
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}