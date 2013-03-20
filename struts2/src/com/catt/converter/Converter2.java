package com.catt.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.catt.bean.Point;

public class Converter2 extends StrutsTypeConverter
{

	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass)
	{
		Point point=new Point();
		String[] paramValues=values[0].split(",");
		point.setX(Integer.parseInt(paramValues[0]));
		point.setY(Integer.parseInt(paramValues[1]));
		
		return point;
	}

	@Override
	public String convertToString(Map context, Object o)
	{
		Point point = (Point)o;
		
		int x = point.getX();
		int y = point.getY();
		
		String result = "[x=" + x + " , y=" + y + "]";
	
		return result;
	}

}
