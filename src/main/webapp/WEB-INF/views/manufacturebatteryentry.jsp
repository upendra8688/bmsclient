<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manufacture Battery</title>
</head>
<body>
<form action="./savebatteryentry" method="post">

	<label>Battery Id</label><input name="batteryid" type="number" class="formcontrol"/>
	<label>DateTime</label> <input type="datetime-local" name="manufacture_datetime" class="formcontrol" step="1" />

	<button type="submit">SAVE ENTRY</button>

</form>


</body>
</html>