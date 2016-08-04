package com.infocore.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		/**
		 * Hibernate 实现数据插入
		 */
		Session session = HibernateSessionFactory.getSessionFactory()
				.getCurrentSession();

		 User u1 = new User();
		 u1.setName("zhangsan");
		 u1.setAge(25l);
		 session.beginTransaction();
		 session.save(u1);
		 session.getTransaction().commit();

		// /**
		// * Hibernate 实现数据删除
		// */
		// session = HibernateSessionFactory.getSessionFactory()
		// .getCurrentSession();
		// session.beginTransaction();
		// User u2 = new User();
		// u2.setId(1L); // 删除id=16的项
		// session.delete(u2);
		// session.getTransaction().commit();
		//
		// /**
		// * Hibernate 实现数据更新
		// */
		// session = HibernateSessionFactory.getSessionFactory()
		// .getCurrentSession();
		// session.beginTransaction();
		// User u3 = (User) session.get(User.class, 1l);
		// if (u3 != null) {
		// u3.setId(1l);
		// u3.setName("lisi");
		// u3.setAge(23L);
		// session.update(u3);
		// session.getTransaction().commit();
		// }

//		/**
//		 * Hibernate 实现数据查询(HQL查询)
//		 */
//		session = HibernateSessionFactory.getSessionFactory()
//				.getCurrentSession();
//		session.beginTransaction();
//		Query query = session.createQuery("from User where age=23");
//		// 此处user是类名，而不是数据库的表名,select
//		// * 不写
//		List<User> users = query.list();
//		for (User user : users) {
//			System.out.println(user.getId() + " " + user.getName() + " "
//					+ user.getAge());
//		}
	}
}