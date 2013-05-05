package org.quartz.examples.example1;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.DateBuilder.*;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ��ʾ���������͹ر�Quartz scheduler���������Ȳ�����һ��job
 */
public class SimpleExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);

		log.info("------- Initializing ----------------------");

		// ʵ�ֻ�ȡһ��schedulerʵ��
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		log.info("------- Initialization Complete -----------");

		// computer a time that is on the next round minute
		Date runTime = evenMinuteDate(new Date());

		log.info("------- Scheduling Job  -------------------");

		// ����һ���󶨵� HelloJob class�� jobʵ��
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1")
				.build();

		// ����һ����job�Ĵ�����
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startAt(runTime).build();

		// ֪ͨquartzʹ�ô���������job
		sched.scheduleJob(job, trigger);
		log.info(job.getKey() + " will run at: " + runTime);

		// ���� scheduler (����֮ǰ���κ����񶼲�������)
		sched.start();

		log.info("------- Started Scheduler -----------------");

		log.info("------- Waiting 20 seconds... -------------");
		try {
			Thread.sleep(20L * 1000L);
			// executing...
		} catch (Exception e) {
		}

		// �ر� scheduler
		log.info("------- Shutting Down ---------------------");
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {

		SimpleExample example = new SimpleExample();
		example.run();

	}

}
