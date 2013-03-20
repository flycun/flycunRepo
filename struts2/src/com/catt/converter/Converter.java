package com.catt.converter;

import java.util.Map;

import com.catt.bean.Point;

import ognl.DefaultTypeConverter;

public class Converter extends DefaultTypeConverter
{

	public Converter() {

	}

	@Override
	public Object convertValue(Map context, Object value, Class toType)
	{

		if (Point.class == toType)
		{
			Point point = new Point();
			String[] str = (String[]) value;
			String[] paramValues = str[0].split(",");
			point.setX(Integer.parseInt(paramValues[0]));
			point.setY(Integer.parseInt(paramValues[1]));
			System.out.println(point);
			return point;
		}

		if (String.class == toType)
		{
			Point point = (Point) value;

			int x = point.getX();
			int y = point.getY();

			String result = "[x=" + x + " , y=" + y + "]";
			System.out.println(result);
			return result;
		}

		return null;
	}

}
