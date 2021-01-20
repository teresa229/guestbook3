<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action = "/guestbook3/guestbook/insert" method ="get">
			
			<table border ="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols =60 rows=5 name="content" ></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
			</table>
			<input type="hidden" name="action" value="insert">   <!-- 확인해보자 -->
		</form>
				
		<!-- for(int i = 0; i < guestList.size(); i++) -->
		<c:forEach items="${requestScope.gList}" var="gvo">
		<br>
			<table border ="1">
				<tr>
					<td>${gvo.no}</td>                                                         <!-- guestList.get(i).getNo() --> 
					<td>${gvo.name}</td>                                                       <!-- guestList.get(i).getName() -->
					<td>${gvo.regDate}</td>                                                    <!-- guestList.get(i).getRegDate() -->
					<td><a href="/guestbook3/guestbook/deleteForm?no=${gvo.no}">삭제</a></td>   <!-- guestList.get(i).getNo() -->
				</tr>
				<tr>
					<td colspan = "4">${gvo.content}</td>                                      <!-- guestList.get(i).getContent() -->
				</tr>
			</table>
		</c:forEach>
</body>
</html>