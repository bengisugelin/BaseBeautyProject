package com.project.basebeauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BaseBeautyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseBeautyApplication.class, args);
	}
//	@Controller
//	public static class StaticController {
//
//		@RequestMapping({"/", "/{path:^(?!api$|static$).*$}/**"})
//		public String forward() {
//			return "forward:/static/index.html";
//		}
//	}


}
