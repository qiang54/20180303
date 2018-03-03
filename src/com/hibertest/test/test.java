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
		// �ȼ��������ļ�
		Configuration config = new Configuration();
		// Ĭ�ϼ���srcĿ¼�µ������ļ�
		config.configure();
		// ����SessionFactory����
		SessionFactory factory = config.buildSessionFactory();
		// ����session����
		Session session = factory.openSession();
		// ��������
		Transaction tr = session.beginTransaction();
		// ��д�������
		Customer c = new Customer();
		// c.setCust_id(cust_id);	�Ѿ��Զ�����
		c.setCust_name("��������1");
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
