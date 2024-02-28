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

<c:if test="${empty batterydata}">
<tr><td style="font-size:20px;color:green;text-align:center" colspan="6">Battery Data is not available</td></tr>
</c:if>

<c:forEach items="${batterydata}" var="e">

<tr>

<td>${e.id}</td>
<td>${e.batteryid}</td>
<td>${e.current}</td>
<td>${e.voltage}</td>
<td>${e.temperature}</td>
<td>${e.formateddatetime}</td>
</tr>


</c:forEach>
</table>






</body>
</html>