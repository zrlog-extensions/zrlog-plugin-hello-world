package com.zrlog.plugin.helloworld.controller;

import com.zrlog.plugin.data.codec.PluginAppearance;
import com.zrlog.plugin.message.Plugin;

public class HelloWorldPageData {

    private boolean dark;
    private PluginAppearance appearance;
    private String colorPrimary;
    private Plugin plugin;
    private HelloWorldConfig config;

    public PluginAppearance getAppearance() {
        return appearance;
    }

    public void setAppearance(PluginAppearance appearance) {
        this.appearance = appearance;
    }

    public boolean isDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public String getColorPrimary() {
        return colorPrimary;
    }

    public void setColorPrimary(String colorPrimary) {
        this.colorPrimary = colorPrimary;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public HelloWorldConfig getConfig() {
        return config;
    }

    public void setConfig(HelloWorldConfig config) {
        this.config = config;
    }
}
