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
 
1. 在仓库的 Actions Secrets 配置 `SECRET_ID`、`SECRET_KEY`、`BUCKET` 和 OSS endpoint `HOST`。
2. 推送到 `main` 后，由 Actions 使用 `zrlog-build` 打包 JAR 和 Native Image。

### 手动打包

在插件仓库根目录执行以下命令。复现 CI 时，使用工作流固定的构建脚本提交。

```bash
git clone https://github.com/zrlog/zrlog-build.git ../zrlog-build
git -C ../zrlog-build checkout --detach e8532208950a2c8902c1dec1b4e259f08af922e5
PLUGIN_PACKAGE_PREVIEW=false bash ../zrlog-build/scripts/plugin/build-native.sh /tmp/download/plugin
```

打包后可通过插件管理页面或其他部署流程加载插件。

## 原生制品发布

Linux amd64/arm64 制品在上传前会调用 `zrlog-artifact-service`，通过与 `plugin-core`
相同的固定发布版 [`zrlog-build`](https://github.com/zrlog/zrlog-build)
Action（`v1.0.1`，工作流固定完整 SHA）完成压缩和 SHA-256、文件大小校验；接入与故障处理见该仓库 README。
处理成功后才会生成最终制品的 MD5 并上传；处理失败会停止该平台的发布。
服务接收的版本号来自 `zrlog-build` 构建脚本生成的 `plugin.properties`。

发布前需要配置 Actions Secret `ARTIFACT_SERVICE_TOKEN`，可在仓库中单独设置，
或授权该仓库使用同名组织 Secret。服务地址为 `https://webdav.zrlog.com/artifact`。
