<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batterydata</title>
</head>
<body>

<h1>Welcome</h1>

<h1><a href="./batterydatadisplay">GetALL</a></h1>

<h1><a href="./batterydatacreate">CreateEntry</a></h1>
<h1>If you want specific <a href="./batteryuserdemandentry">field</a> along with id</h1>
<h1>If you want battery data of specific Battery Id</h1>
	<form action="./getbyid" method="get">
	<label>Battery Id</label><input type="number" name="id" class="formcontrol" required/>
	<button type="submit">View Details</button>
	
	</form>
	
<h1>If you have Time <a href="./batteryuserdemandconstraintentry">Constraints</a></h1>
</body>
</html>