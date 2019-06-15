package com.prophet.runtime.controller;


import com.prophet.runtime.domain.FirstModel;
import com.prophet.runtime.service.ModelSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    @Autowired
    private ModelSevice modelService;

    @RequestMapping("/firstModel")
    public String RequestHandler() {
        FirstModel firstModel = modelService.getModleByName("firstModel");
        return String.valueOf(firstModel.execute());

    }

}
