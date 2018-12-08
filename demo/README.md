## springboot 项目打包方式

在pom.xml中加入如下依赖

```
<build>
        <plugins>
            <plugin>
                <!--打包命令：mvn clean package appassembler:assemble-->
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>appassembler-maven-plugin</artifactId>
                <version>1.10</version>
                <configuration>
                    <!-- 生成linux, windows两种平台的执行脚本 -->
                    <platforms>
                        <platform>windows</platform>
                        <platform>unix</platform>
                    </platforms>
                    <!-- 根目录 -->
                    <assembleDirectory>${project.build.directory}/demo</assembleDirectory>
                    <!-- 打包的jar，以及maven依赖的jar放到这个目录里面 -->
                    <repositoryName>lib</repositoryName>
                    <!-- 可执行脚本的目录 -->
                    <binFolder>bin</binFolder>
                    <!-- 配置文件的目标目录 -->
                    <configurationDirectory>conf</configurationDirectory>
                    <!-- 拷贝配置文件到上面的目录中 -->
                    <copyConfigurationDirectory>true</copyConfigurationDirectory>
                    <!-- 从哪里拷贝配置文件 (默认src/main/config) -->
                    <configurationSourceDirectory>src/main/resources</configurationSourceDirectory>
                    <!-- lib目录中jar的存放规则，默认是${groupId}/${artifactId}的目录格式，flat表示直接把jar放到lib目录 -->
                    <repositoryLayout>flat</repositoryLayout>
                    <encoding>UTF-8</encoding>
                    <logsDirectory>logs</logsDirectory>
                    <tempDirectory>tmp</tempDirectory>
                    <programs>
                        <program>
                            <id>demo</id>
                            <!-- 启动类 -->
                            <mainClass>com.example.demo.DemoApplication</mainClass>
                            <jvmSettings>
                                <extraArguments>
                                    <extraArgument>-server</extraArgument>
                                    <extraArgument>-Xmx2G</extraArgument>
                                    <extraArgument>-Xms2G</extraArgument>
                                </extraArguments>
                            </jvmSettings>
                        </program>
                    </programs>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

配置logback.xml中LOG_HOME的路径

找到项目的文件夹，cmd

执行打包命令：mvn clean package appassembler:assemble

成功后会在target下生成对应的文件夹

配置logback.xml中LOG_HOME的路径

    在windows下进入bin目录，运行demo.bat便可启动项目

    在linux下进入bin目录，修改demo的权限为可执行，执行demo便能启动项目