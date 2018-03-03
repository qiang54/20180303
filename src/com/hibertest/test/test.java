package com.hibertest.test;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibertest.domain.Customer;

public class test {

	@Test
	public void testSave(){
		// 先加载配置文件
		Configuration config = new Configuration();
		// 默认加载src目录下的配置文件
		config.configure();
		// 创建SessionFactory对象
		SessionFactory factory = config.buildSessionFactory();
		// 创建session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction tr = session.beginTransaction();
		// 编写保存代码
		Customer c = new Customer();
		// c.setCust_id(cust_id);	已经自动递增
		c.setCust_name("测试名称1");
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
