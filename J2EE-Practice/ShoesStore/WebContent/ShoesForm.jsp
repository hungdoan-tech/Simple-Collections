<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shoes Form</title>
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
        <c:if test="${shoes != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${shoes == null}">
            <form action="insert" method="post">
        </c:if>
	        <table border="1">
	            <caption>
                    <c:if test="${shoes != null}">
                        Edit Shoes
                    </c:if>
                    <c:if test="${Shoes == null}">
                        Add New Shoes
                    </c:if>
	            </caption>
	            <c:if test="${shoes != null}">
	                <input type="hidden" name="id" value="<c:out value='${shoes.id}' />" />
	            </c:if>           
	            <tr>
	                <th>Name: </th>
	                <td>
	                    <input type="text" name="name" size="45"
	                            value="<c:out value='${shoes.name}' />"
	                        />
	                </td>
	            </tr>
	            <tr>
	                <th>Brand: </th>
	                <td>
	                    <input type="text" name="brand" size="45"
	                            value="<c:out value='${shoes.brand}' />"
	                    />
	                </td>
	            </tr>
	            <tr>
	                <th>Price: </th>
	                <td>
	                    <input type="text" name="price" size="5"
	                            value="<c:out value='${shoes.price}' />"
	                    />
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Save" />
	                </td>
	            </tr>
	        </table>
        </form>
    </div>   
</body>
</html>