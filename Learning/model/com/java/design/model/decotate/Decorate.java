package com.java.design.model.decotate;

public abstract class Decorate extends Car
{
	Car car;
	Decorate(Car car)
	{
		this.car=car;
	}
	
	@Override
	public void color()
	{
		car.color();
	}
	public void setCar(Car car)
	{
		this.car = car;
	}
}


