package com.emc.scheduler.activemqQuartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ProductTransactionJob extends QuartzJobBean{

	private SyncronousMessageReciever myTask;

	public void setMyTask(SyncronousMessageReciever myTask) {
		this.myTask = myTask;
	}
		
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
		myTask.jmsSyncRecieve();
/*		try {
			arg0.getScheduler().shutdown(true);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
