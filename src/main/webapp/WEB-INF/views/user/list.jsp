<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>회원정보 출력</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/search.css">
<link rel="stylesheet" href="../resources/css/booklist.css">

</head>
<body>

	<div id = container>
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
		<main>
		<section class="title">
		<h1>회원정보</h1>	
		</section>
		
			<section class="content">
	<table class = "user-table">
			<tr class="table-th">
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th class="age">나이</th>
				<th>주소</th>
				<th>성별</th>
			</tr>
				<tbody>
				<c:forEach items="${uList }" var ="user" varStatus = "i">
						<tr>
<%-- 							<td>${uList.size() - i.index }</td> --%>
							<td>${user.userNo}</td>
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
			<div class="pagination">
						<c:if test="${startNavi ne 1 }">
							<a href="/user/list?currentPage=${startNavi -1}" class="prev">&lt;</a>
						</c:if>
							<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
							<a href="/user/list?currentPage=${p }">${p }</a>
							
							</c:forEach>	
						<c:if test="${endNavi ne maxPage}">
							<a href="/user/list?currentPage=${endNavi +1 }" class="next">&gt;</a>
						</c:if>
					</div>
	
	<div class="search-container">
				<form class="search-form" action="/user/search" method="get">
				
			
			

	
	
					<select class="search-select" name="searchCondition">
						<option value="name" >이름</option>
						<option value="id" selected>아이디</option>
					</select>
					<input type="text" class="search-input" name="searchKeyword">
					<button type="submit" class="search-button">검색</button>

				</form>
			</div>
			 <div class="register">
            	<ul class = "topMenu">
					<a href="/user/register">회원 가입</a> <br>
	            </ul>
        	 </div>
	</section>	
<!-- 	<a href="/">메인 메뉴로 이동</a> -->
	
	</main>
	</div>	
	
	
</body>
</html>