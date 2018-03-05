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
	 * 测试：saveOrUpdate()保存或者修改（如果没有数据，保存数据。如果有，修改数据）
	 */
	@Test
	public void testSaveOrUpdate(){
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		Customer c = session.get(Customer.class, 2L);
		c.setCust_name("测试用例0");
		c.setCust_level("5");
		session.saveOrUpdate(c);
		bt.commit();
		session.close();
	}
	
	/**
	 * 测试：查询表中数据
	 */
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		
		//hsl 查询语言
		Query query = session.createQuery("from Customer");
		//查询表中数据
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
		//提交并关闭session
		bt.commit();
		session.close();
	}
	/**
	 * 测试update
	 */
	@Test
	public void testUpdate(){
		
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		Customer c = session.get(Customer.class, 2L);
		c.setCust_name("美美");
		c.setCust_level("3");
		
		bt.commit();
		session.close();
	}
	
	/**
	 * 测试删除操作
	 * 必须先查询，再删除
	 */
	@Test
	public void testDelete(){
		
		Session session = HibernateUtils.getSession();
		Transaction bt = session.beginTransaction();
		
		//按主键查询
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
		 c.setCust_name("测试数据3");
		 session.save(c);
		 bt.commit();
	}
		 
	
	
	
	@Test
	public void testSave(){
		// 先加载配置文件
		Configuration config = new Configuration().configure();
		/*// 默认加载src目录下的配置文件
		config.configure();*/
		
		// 创建SessionFactory对象
		SessionFactory factory = config.buildSessionFactory();
		// 创建session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 编写保存代码
		Customer c = new Customer();
		// c.setCust_id(cust_id);	已经自动递增
		c.setCust_name("测试名称3");
		c.setCust_mobile("110");
		// 保存客户
		session.save(c);
		// 提交事务
		tr.commit();
		// 释放资源
		session.close();
		factory.close();
	}
	
}
