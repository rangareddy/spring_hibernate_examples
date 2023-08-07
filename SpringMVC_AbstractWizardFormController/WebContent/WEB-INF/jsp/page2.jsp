<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>AbstractWizardFormController Example</title>
</head>
<body>
	<h3>Student Gender and Age</h3>
	<table>
		<form:form action="student.do" commandName="student" method="post">
			<tr>
				<td>Gender:</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Previous" name="_target0">
					<input type="submit" value="Next" name="_target2"> <input
					type="submit" value="Cancel" name="_cancel"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>