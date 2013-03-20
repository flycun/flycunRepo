package com.catt.action;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport
{
	private String username;

	private String password;

	private String repassword;

	private int age;

	private Date birthday;

	private Date graduation;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public Date getGraduation()
	{
		return graduation;
	}

	public void setGraduation(Date graduation)
	{
		this.graduation = graduation;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String test()
	{
		return SUCCESS;
	}

	@Override
	public void validate()
	{
		/*if(null == username || username.length() < 6 || username.length() > 10)
		{
			this.addFieldError("username","username invalid");
		}
		if(null == password || password.length() < 6 || password.length() > 10)
		{
			this.addFieldError("password","password invalid");
		}
		else if(null == repassword || repassword.length() < 6 || repassword.length() > 10)
		{
			this.addFieldError("repassword","re-password invalid");
		}
		else if(!password.equals(repassword))
		{
			this.addFieldError("password","two passwords not the same");
		}
		if(age < 1 || age > 150)
		{
			this.addFieldError("age","age invalid");
		}
		if(null == birthday)
		{
			this.addFieldError("birthday","birthday invalid");
		}
		if(null == graduation)
		{
			this.addFieldError("graduation","graduation invalid");
		}
		if(null != birthday && null != graduation)
		{
			Calendar c1 = Calendar.getInstance();
			c1.setTime(birthday);
			
			Calendar c2 = Calendar.getInstance();
			c2.setTime(graduation);
			
			if(!c1.before(c2))
			{
				this.addFieldError("birthday","birthday should be before graduation");
			}
		}*/
	}
	
	
	
}
