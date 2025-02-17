<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 추가하기</title>
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/register.css">
</head>
<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<div id="contrainer">
	<main>
		<div class ="title">
			<h1>책 추가하기</h1>
		</div>
			<div>
				<form class="register-form" action ="/book/add" method = "post"> 
					<div class="form-group">
						<label>번호</label>
						<input type = "text" name = "bookNo">
					</div>
					<div class="form-group">
						<label>제목</label>
						<input type = "text" name = "bookName">
					</div>
					<div class="form-group">
						<label>작가</label>
						<input type = "text" name = "bookWriter">
					</div>
					<div class="form-group">
						<label>가격</label>
						<input type = "text" name = "bookPrice">
					</div>
					<div class="form-group">
						<label>출판사</label>
						<input type = "text" name = "publisher">
					</div>
					<div class="form-group">
						<label>장르</label>
						<input type = "text" name = "genre">
					</div>
					<button type = "submit" class = "register-button">저장</button> 
				</form>
			</div>
		</main>
	</div>
</body>
</html>