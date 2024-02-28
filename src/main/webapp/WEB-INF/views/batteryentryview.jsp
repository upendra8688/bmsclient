<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batterydata</title>
</head>
<body>

<table border=1>

<tr>
<th>Id</th>
<th>Battery Id</th>
<th>Current</th>
<th>Voltage</th>
<th>Temperature</th>
<th>Date Time</th>
</tr>

<tr>

<td>${batterydetails.id}</td>
<td>${batterydetails.batteryid}</td>
<td>${batterydetails.current}</td>
<td>${batterydetails.voltage}</td>
<td>${batterydetails.temperature}</td>
<td>${batterydetails.formateddatetime}</td>
</tr>


</table>






</body>
</html>