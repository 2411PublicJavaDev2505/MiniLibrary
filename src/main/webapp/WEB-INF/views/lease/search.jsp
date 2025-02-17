<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여 리스트</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/search.css">

</head>
<body>

	<div id = container>
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<main>
		<section class="title">
		<h1>대여 검색</h1>	
		</section>
		
	<section class="content">
		<table class = "user-table">
			<thead>
			<tr class="table-th">
				<th>대여번호</th>
				<th>책 제목 </th>
				<th>고객명</th>
				<th>대여 일자</th>
				<th>반납 일자</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${lList}" var="lease">
						<tr>
							<td>${lease.leaseNo }</td>
							<td>${lease.bookName}</td>
							<td>${lease.userName}</td>
							<td>${lease.leaseDate}</td>
							<td>${lease.returnDate}</td>
						</tr>   
				</c:forEach>
			</tbody>
		</table>
		
		<div class="pagination">
			<c:if test="${startNavi ne 1 }">
				<a href="/total/lease?currentPage=${startNavi -1}" class="prev">&lt;</a>
			</c:if>
				<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
				<a href="/total/lease?currentPage=${p }">${p }</a>
				
				</c:forEach>	
			<c:if test="${endNavi ne maxPage}">
				<a href="/total/lease?currentPage=${endNavi +1 }" class="next">&gt;</a>
			</c:if>
		</div>

	<form action="/total/lease" method="post">
		<select name ="searchCondition">
			<option value="userId"  <c:if test = "${searchCondition eq 'userId'}">selected</c:if> >회원명</option>
			<option value="bookName"  <c:if test = "${searchCondition eq 'bookName'}">selected</c:if> >책 이름</option>
		</select>
		<input type="text" name="searchKeyword" placeholder="검색어를 입력하세요" value="${searchKeyword }">
		<button type="submit" >검색</button>
	</form>


<a href="/total/lease">이전</a>

<!-- <a href="/">메인으로 이동</a> -->



</body>
</html>