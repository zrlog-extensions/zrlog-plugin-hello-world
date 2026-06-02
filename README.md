# zrlog-plugin-hello-world

ZrLog 插件示例工程。用于展示插件配置页、页面渲染、接口调用、路由处理和 native image 配置的基础写法。

## 用途

- 作为新插件的工程结构参考
- 演示 `Controller` 接口处理
- 演示 `ClientActionHandler` 路由转发
- 演示 `ConnectHandler` 启动后台任务
- 演示前端页面和模板资源打包

## 构建

```shell
export JAVA_HOME=${HOME}/dev/graalvm-jdk-latest
export PATH=${JAVA_HOME}/bin:$PATH
```

## 快速上手

### 直接下载 zip

- 全局替换 hello-world 为插件的名称，比如 ucloud
- 改 com.zrlog.plugin.helloworld 为预期的包名比如 com.zrlog.plugin.ucloud
- 按实际插件功能更新 `README.md` 和 `plugin.properties`

### 说明

- 模板页面放在 `src/main/resources/templates`
- 页面实现方式可按插件复杂度选择 SPA、CSR 或服务端模板
- 通过 Controller 处理请求
- 通过 ClientActionHandler 可以自定义路由转发规则
- 后台任务可以通过 ConnectHandler 启动

## GraalVM native image

可通过 `GraalvmAgentApplication` 生成 native image 所需的反射、序列化和静态资源配置。

## 打包

### GitHub Actions
 
1. 配置仓库变量 `SECRET_ID`、`SECRET_KEY`、`BUCKET`
2. 默认 OSS 上传 endpoint 为 `oss-cn-chengdu`，如需使用其他区域，修改 `bin/upload-bin.sh`
3. 提交代码后，由 actions 打包 jar 和 native-image 包

### 手动打包

```
sh bin/package-native-github.sh /tmp/download/plugin
```

打包后可通过插件管理页面或其他部署流程加载插件。
