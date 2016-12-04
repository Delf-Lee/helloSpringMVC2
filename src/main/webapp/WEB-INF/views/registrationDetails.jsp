<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/myStyle.css" />
</head>

<h1 class="h">수강 신청 현황</h1>
<body>
	<table class="formtable">
		<tr>
			<td class="title">년도</td>
			<td class="title">학기</td>
			<td class="title">과목코드</td>
			<td class="title">과목명</td>
			<td class="title">구분</td>
			<td class="title">학점</td>
		</tr>
		<c:forEach var="registrationDetails" items="${registrationDetails}">
			<tr>
				<td class="label"><c:out value="${registrationDetails.year}"></c:out></td>
				<td class="label"><c:out
						value="${registrationDetails.semester}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.code}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.title}"></c:out></td>
				<td class="label"><c:out
						value="${registrationDetails.division}"></c:out></td>
				<td class="label"><c:out value="${registrationDetails.credit}"></c:out></td>
			</tr>
		</c:forEach>
	</table>



</body>
<p>
	<a href="${pageContext.request.contextPath}/courseRegister">
		수강신청 더 하기 </a>
</p>
<p>
	<a href="${pageContext.request.contextPath}"> go home </a>
</p>
</html>