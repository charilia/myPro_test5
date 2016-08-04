/**
 * 
 */
package com.infocore.test;

//����Java��
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

//ʵ�� Filter ��
public class LogFilter implements Filter  {
public void  init(FilterConfig config) 
                     throws ServletException{
  // ��ȡ��ʼ������
  String testParam = config.getInitParameter("test-param"); 

  //��ӡ��ʼ������
  System.out.println("Test Param: " + testParam); 
}
public void  doFilter(ServletRequest request, 
             ServletResponse response,
             FilterChain chain) 
             throws java.io.IOException, ServletException {

  // ��ȡ�ͻ���ip��ַ  
  String ipAddress = request.getRemoteAddr();

  // ���ip��ַ����ǰʱ��
  System.out.println("IP "+ ipAddress + ", Time "
                                   + new Date().toString());

  // �����������������
  chain.doFilter(request,response);
}
public void destroy( ){
  /* ��Filterʵ���ڷ������ϱ��Ƴ�ǰ���á�*/
}
}
