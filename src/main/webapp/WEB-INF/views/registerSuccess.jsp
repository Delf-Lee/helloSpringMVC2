<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/myStyle.css" />
</head>

<h1 class="result">신청 성공</h1>
<body>
	<p>${message}</p>
</body>
<p>
	<a href="${pageContext.request.contextPath}/courseRegister">
		더 신청 </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}/registrationDetails">
		수강 신청 현황 </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}"> go home </a>
</p>
</html>