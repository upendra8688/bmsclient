<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Fetching</title>
</head>
<body>

<form action="./userdemand/datetime" method="get">
	<label>Battery id</label> <input type="number" name="batteryid" class="formcontrol" required/>
    <select name="variable">
        <option value="voltage">Voltage</option>
        <option value="current">Current</option>
        <option value="datetime">Datetime</option>
        <option value="temperature">Temperature</option>
    </select>
    <label>Start Date</label><input type="datetime-local" name="startdatetime" class="formcontrol" step="1" required/>
    <label>End Date</label><input type="datetime-local" name="enddatetime" class="formcontrol" step="1" required/>
    
    <input type="submit" value="Submit">
</form>



</body>
</html>