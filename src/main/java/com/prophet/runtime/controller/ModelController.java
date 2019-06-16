package com.prophet.runtime.controller;


import com.prophet.runtime.domain.FirstModel;
import com.prophet.runtime.service.ModelSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ModelController {

    @Autowired
    private ModelSevice modelService;

    @RequestMapping("/firstModel")
    public String RequestHandler() {
        FirstModel firstModel;
        try {
            firstModel = modelService.getModleByName("firstModel");
        } catch (IOException e) {
            e.printStackTrace();
            return "-2.0";
        }
        return String.valueOf(firstModel.execute());

    }

}
