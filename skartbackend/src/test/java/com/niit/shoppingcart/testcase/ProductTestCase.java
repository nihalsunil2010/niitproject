package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductTestCase {

	@Autowired
	private static Product product;

	@Autowired
	private static ProductDAO productDAO;

	@BeforeClass
	public static void initialization() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");

	}
/*
	@Test
	public void saveProductTestCase() {
		product.setId("01101p");
		product.setName("Led");
		product.setPrice(600.00);
		product.setDescription("testss");
		product.setCategory_id("0022");
		product.setSupplier_id("0022");

		boolean flag = productDAO.save(product);
		assertEquals("saveProductTestCase", true, flag);
	}
	*/
	@Test
	public void getProductByIdTestCase(){
		
		product = productDAO.getProductById("0011p");
		Assert.assertNotNull("getProductByIdTestCase", product);
		
	}
	@Test
	public void updateProductTestCase(){
		
		product.setId("01101p");
		product.setName("Led");
		product.setPrice(601.00);
		product.setDescription("testss");
		product.setCategory_id("0022");
		product.setSupplier_id("0022");

		boolean flag = productDAO.update(product);
		assertEquals("updateProductTestCase", true, flag);
	}
@Test
	public void deleteProductTestCase(){
		product.setId("01101p");
		boolean flag= productDAO.delete(product);
		assertEquals("deleteProductTestCase",true,flag);
	}
}
