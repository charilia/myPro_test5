package com.infocore.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		/**
		 * Hibernate ʵ�����ݲ���
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
		// * Hibernate ʵ������ɾ��
		// */
		// session = HibernateSessionFactory.getSessionFactory()
		// .getCurrentSession();
		// session.beginTransaction();
		// User u2 = new User();
		// u2.setId(1L); // ɾ��id=16����
		// session.delete(u2);
		// session.getTransaction().commit();
		//
		// /**
		// * Hibernate ʵ�����ݸ���
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
//		 * Hibernate ʵ�����ݲ�ѯ(HQL��ѯ)
//		 */
//		session = HibernateSessionFactory.getSessionFactory()
//				.getCurrentSession();
//		session.beginTransaction();
//		Query query = session.createQuery("from User where age=23");
//		// �˴�user�����������������ݿ�ı���,select
//		// * ��д
//		List<User> users = query.list();
//		for (User user : users) {
//			System.out.println(user.getId() + " " + user.getName() + " "
//					+ user.getAge());
//		}
	}
}