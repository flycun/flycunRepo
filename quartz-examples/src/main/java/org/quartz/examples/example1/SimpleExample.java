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
 * 演示怎样启动和关闭Quartz scheduler，怎样调度并运行一个job
 */
public class SimpleExample {

	public void run() throws Exception {
		Logger log = LoggerFactory.getLogger(SimpleExample.class);

		log.info("------- Initializing ----------------------");

		// 实现获取一个scheduler实例
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		log.info("------- Initialization Complete -----------");

		// computer a time that is on the next round minute
		Date runTime = evenMinuteDate(new Date());

		log.info("------- Scheduling Job  -------------------");

		// 定义一个绑定到 HelloJob class的 job实例
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1")
				.build();

		// 定义一个该job的触发器
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startAt(runTime).build();

		// 通知quartz使用触发器调度job
		sched.scheduleJob(job, trigger);
		log.info(job.getKey() + " will run at: " + runTime);

		// 启动 scheduler (启动之前，任何任务都不会运行)
		sched.start();

		log.info("------- Started Scheduler -----------------");

		log.info("------- Waiting 20 seconds... -------------");
		try {
			Thread.sleep(20L * 1000L);
			// executing...
		} catch (Exception e) {
		}

		// 关闭 scheduler
		log.info("------- Shutting Down ---------------------");
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
	}

	public static void main(String[] args) throws Exception {

		SimpleExample example = new SimpleExample();
		example.run();

	}

}
