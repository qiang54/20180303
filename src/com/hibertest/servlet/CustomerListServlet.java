package com.hibertest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibertest.domain.Customer;
import com.hibertest.service.CustomerService;

/**
 * 客户列表 控制器
 */
public class CustomerListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		CustomerService cs = new CustomerService();
		List<Customer> list = cs.listOfCustomer();
		
		//将list放入request域中
		request.setAttribute("list", list);
	
		for (Customer customer : list) {
			System.out.println(customer);
		}
		//重定向
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
		
		//response.sendRedirect(request.getContextPath() + "/jsp/customer/list.jsp");

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
