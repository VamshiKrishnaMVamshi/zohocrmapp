<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>
	<h2>Create Lead</h2>
	<form action="saveLead" method="post">
		<pre>
			First Name<input type="text" name="firstName"/>
			Last name<input type="text" name="lastName"/>
			Email<input type="text" name="email"/>
			Mobile<input type="text" name="mobile"/>
			<select name="source">
				<option value="radio">radio</option>
				<option value="News Paper">News Paper</option>
				<option value="website">website</option>
				<option value="trade show">trade show</option>
			</select>
			<input type="submit" value="save"/>
		</pre>
	</form>
</body>
</html>