package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author manoj263.kumar
 */
@Component
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
        this.propertyMap.put(key,  value);
    }

    public K getProperty(String key){
        return this.propertyMap.get(key);
    }

    public void setObject(String key, Object obj){
        this.objectMap.put(key, obj);
    }

    public Object getObject(String key){
        return this.objectMap.get(key);
    }

    public void setListMap(String key, List<HashMap<String,String>> listMap){
        this.listHashMap.put(key, listMap);
    }

    public List<HashMap<String,String>> getListMap(String Key){
        return this.listHashMap.get(Key);
    }

}
