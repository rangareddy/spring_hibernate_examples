<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>AbstractWizardFormController Example</title>
</head>
<body>
	<h3>Student UserName and Password</h3>
	<table>
		<form:form action="student.do" commandName="student" method="post">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Previous" name="_target1" /> <input
					type="submit" value="Finish" name="_finish" /> <input
					type="submit" value="Cancel" name="_cancel" /></td>
				<td>
		</form:form>
	</table>
</body>
</html>