<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/main.css">
<link rel="stylesheet" href="../resources/css/list.css">
<link rel="stylesheet" href="../resources/css/search.css">
<link rel="stylesheet" href="../resources/css/register.css">

</head>
<body>

	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
	<div id="container">
		<main>
			<div class="title">

				<h1>도서 대여 정보</h1>
					<form class="register-form" action="/insert/lease" method="post">
						<div class="form-group">		
							<label class="required">책 제목</label>	
							<input type="text" name ="bookTitle"><br>
						</div>
						<div class="form-group">	
							<label class="required">고객명</label>	
							<input type="text" name ="userName"><br>
						</div>
						<div class="form-group">	
							<label class="required">대여일</label> 
							<input type="date" name = "leaseDate"><br>
						</div>
				
				
				<button type="submit">저장</button>
					</form>

			</div>
		</main>
	</div>



</body>
</html>