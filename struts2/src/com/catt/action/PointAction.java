package com.catt.action;

import java.util.Date;
import java.util.List;

import com.catt.bean.Point;
import com.opensymphony.xwork2.ActionSupport;

public class PointAction extends ActionSupport
{

//	private Point point;
	private List<Point> point;
	private int age;
	private String username;
	private Date date;
	
	/*public Point getPoint()
	{
		return point;
	}
	public void setPoint(Point point)
	{
		this.point = point;
	}*/
	
	public int getAge()
	{
		return age;
	}
	public List<Point> getPoint()
	{
		return point;
	}
	public void setPoint(List<Point> point)
	{
		this.point = point;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}

}
