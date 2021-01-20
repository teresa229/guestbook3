<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/guestbook3/guestbook/delete" method="get">
			비밀번호 : <input type = "password" name="password">
			<c:if test="${requestScope.result == 0}">
				<p>비밀번호를 잘못 입력하셨습니다.</p>
			</c:if>
			<button type="submit">확인</button>
			
			<input type="hidden" name="no" value="${param.no}">		
		</form>
		<br>
		<a href="/guestbook3/guestbook/list">메인으로 돌아가기</a>
</body>
</html>