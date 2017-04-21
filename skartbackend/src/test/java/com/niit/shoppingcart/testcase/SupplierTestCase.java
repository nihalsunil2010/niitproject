package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

   @Autowired
	private static Supplier supplier;
	
   @Autowired
	private static SupplierDAO supplierDAO;
   
   @BeforeClass
   public static void initialization(){
	   AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
	   context.scan("com.niit");
	   context.refresh();
	   supplier = (Supplier) context.getBean("supplier");
	   supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	   
   }
   
   @Test
   
   public void saveSupplierTestCase(){
	   supplier.setId("sup002");
	   supplier.setName("raj");
	   supplier.setDescription("abcdefg");
	  boolean flag = supplierDAO.save(supplier);
	  assertEquals("saveSupplierTestCase",true,flag);
	  
   }
   
   @Test
   public void getSupplierByIdTestCase(){
	   supplier = supplierDAO.getSupplierById("sup001");
	  Assert.assertNotNull("getSupplierByIdTestCase",supplier);
   }
   

}
