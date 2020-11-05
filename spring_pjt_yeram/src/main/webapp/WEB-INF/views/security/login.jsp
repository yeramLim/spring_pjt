<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Login.jsp</h1>
	
	<s:authorize ifAllGranted="ROLE_USER">
		<p>is Log-in</p>
	</s:authorize>

	<s:authorize ifNotGranted="ROLE_USER">	
		<p>is Log-out</p>
	</s:authorize>
	
	USER ID : <s:authentication property="name"/><br>
	<a href="${pageContext.request.contextPath }/j_spring_security_logout">Log Out</a>
</body>
</html>