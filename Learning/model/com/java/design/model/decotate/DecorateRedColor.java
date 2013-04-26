package com.java.design.model.decotate;
class DecorateRedColor extends Decorate
{
	
	DecorateRedColor(Car car)
	{
		super(car);
	}

	@Override
	public void color()
	{
		super.color();
		System.out.println("add red color");
	}
}