package com.zrlog.plugin.helloworld;

import com.zrlog.plugin.RunConstants;
import com.zrlog.plugin.type.RunType;
import com.zrlog.plugin.helloworld.controller.HelloWorldController;
import com.zrlog.plugin.common.PluginNativeImageUtils;
import com.zrlog.plugin.helloworld.controller.HelloWorldApiResponse;
import com.zrlog.plugin.helloworld.controller.HelloWorldConfig;
import com.zrlog.plugin.helloworld.controller.HelloWorldPageData;
import com.zrlog.plugin.helloworld.controller.WebsiteKeyRequest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class GraalvmAgentApplication {


    public static void main(String[] args) throws IOException {
        RunConstants.runType = RunType.AGENT;
        String basePath = System.getProperty("user.dir").replace("\\target","").replace("/target", "");
        File file = new File(basePath + "/src/main/resources");
        PluginNativeImageUtils.doLoopResourceLoad(file.listFiles(), file.getPath()  + "/", "/");
        PluginNativeImageUtils.exposeController(Collections.singletonList(HelloWorldController.class));
        PluginNativeImageUtils.usedGsonObject();
        PluginNativeImageUtils.gsonNativeAgentByClazz(Arrays.asList(HelloWorldApiResponse.class, HelloWorldConfig.class,
                HelloWorldPageData.class, WebsiteKeyRequest.class));
        Application.main(args);

    }
}
