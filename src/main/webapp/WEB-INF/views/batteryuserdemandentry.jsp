<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Fetching</title>
</head>
<body>

<form action="./batteryuserdemandprocess" method="get">
	<label>Battery id</label> <input type="number" name="batteryid" class="formcontrol"/>
    <select name="variable">
        <option value="voltage">Voltage</option>
        <option value="current">Current</option>
        <option value="datetime">Datetime</option>
        <option value="temperature">Temperature</option>
    </select>
    
    <input type="submit" value="Submit">
</form>



</body>
</html>