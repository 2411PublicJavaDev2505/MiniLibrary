<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/search.css">
</head>
<body>
	<div class="search-container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<h1>회원정보</h1>
	<table class="user-table">
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>주소</th>
			<th>성별</th>
		</tr>
		<tbody>
		<c:forEach items="${searchList }" var ="user" varStatus = "i">
			<tr>
				 
				<td>${searchList.size() - i.index }</td>
				<td><a href="/user/mypage?userId=${user.userId }">${user.userId}</td>
				<td>${user.userName }</td>
				<td>${user.age }</td>
				<td>${user.userAddr }</td>
				<td>${user.gender }</td>
				<td>${user.enrollDate }</td>
			</tr>
		</c:forEach>				
		</tbody>
	</table>
			<form class="search-form" action="/user/search" method="get">
				<select class="search-select" name="searchCondition">
					<option value="name" <c:if test="${searchCondition eq 'name'}">selected</c:if>>이름</option>
					<option value="id" <c:if test="${searchCondition eq 'id'}">selected</c:if>>아이디</option>
					</select>
					<input type="text" class="search-input" name="searchKeyword" value = "${searchKeyword}">
				<button type="submit" class="search-button">검색</button>
			</form>
	</div>
</body>
</html>