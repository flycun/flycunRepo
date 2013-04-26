package com.java.design.model.decotate;
class DecorateWhiteColor extends Decorate
{
	DecorateWhiteColor(Car car)
	{
		super(car);
	}

	@Override
	public void color()
	{
		super.color();
		System.out.println("add white color");
	}
}