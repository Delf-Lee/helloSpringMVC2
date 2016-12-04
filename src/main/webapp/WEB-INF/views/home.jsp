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

<h1 class="h">1292032 이상훈</h1>
<body>
	<ol type=1>
	<p><li>
		<a href="${pageContext.request.contextPath}/creditBySemester"> 학기별 이수 학점 조회 </a>
	<p><li>
		<a href="${pageContext.request.contextPath}/creditByDivision"> 이수 구분별 학점 조회 </a>
	<p><li>
		<a href="${pageContext.request.contextPath}/courseRegister"> 수강 신청 </a>
	<p><li>
		<a href="${pageContext.request.contextPath}/registrationDetails"> 수강 신청 조회 </a>
		</ol>
</body>
</html>
