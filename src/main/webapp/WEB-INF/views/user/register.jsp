<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../resources/css/header.css">
<link rel="stylesheet" href="../resources/css/register.css">
</head>
<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<div id="container">
	<main>
		<div class="title">
				<h1>회원가입</h1>	
		</div>
			<div >
				<form class="register-form"  action="/user/register" method = "post">
				<div class="form-group">
					<label class="required">아이디 </label> 
					<input type = "text" name = "userId"> 
				</div>
				<div class="form-group">
					<label class="required">이름 </label> 
					<input type = "text" name = "userName"> 
				</div>
				<div class="form-group">
					<label class="required">나이 </label> 
					<input type = "number" min="14" name = "age">
				</div>
				<div class="form-group">
					<label class="required">주소 </label> 
					<input type = "text" name = "userAddr">
				</div>
				<div class="form-group">
					<label class="required">성별 </label>
					<div class="radio-group">
					<label>
					 <input type = "radio" name = "gender" value ="M">남					
					</label>
					<label>
					 <input type ="radio" name = "gender" value="F">여									
					</label>
					</div>
				</div>
					<button type="submit" class="register-button">회원가입</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>