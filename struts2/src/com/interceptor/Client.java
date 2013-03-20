package com.interceptor;

import java.lang.reflect.Proxy;

public class Client
{
	
	public static void main(String[] args)
	{
		TargetInterface target = new Target();
		
		MyProxy myProxy = new MyProxy();
		
		TargetInterface proxy = (TargetInterface)myProxy.getProxy(target);
		
		proxy.doSomething();
		
	}

}

class MyProxy
{
	public Object getProxy(Object object)
	{
		MyHandler myHandler = new MyHandler();

		myHandler.setObject(object);

		return Proxy.newProxyInstance(Target.class.getClassLoader(), object
				.getClass().getInterfaces(), myHandler);
	}
}


