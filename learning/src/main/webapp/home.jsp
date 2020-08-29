<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Data</title>
</head>
<body>
	<form action="/stock">
	<input type="text" name="lable">
	<input type="number" name="days" >
	<input type="submit">
	</form>
	 ${obj.HistStock()}
</body>
</html>