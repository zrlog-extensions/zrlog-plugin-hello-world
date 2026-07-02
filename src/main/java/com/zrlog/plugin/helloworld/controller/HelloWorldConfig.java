package com.zrlog.plugin.helloworld.controller;

public class HelloWorldConfig {

    private String uriPath;
    private String version;

    public void normalize(String version) {
        if (uriPath == null || uriPath.trim().isEmpty()) {
            uriPath = "/";
        }
        this.version = version;
    }

    public static HelloWorldConfig fromUriPath(String uriPath) {
        HelloWorldConfig config = new HelloWorldConfig();
        config.setUriPath(uriPath);
        return config;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
