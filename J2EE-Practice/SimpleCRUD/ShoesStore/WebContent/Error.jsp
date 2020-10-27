<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="Shared.css">
</head>
<body>
	<div class="center">
        <h1>Error</h1>
        <h2><%=exception.getMessage() %><br/> </h2>
    </div>
</body>
</html>