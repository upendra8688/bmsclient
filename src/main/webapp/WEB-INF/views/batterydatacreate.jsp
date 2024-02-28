<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Battery entry</title>
</head>
<body>

<form action="./batterydataentry" method="post">
	<table border=1>
	<tr>
		<td><label>Batteryid</label></td> <td><input type="number" name="batteryid" class="formcontrol"/></td>
		<td><label>Current</label></td> <td><input type="number" name="current" class="formcontrol"/></td>
		<td><label>Voltage</label></td> <td><input type="number" name="voltage" class="formcontrol"/></td>
		<td><label>Temperature</label> </td><td><input type="number" name="temperature" class="formcontrol"/></td>
	<td><label>DateTime</label></td> <td><input type="datetime-local" name="datetime" class="formcontrol" step="1" /></td>
	
	</tr>
	
	</table>
	<div>
		<button type="submit">SAVE ENTRY</button>
	</div>
</form>






</body>
</html>