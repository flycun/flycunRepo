package com.catt.interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor3 extends MethodFilterInterceptor
{

	@Override
	public void init()
	{
		System.out.println("init3");
	}
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception
	{
		System.out.println("my interceptor3");

		String result = invocation.invoke();

		return result;
	}

}