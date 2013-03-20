<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'register2.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
	function validate()
	{
		var usernameValue = document.getElementById("usernameId").value;
		var passwordValue = document.getElementById("password").value;
		var repasswordValue = document.getElementById("repassword").value;
		
		if(usernameValue.length == 0)
		{
			alert("username should not be blank!");
			return false;
		}
		else if(usernameValue.length < 6 || usernameValue.length > 10)
		{
			alert("length of username should be between 6 and 10!");
			return false;
		}
		
		if(passwordValue.length == 0)
		{
			alert("password should not be blank!");
			return false;
		}
		else if(passwordValue.length < 6 || passwordValue.length > 10)
		{
			alert("length of password should be between 6 and 10!");
			return false;
		}
		
		if(repasswordValue.length == 0)
		{
			alert("repassword should not be blank!");
			return false;
		}
		else if(repasswordValue.length < 6 || repasswordValue.length > 10)
		{
			alert("length of repassword should be between 6 and 10!");
			return false;
		}
		
		if(passwordValue != repasswordValue)
		{
			alert("password and repassword should be same!");
			return false;
		}
		
		return true;
		
		
	}
	</script>
	
	

	</head>

	<body>
		<table align="center" width="40%">
			<tr>
				<td>

					<s:fielderror cssStyle="color:red" />

				</td>
			</tr>
		</table>


		<s:form action="register" theme="simple">

			<table align="center" width="40%" border="1">
				<tr>
					<td>
						username
					</td>
					<td>
						<s:textfield name="username" label="username" id="usernameId"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						password
					</td>
					<td>
						<s:password name="password" label="password" id="passwordId"></s:password>
					</td>
				</tr>


				<tr>
					<td>
						re-password
					</td>

					<td>
						<s:password name="repassword" label="repassword" id="repasswordId"></s:password>
					</td>
				</tr>

				<tr>
					<td>
						age
					</td>

					<td>
						<s:textfield name="age" label="age"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						birthday
					</td>

					<td>
						<s:textfield name="birthday" label="birthday"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						graduation
					</td>

					<td>
						<s:textfield name="graduation" label="graduation"></s:textfield>
					</td>
				</tr>

				<tr>
					<td>
						<s:submit value=" submit "></s:submit>
					</td>

					<td>
						<s:reset value=" reset "></s:reset>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
