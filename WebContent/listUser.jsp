<%@page import="java.util.List"%>
<%@page import="model.logic.UserDatabase"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.entities.UserBean" %>
<%@ page import="controller.ListUserController" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div >
			<h2>JAVA</h2>
			<table border="1" cellspacing="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>name</th>
						<th>birthday</th>
						<th>brithPlace</th>
					</tr>
				</thead>
				<tbody>
				<%	
					List<UserBean> listUserJava = (List<UserBean>)request.getAttribute("userJava"); 
					for(UserBean user : listUserJava) {
				%>
				<tr>
					<td><%= user.getId() %></td>
					<td><%= user.getName() %></td>
					<td><%= user.getBirthday()%></td>
					<td><%= user.getBirthplace() %></td>
				</tr>
				<% } %>
				</tbody>
			</table>
		</div>

		<div>
			<h2>JSTL</h2>
			<table border="1" cellspacing="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>name</th>
						<th>birthday</th>
						<th>brithPlace</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="a">
					<tr>
						<td>${a.id} </td>
						<td>${fn:escapeXml (a.name)}</td>
						<td>${a.birthday}</td>
						<td>${fn:escapeXml (a.birthplace)}</td>
					</tr> 
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>