package com.infocore.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.infocore.utils.JsonConvert;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * �Ƿ��ַ�
	 */
	private static final String ILLEGAL = "yuxiang";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ʹ�� GBK ��������������ʾ
		// response.setCharacterEncoding("GBK");
		String name = request.getParameter("name");
		response.getWriter().write("����̳̣�http://www.runoob.com");
		response.getWriter().write(name);

		Session session = HibernateSessionFactory.getSessionFactory()
				.getCurrentSession();

		if (!ILLEGAL.equals(name)) {
			User u1 = new User();
			u1.setName(name);
			u1.setAge(25l);
			session.beginTransaction();
			session.save(u1);
			session.getTransaction().commit();
		} else {
			response.getWriter().print("['success']");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}