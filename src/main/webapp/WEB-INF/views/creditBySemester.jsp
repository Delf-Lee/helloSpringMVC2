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

<h1 class="h">학기별 이수 학점 조회</h1>
<body>
	<table class="formtable">
		<tr>
			<td class="title">년도</td>
			<td class="title">학기</td>
			<td class="title">학점</td>
			<td class="title">자세히</td>
		</tr>
		<c:forEach var="creditBySemester" items="${creditBySemester}">
			<tr>
				<td class="label"><c:out value="${creditBySemester.year}"></c:out></td>
				<td class="label"><c:out value="${creditBySemester.semester}"></c:out></td>
				<td class="label"><c:out value="${creditBySemester.credit}"></c:out></td>
				<td class="detailLink"><a
					href="${pageContext.request.contextPath}/courseListBySemester?year=${creditBySemester.year}&semester=${creditBySemester.semester}">link</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<a href="${pageContext.request.contextPath}"> go home </a>
</html>