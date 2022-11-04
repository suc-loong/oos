package com.hctel.oos;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@Profile("dev")
//public class CORSFilter implements Filter {
//
//	@SuppressWarnings("unused")
//	private FilterConfig config;
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PATCH");
//		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//		httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
//		if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
//           httpServletResponse.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            chain.doFilter(request, response);
//        }
//	}
//
//	@Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        config = filterConfig;
//    }
//}


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSFilter implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry){
		registry.addMapping("/*/**")
				.allowedHeaders("*")
				.allowedMethods("*")
				.maxAge(3600)
				.allowedOrigins("*");
	}
}