<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player</title>
</head>
<body>
 	<h1>Player</h1>
	<div>
		<div>Pes Id: <c:out value="${player.id}" /></div>
		<div>Name : <c:out value="${player.name}" /></div>
		<div>Nationality: <c:out value="${player.nationality.name}" /></div>
	</div>
</body>
</html>