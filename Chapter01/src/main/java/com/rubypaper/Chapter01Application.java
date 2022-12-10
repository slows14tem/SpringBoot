package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
//		SpringApplication application = new SpringApplication(Chapter01Application.class);
//		application.setWebApplicationType(WebApplicationType.SERVLET);
//		//NONE = 일반 자바 어플리케이션으로 실행.
//		//SERVLET = 웹모드로 구동.(Done이 떠도 내부에서 톰켓이 스텐바이)
//		application.run(args);
		System.out.println("Done");

	}

}
