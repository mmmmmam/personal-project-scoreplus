<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<title>SCOREPLUS</title>
<style type="text/css">
body {
	font-family: 'Noto Sans KR', sans-serif;
    font-size: small; 
}
#logoTxt{
    color: #e96b56;
    text-align: center;
    font-weight: 700;
}
body{
	width: 100%;
	height:  100%;
	background: #eee;
}
.main_area{
 width: 30%;
 height: 100%;
 margin: auto;
 margin-top: 15%;
 border: solid 1px #ddd;
 box-shadow: 5px 2px 8px 0px #ddd;
}
.login{
	list-style: none;
	width: 30%;
	margin: auto;
	padding-left: 0;
}
.login li{
	margin: 10px 0px 10px 0px;
}
.login li:nth-child(2){
	display: inline;
}
#btnLogin{
	background: #e96b56;
    color: #fff;
    border-color: #e96b56;
    border-style: solid;
    width: 85%;
}
#btnJoin{
	background: #ddd;
    color: #000;
    border-color: #ddd;
    border-style: solid;
    width: 85%;
}
</style>
</head>
<body>

<main class="main_area">
	<div class="logo">
		<h1 id="logoTxt">SCOREPLUS</h1>
	</div>
	<div class="loginField">
		<form action="loginCheck.do" id="frmLogin" name="frmLogin" method="post">
		    <ul class="login">
		        <li>
					<strong>ID</strong>&nbsp;&nbsp;<input type="text" id="cstid" name="cstid" value="" onclick="">       
		        </li>
		        <li>
		        	<strong>PW</strong><input type="password" id="cstpw" name="cstpw" value="">
				</li>
		        <li>
		            <input type="submit" value="Log In" class="login_btn" id="btnLogin" onclick="">	
	            </li>
	            <li>
		            <input type="button" value="Sign Up" class="login_btn" id="btnJoin" onclick="location.href='join.do'">
	            </li>
		    </ul>
		</form>
	</div> 
</main>

</body>
</html>