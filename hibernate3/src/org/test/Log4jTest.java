package org.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;

public class Log4jTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Logger log=Logger.getLogger(Log4jTest.class.getName());
		log.error("error leve ");
		log.warn("warn leve");
		log.info("info leve");
		log.debug("debug leve ");
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();

		List result = session.createQuery("from Person where PERSON_ID=? ").setInteger(0, 8).list();
		//List result = session.createQuery("from Event").list();
		

		session.getTransaction().commit();
		for (Object object : result)
		{
			Person person=(Person)object;
			log.info(person);
		}
		

	}

}
