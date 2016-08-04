package com.my1.controller;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.infocore.test.HibernateSessionFactory;
import com.infocore.test.User;
import com.infocore.utils.SpringBeanUtils;
import com.my1.business.HelloBusinessImpl;
import com.my1.intf.HelloBusiness;

@Controller
public class DemoController extends WebApplicationObjectSupport {

	/**
	 * ·Ç·¨×Ö·û
	 */
	private static final String ILLEGAL = "yuxiang";

	@RequestMapping(value = "/toPage1.htm")
	public ModelAndView toPage1() {
		/**
		 * ApplicationContext context = new ClassPathXmlApplicationContext(
		 * "spring/aopContext.xml"); HelloBusiness business = (HelloBusiness)
		 * context .getBean("businessProxy");
		 **/
//		HelloBusiness business = (HelloBusiness) this.getApplicationContext()
//				.getBean("businessProxy");
		HelloBusiness business1 = (HelloBusiness) this.getWebApplicationContext()
				.getBean("businessProxy");
		HelloBusiness business2 = SpringBeanUtils.getBean2(HelloBusinessImpl.class);
		business2.sayHello("ÍôÍôÍôÍôÍôÍôÍôÍôÍôÍôÍôÍôÍôÍô");
		return new ModelAndView("page1");

	}

	@RequestMapping("/saveContext.htm")
	public @ResponseBody
	ModelAndView save(String name, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		Session session = HibernateSessionFactory.getSessionFactory()
				.getCurrentSession();
		if (!ILLEGAL.equals(name)) {
			User u1 = new User();
			u1.setName(name);
			u1.setAge(25l);
			session.beginTransaction();
			session.save(u1);
			session.getTransaction().commit();
			map.put("msg", "1");
		} else {
			map.put("msg", "0");
		}

		return new ModelAndView(new MappingJackson2JsonView(), map);
	}

}