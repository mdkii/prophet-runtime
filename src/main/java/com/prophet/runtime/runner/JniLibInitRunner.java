package com.prophet.runtime.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JniLibInitRunner implements ApplicationRunner {

    @Value("${tf.jinlib.fullname}")
    private String tfjniLib;


    public String getTfjniLib() {
        return tfjniLib;
    }

    public void setTfjniLib(String tfjniLib) {
        this.tfjniLib = tfjniLib;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("##### tf.jinlib.fullname=" + tfjniLib);
        String path = JniLibInitRunner.class.getClassLoader().getResource("").getPath();
        System.load(path + tfjniLib);
    }
}
