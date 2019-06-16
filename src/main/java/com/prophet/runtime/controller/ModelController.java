package com.prophet.runtime.controller;


import com.prophet.runtime.domain.Model;
import com.prophet.runtime.domain.ModelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    @Autowired
    private ModelManager modelManager;

    @RequestMapping("/firstModel")
    public String RequestHandler() {
        Model firstModel;
        firstModel = modelManager.getModel("firstModel");
        return firstModel.execute();

    }

}
