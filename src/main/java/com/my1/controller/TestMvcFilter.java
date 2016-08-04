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
		// ��ȡ�ͻ���ip��ַ
		String ipAddress = request.getRemoteAddr();

		// ���ip��ַ����ǰʱ��
		System.out.println("IP " + ipAddress + ", Time "
				+ new Date().toString());

		// �����������������
		filterChain.doFilter(request, response);
	}
}
