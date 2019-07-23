package com.zyx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.zyx.mapper")
//@EnableScheduling //开启定时任务
@EnableAsync //开启异步任务
@EnableCaching
public class Demo1Application extends SpringBootServletInitializer implements CommandLineRunner{

	//以war包启动，先继承SpringBootServletInitializer，然后重写其SpringApplicationBuilder配置方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(Demo1Application.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(Demo1Application.class, args);
	}


	@GetMapping("/demo1")
	public String demo1(){
		System.out.println("hhh");
		return "Hello zyx!";
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){

		return args -> {
			System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			Arrays.stream(beanNames).forEach(System.out::println);
		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("服务已启动，执行command line runner。");
		System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
	}
}
