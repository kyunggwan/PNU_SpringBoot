package edu.pnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice2Application.class, args);
//		 Spring boot는 기본적으로 웹 Application으로 실행인데 자바 어플리케이션으로도 실행 가능하다
//		 (WebApplicationType.NONE);으로 설정한다면 자바 어플리케이션으로 실행한다.
//		 SERVLET으로 되면 웹 어플리케이션으로 실행
		
//		SpringApplication application = new SpringApplication(MissionStart01Application.class);
//		application.setWebApplicationType(WebApplicationType.SERVLET); // NONE이므로 자바 어플리케이션으로 실행한다
//		application.run(args);
//		System.out.println("Application done");
	}

}
