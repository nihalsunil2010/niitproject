package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {

	@Autowired
private static User user;
	
	@Autowired
private static UserDAO userDAO;
	
	@BeforeClass
	public static void initialisze(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	/*
	@Test
	public void validateCredentialsTestCase(){
		boolean flag = userDAO.validate("niit", "123");
		assertEquals("validateCredentialsTestCase",true, flag);
		
	}
	*/
	/*
	@Test
	public void saveUserTestCase(){
		user.setId("0023");
		user.setName("admin");
		user.setPassword("123");
		user.setMail("rajee");
		user.setContact("466");
		user.setRole("dedd");
		
		boolean flag = userDAO.save(user);
		assertEquals("saveUserTestCase",true,flag);
	}
	*/
	
	@Test
	public void getUserByIdTestCase(){
		user = userDAO.getUser("niit");
		Assert.assertNotNull("getUserByIdTestCase", user);
	}
	
	@Test
	public void updateUserTestCase(){
		user.setId("001");
		user.setName("rajeevcpaul");
		user.setPassword("123");
		user.setMail("rajee");
		user.setContact("466");
		user.setRole("dedd");	
		
		boolean flag = userDAO.update(user);
		assertEquals("updateUserTestCase",true,flag);
	}
	

}
