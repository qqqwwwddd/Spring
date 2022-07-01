//package com.spring.config;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class[] { RootConfig.class };
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class[] { ServletConfig.class };
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] { "/" };
//	}
//
//	// CORS
//	public void addCorsMapping(CorsRegistry registry) {
//		registry.addMapping("/**") // 접근 가능한지 구분(컨트롤러의 이름)
//				.allowedOrigins("http://localhost:3000") // 외부에서 접근가능한 IP 주소
//				.allowedMethods("GET").allowedMethods("POST");
//	}
//}
