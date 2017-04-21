package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.MyCart;

public class MyCartTestCase {

	@Autowired
	private static MyCart myCart;
	
	@Autowired
	private static CartDAO cartDAO;

	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		myCart = (MyCart) context.getBean("myCart");
		cartDAO = (CartDAO) context.getBean("cartDAO");
		
	}
	
/*	@Test
	public void saveCartTestCase(){
		Long d = System.currentTimeMillis();
		Date today = new Date(d);
		myCart.setProduct_name("p003");
		myCart.setPrice(3662);
		myCart.setDate_added(today);
		myCart.setQuantity(2);
		myCart.setStatus('N');
		myCart.setUser_id("001");
		
		boolean flag = cartDAO.save(myCart);
		Assert.assertEquals("saveCartTestCase",true,flag);
		
		
	}*/
	@Test
	public void showCart(){
		
		
		int recordCart = cartDAO.list("001").size();
		assertEquals("showCart",3,recordCart);
	}
	@Test
	public void getTotalAmount(){
		Double var = cartDAO.getTotalAmount("001");
		Assert.assertNotNull("getTotalAmount", var);
	}
	@Test
	public void getMycart(){
		myCart = cartDAO.get("3");
		Assert.assertNotNull("getMycart", myCart);
	}
}
