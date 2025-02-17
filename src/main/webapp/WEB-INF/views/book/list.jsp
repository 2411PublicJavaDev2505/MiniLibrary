<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 책 조회</title>
	<link rel="stylesheet" href="../resources/css/list.css">
	<link rel="stylesheet" href="../resources/css/booklist.css">
	<link rel="stylesheet" href="../resources/css/header.css">
</head>
<body>
	<div id="container">
	<main>
	<jsp:include page = "/WEB-INF/views/include/header.jsp"></jsp:include>
		<section class="board-content">
		<h1>전체 책 조회</h1>
		</section>

		<section class="board-content">
			<table class="user-table">
				<thead>
					<tr>
						<th class = "bookNo">책 번호</th>
						<th class = "bookName">제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${nList }" var="book">
						<tr>
							<td class = "bookNo">${book.bookNo }</td>
							<td class = "bookName"><a href="/book/detail?bookNo=${book.bookNo }">${book.bookName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		<br>
		
		<div class="pagination">
			<c:if test="${startNavi ne 1 }">
				<a href="/book/list?currentPage=${startNavi -1}" class="prev">&lt;</a>
			</c:if>
				<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
				<a href="/book/list?currentPage=${p }">${p }</a>
				
				</c:forEach>	
			<c:if test="${endNavi ne maxPage}">
				<a href="/book/list?currentPage=${endNavi +1 }" class="next">&gt;</a>
			</c:if>
		</div>
		
		
		
		
			<div class = "search-container">
				<form class = "search-form" action = "/book/search" method="get">
					<select class = "search-select" name = "searchCondition">
						<option value = "bookNo">책 번호</option>
					</select>
					<input type = "text" class="search-input" name="searchKeyword" placeholder="책 번호를 입력하세요">
					<button type = "submit" class="search-button">검색</button>
				</form>
			</div>
		 <nav id="nav">
            <ul class = "topMenu">
                <li><a href="/book/add">책 추가하기</a></li>
            </ul>
         </nav>
	</main>
	</div>
</body>
</html>