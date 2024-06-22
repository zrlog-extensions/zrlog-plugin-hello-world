#### zrlog 插件代码模版仓库

> 这是 hello-world 插件，仅用于快速创建插件使用

#### 开发环境打包

```shell
export JAVA_HOME=${HOME}/dev/graalvm-jdk-latest
export PATH=${JAVA_HOME}/bin:$PATH
```

### 快速上手

#### 直接下载 zip

- 全局替换 hello-world 为插件的名称，比如 ucloud
- 改 com.zrlog.plugin.helloworld 为预期的包名比如 com.zrlog.plugin.ucloud
- 删除或者编辑这个 README.md 文件，为插件的介绍页面

#### 说明

- 模版页面都放在 resources/templates 目录下面，技术实现方式，可自选（SPA/CSR），功能单一推荐使用服务端模版
- 通过 Controller 处理请求，这可以简化自己映射路由
- 通过 ClientActionHandler 可以自定义路由转发规则
- 定时器后台运行，可以通过 ConnectHandler 进行启动

#### graalvm native image

可以通过提前 `GraalvmAgentApplication`，生成对应的 native image（AOT） 受限制的反射，序列化，静态资源加载等，简单配置就能实现无依赖的可执行文件，兼容性更好，执行效率更高（和插件具体干的活有关）

#### 打包

##### github-actions，直接打包上传制 oss（推荐）
 
1. 配置需仓库变量 `SECRET_ID`,`SECRET_KEY`,`BUCKET`， 
2. 默认 oss 上传的 endpoint 为 `oss-cn-chengdu` 如果不在，需要改 `bin/upload-bin.sh` 对应区域
3. 提交代码，让 actions 为你打包 jar 和 native-image 包

#### 手动打包（强烈不推荐）

```
sh bin/package-native-github.sh
```

通过 scp 或者其他自选途径更新或者加载插件