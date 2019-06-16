package com.prophet.runtime.domain;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ModelManager {
    private static Map<String, Model> models = new ConcurrentHashMap<String, Model>();

    public static void register(Model model) {
        models.put(model.getID(), model);
    }

    public Model getModel(String id) {
        return models.get(id);
    }

}
