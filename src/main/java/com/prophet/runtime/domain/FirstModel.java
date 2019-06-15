package com.prophet.runtime.domain;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;

public class FirstModel {

    private int id;
    private String name = "firstModel";
    private String fileName;


    public FirstModel(String fileName) {
        this.fileName = fileName;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float execute() {

        float[] r = {-1.0f};

        System.out.println("###### model.fullpath=" + fileName);

        try (Graph graph = new Graph()) {
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(fileName));
            graph.importGraphDef(graphBytes);

            try (Session session = new Session(graph)) {
                Tensor<?> out = session.runner().feed("X", Tensor.create(2.0f)).fetch("results").run().get(0);
                r = new float[1];
                out.copyTo(r);
                System.out.println(r[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r[0];
    }
}
