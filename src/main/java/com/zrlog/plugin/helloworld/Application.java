package com.zrlog.plugin.helloworld;


import com.zrlog.plugin.client.NioClient;
import com.zrlog.plugin.render.SimpleTemplateRender;
import com.zrlog.plugin.helloworld.controller.HelloWorldController;
import com.zrlog.plugin.helloworld.handle.ConnectHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final ConnectHandler connectHandler = new ConnectHandler();

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        List<Class> classList = new ArrayList<>();
        classList.add(HelloWorldController.class);
        new NioClient(connectHandler, new SimpleTemplateRender(), new HelloWorldClientActionHandler()).connectServer(args, classList, HelloWorldPluginAction.class);
    }
}

