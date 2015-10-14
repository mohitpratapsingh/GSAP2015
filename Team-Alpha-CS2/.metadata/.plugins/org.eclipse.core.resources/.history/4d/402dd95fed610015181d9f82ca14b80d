package com.emc.scheduler.activemqQuartz;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.emc.scheduler.service.TransactionService;

@Component
public class SyncronousMessageReciever {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private TransactionService transactionService;
	
	public void jmsSyncRecieve(){
		Long transactionId;
/*		Long id=1234L;
		jmsTemplate.convertAndSend(id);*/
		do{
			transactionId=(Long) jmsTemplate.receiveAndConvert();
		    transactionService.updateTransaction(transactionId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(transactionId);
		}while( transactionId!= null);
		
		System.out.println(Calendar.getInstance().getTime());
		
	}
	
}
