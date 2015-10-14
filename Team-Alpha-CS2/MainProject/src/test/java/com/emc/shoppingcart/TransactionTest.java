package com.emc.shoppingcart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.shoppingcart.dao.TransactionDao;
import com.emc.shoppingcart.dao.TransactionsDaoImpl;
import com.emc.shoppingcart.model.Orders;
import com.emc.shoppingcart.model.Transactions;

//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class TransactionTest {

	@Autowired(required=false)
	TransactionDao t1;

	@Autowired
	TransactionsDaoImpl tImpl;

	@Autowired
	JmsTemplate jmsTemplate;

	/*
	 * @Test public void testRetrievetransaction() { Transactions tobj=new
	 * Transactions(2,"30-05-2015" , "placed", 1200);
	 * 
	 * System.out.println("Testing...."); Transactions
	 * trans=t1.retrieveById(1240L);
	 * System.out.println(trans.getProducts().size()); //t1.save(t);
	 * 
	 * }
	 */

/*	@Test
	public void testTransactionSave() {
	
		Transactions tobj = new Transactions(5, new Date(), "placed", 8000);
		Orders orderobj=new Orders(100L, 2, 5000,tobj);
		tobj.getProducts().add(orderobj);
		
		Long id=t1.save(tobj);
		System.out.println(id);
		System.out.println("succesFully added");
	}*/
	
	@Test
	public void testDate() throws ParseException{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd ");
		 String s="1993-08-25 08:12:15";
		 String s2="1993-08-25 ";
		 String transactionDate=sdf.format(new Date());

			System.out.println(sdf.parse(s));
			System.out.println(sdf2.parse(s2));
			System.out.println(new Date());

	}

	
/*	@Test
	public void testSendMessage() {

		Long id = 1234L;
		jmsTemplate.convertAndSend(id);
	}*/
	 

}
