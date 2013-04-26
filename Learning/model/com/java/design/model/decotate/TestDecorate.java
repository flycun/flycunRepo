package com.java.design.model.decotate;

public class TestDecorate
{

	public static void main(String[] args)
	{
		Car audi=new CarAudi();
		Decorate redDecorate=new DecorateRedColor(audi);
		Decorate whiteDecorate=new DecorateWhiteColor(redDecorate);
		whiteDecorate.color();
	}
}
