package net.seehope;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope
 * @Author: lxgy
 * @CreateTime: 2018-12-12 17:39
 * @Description: 启动入口类.
 */
@SpringBootApplication(scanBasePackages = "net.seehope.college")
@MapperScan("net.seehope.college.mapper")
@ServletComponentScan
public class ApplicationContext {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationContext.class, args);
    }
}