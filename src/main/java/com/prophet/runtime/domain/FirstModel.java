package com.prophet.runtime.domain;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;

@Component
public class FirstModel implements Model {

    private String id = "firstModel";
    private String name = "firstModel";
    private String fileName = "firstModel.pb";
    private String type = "Tensor";

    static {
        ModelManager.register(new FirstModel());
    }


    public String getID() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String execute() {

        float[] r = {-1.0f};

        fileName = this.getClass().getClassLoader().getResource("").getPath() + "model/" + fileName;
        System.out.println("###### model.fullpath=" + fileName);

        try (Graph graph = new Graph()) {
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(fileName));
            graph.importGraphDef(graphBytes);

            try (Session session = new Session(graph)) {
                Tensor<?> out = session.runner().feed("X", Tensor.create(1.0f)).fetch("results").run().get(0);
                r = new float[1];
                out.copyTo(r);
                System.out.println(r[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(r[0]);
    }
}
