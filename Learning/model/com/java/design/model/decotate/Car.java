package com.java.design.model.decotate;

public abstract class Car
{
	private String name;
	abstract public void color();
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
}
