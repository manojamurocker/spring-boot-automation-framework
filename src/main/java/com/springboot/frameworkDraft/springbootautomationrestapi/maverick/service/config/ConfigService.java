package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author manoj263.kumar
 */
public class ConfigService<K> {

    LinkedHashMap<String, Object> objectMap;
    LinkedHashMap<String,List<HashMap<String,String>>> listHashMap;
    LinkedHashMap<String, K> propertyMap;

    public ConfigService(){
        objectMap = new LinkedHashMap<>();
        listHashMap = new LinkedHashMap<>();
        propertyMap = new LinkedHashMap<>();
    }

    public void setProperty(String key, K value){
        propertyMap.put(key, value);
    }

    public K getProperty(String key){
        return propertyMap.get(key);
    }

    public void setObject(String key, Object obj){
        objectMap.put(key, obj);
    }

    public Object getObject(String key){
        return objectMap.get(key);
    }

    public void setListMap(String key, List<HashMap<String,String>> listMap){
        listHashMap.put(key, listMap);
    }

    public List<HashMap<String,String>> getListMap(String Key){
        return listHashMap.get(Key);
    }

}
