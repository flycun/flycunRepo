package org.test;

import org.apache.log4j.Logger;

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
		

	}

}
