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

<h1 class="h">이수 구분별 학점 조회</h1>
<body>
	<table class="formtable">
		<tr>
			<c:forEach var="creditByDivision" items="${creditByDivision}">
				<td class="title"><c:out value="${creditByDivision.division}"></c:out></td>
			</c:forEach>
			<td class="title">합계
		</tr>
		<tr>
			<c:forEach var="creditByDivision" items="${creditByDivision}">
				<td class="label"><c:out value="${creditByDivision.credit}"></c:out></td>
			</c:forEach>
			<td class="totalCredits">${totalCredits}
		</tr>
	</table>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>