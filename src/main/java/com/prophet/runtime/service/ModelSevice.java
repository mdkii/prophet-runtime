package com.prophet.runtime.service;

import com.prophet.runtime.domain.FirstModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ModelSevice {

    @Value("${model.path}")
    private String modelPath;

    public String getModelPath() throws IOException {

        return this.getClass().getClassLoader().getResource("").getPath()
         + modelPath;
    }


    public FirstModel getModleByName(String modelName) throws IOException {
        String fileName = modelName + ".pb";
        return new FirstModel(getModelPath() +fileName);
    }
}
