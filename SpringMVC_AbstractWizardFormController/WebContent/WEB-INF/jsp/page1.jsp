<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>AbstractWizardFormController Example</title>
</head>
<body>
	<h3>Student Name and Address</h3>
	<table>
		<form:form action="student.do" commandName="student" method="post">
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Next" name="_target1">
					<input type="submit" value="Cancel" name="_cancel"></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</body>
</html>