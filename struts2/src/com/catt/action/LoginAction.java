package com.catt.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{

	private String password;
	
	private String username;
	
	public LoginAction() {
	}
	
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String execute() throws Exception
	{
		if ("hello".equals(this.getUsername().trim())
				&& "world".equals(this.getPassword().trim()))
		{
			Map map = ActionContext.getContext().getSession();
			
			map.put("user","valid");
			return "success";
		}
		else
		{
			this.addFieldError("username", "username or password error");
			return "failer";
		}
	}

	public void validate()
	{
		if (null == this.getUsername() || "".equals(this.getUsername().trim()))
		{
			this.addFieldError("username", "username required");
		}
		if (null == this.getPassword() || "".equals(this.getPassword().trim()))
		{
			this.addFieldError("password", "password required");
		}
		
	}

	
	
	
	

}
