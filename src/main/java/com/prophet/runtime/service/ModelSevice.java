package com.prophet.runtime.service;

import com.prophet.runtime.domain.FirstModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ModelSevice {

    @Value("${model.path}")
    private String modelPath;

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }


    public FirstModel getModleByName(String modelName) {
        String fileName = modelName + ".pb";
        return new FirstModel(modelPath+fileName);
    }
}
