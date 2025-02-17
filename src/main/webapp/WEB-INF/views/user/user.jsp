<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/search.css">

</head>
<body>
	<a href="/user/list">1. 회원 전체 조회</a>
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
	<a href="/user/register">4. 회원 가입</a> <br>
<!-- 	<a href="/">7. 메인 메뉴로 이동</a> -->
</body>
</html>