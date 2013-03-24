package org.sheet.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

public class GenSheetTest
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		List events = listEvents();
		for (int i = 0; i < events.size(); i++)
		{
			Event theEvent = (Event) events.get(i);
			System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
		}
		byte[] b=ExportUtils.exportExcel(events, Arrays.asList(headers), Arrays.asList(properties));
		
		FileOutputStream os=null;
		try
		{
			os = new FileOutputStream("WriteFile.xls");
			
			  // 写入输出流
			os.write(b);
			  // 关闭输出流
			  os.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
/*		OutputStream os = null;
		//os = response.getOutputStream();
		try
		{
			os.write(b,0,b.length);
			os.flush();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}
	
	private static final String[] headers = new String[]{"ID", "时间", "标题"};
	private static final String[] properties = new String[]{
		"id", "date", "title"
};
	
	private static List listEvents()
	{

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List result = session.createQuery("from Event").list();

		session.getTransaction().commit();

		return result;
	}

}
