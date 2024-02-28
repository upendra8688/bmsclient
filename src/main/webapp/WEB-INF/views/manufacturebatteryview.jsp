<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Battery view</title>
</head>
<body>

<table border=1>
<tr>

<th>Id</th>
<th>Battery Id</th>
<th>Manufacture DateTime</th>

</tr>

<tr>
<td>${data.id}</td>
<td>${data.batteryid}</td>
<td>${data.formatteddatetime}</td>


</tr>
</table>


</body>
</html>