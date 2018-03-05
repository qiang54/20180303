package com.hibertest.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibertest.domain.Customer;
import com.hibertest.uitls.HibernateUtils;

public class test {

	/**
	 * ���ԣ�saveOrUpdate()��������޸ģ����û�����ݣ��������ݡ�����У��޸����ݣ�
	 */
	@Test
	public void testSaveOrUpdate(){
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		Customer c = session.get(Customer.class, 2L);
		c.setCust_name("��������0");
		c.setCust_level("5");
		session.saveOrUpdate(c);
		bt.commit();
		session.close();
	}
	
	/**
	 * ���ԣ���ѯ��������
	 */
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		
		//hsl ��ѯ����
		Query query = session.createQuery("from Customer");
		//��ѯ��������
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		//�ύ���ر�session
		bt.commit();
		session.close();
	}
	/**
	 * ����update
	 */
	@Test
	public void testUpdate(){
		
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		Customer c = session.get(Customer.class, 2L);
		c.setCust_name("����");
		c.setCust_level("3");
		
		bt.commit();
		session.close();
	}
	
	/**
	 * ����ɾ������
	 * �����Ȳ�ѯ����ɾ��
	 */
	@Test
	public void testDelete(){
		
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		
		//��������ѯ
		Customer c = session.get(Customer.class, 1L);
		System.out.println(c);
		session.delete(c);
		
		//session.save(c);
		bt.commit();
		session.close();
	}
	
	
	@Test
	public void test2(){
		
		 Session session = HibernateUtils.getSession();
		 Transaction bt = session.beginTransaction();
		 
		 Customer c = new Customer();
		 c.setCust_name("��������3");
		 session.save(c);
		 bt.commit();
	}
		 
	
	
	
	@Test
	public void testSave(){
		// �ȼ��������ļ�
		Configuration config = new Configuration().configure();
		/*// Ĭ�ϼ���srcĿ¼�µ������ļ�
		config.configure();*/
		
		// ����SessionFactory����
		SessionFactory factory = config.buildSessionFactory();
		// ����session����
		Session session = factory.openSession();
		// ��������
		Transaction tr = session.beginTransaction();
		// ��д�������
		Customer c = new Customer();
		// c.setCust_id(cust_id);	�Ѿ��Զ�����
		c.setCust_name("��������3");
		c.setCust_mobile("110");
		// ����ͻ�
		session.save(c);
		// �ύ����
		tr.commit();
		// �ͷ���Դ
		session.close();
		factory.close();
	}
	
}
