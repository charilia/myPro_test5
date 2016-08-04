/**
 * 
 */
package com.my1.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author yuxiang
 * 
 */
public class TestMvcFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 获取客户端ip地址
		String ipAddress = request.getRemoteAddr();

		// 输出ip地址及当前时间
		System.out.println("IP " + ipAddress + ", Time "
				+ new Date().toString());

		// 传递请求道过滤器链
		filterChain.doFilter(request, response);
	}
}
