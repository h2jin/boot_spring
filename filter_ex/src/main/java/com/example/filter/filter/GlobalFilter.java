package com.example.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

// Filter 기능을 활용하기 위해서는 구현받아야 한다.
// Servlet --> Http 통신 확장 클래스. 자바 언어로 웹 프로그래밍 만들기 위해 만들어진 클래스

// 실무에서는 로깅처리를 많이 한다.
// url 확인이라던지 특정 코드를 집어 넣어야 할 때 사용을 많이한다.
@Slf4j
//@Component
@WebFilter(urlPatterns = "/api/*")
public class GlobalFilter implements Filter {
	// 메모리에 올리기 위해서는 new 키워드를 써야하는데 왜 가능한가?

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("dofilter 호출");
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);

		ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(
				(HttpServletResponse) response);

		chain.doFilter(requestWrapper, responseWrapper);		
		// 주의점 : dofilter 다음에 코드를 작성해야 한다.

		// req
		String url = requestWrapper.getRequestURI();
		log.info("request url : {}, request body : {}" + url, requestWrapper.getContentAsByteArray());
		
		// res
		String resContent = new String(responseWrapper.getContentAsByteArray());
		int httpStatusCode = responseWrapper.getStatus();
		// 응답을 처리하기 위해서 반드시 코드에 추가해야 한다.
		responseWrapper.copyBodyToResponse();
		log.info("response Status : {}, responseBody : {}", httpStatusCode, resContent );

	}

//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		log.info("제일 먼저 request(요청)에 대해서 처리해보기");
//		// 
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//		log.info("req : {}",  httpServletRequest.getProtocol());
//		log.info("req : {}",  httpServletRequest.getHeaderNames().toString());
//		
//		HttpServletResponse servletResponse = (HttpServletResponse) response;
//		log.info("res : {}", servletResponse.getBufferSize());
//		
//		// Api Controller 못가고 있음.
//		// 기본적으로 한 번 읽은 request는 다시 읽을 수 없다.
//		// 해결 방안
//		@Content
//		
//	}

}
