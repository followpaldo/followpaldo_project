package jjon.gangsan.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private SessionCheckInter interceptor;	
	@Override   // 인터셉터가 동작할 url 패턴 등록
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/member_edit") //회원수정 폼
				.addPathPatterns("/member_edit_go") //회원수정
				
				.addPathPatterns("/member_del.do") //회원삭제폼
				.addPathPatterns("/member_del_ok.do") //회원삭제
				.addPathPatterns("/member_logout.do"); //로그아웃
	}
}
