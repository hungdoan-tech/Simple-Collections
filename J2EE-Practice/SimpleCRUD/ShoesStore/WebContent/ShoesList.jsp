<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
	.center {
		margin : 0 auto; 
		text-align: center;
	}
</style>
</head>
<body>
	<div class="center">
        <h1>Shoes Management</h1>
        <h2>
            <a href="/ShoesStore/new">Add New Shoes</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/ShoesStore/list">List All Shoes</a>             
        </h2>
    </div>
    <div align="center">
        <table border="1">
            <caption>List of Shoes</caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="shoes" items="${listShoes}">
                <tr>
                    <td><c:out value="${shoes.id}" /></td>
                    <td><c:out value="${shoes.name}" /></td>
                    <td><c:out value="${shoes.brand}" /></td>
                    <td><c:out value="${shoes.price}" /></td>
                    <td>
                        <a href="/ShoesStore/edit?id=<c:out value='${shoes.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/ShoesStore/delete?id=<c:out value='${shoes.id}' />">Delete</a>                 
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>