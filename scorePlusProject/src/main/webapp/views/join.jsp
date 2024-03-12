<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SCOREPLUS</title>
<style>
body {
	font-family: 'Noto Sans KR', sans-serif;
    font-size: small;
    width: 100%;
	height:  100%;
	background: #eee;
}
#logoTxt{
    color: #e96b56;
    text-align: center;
    font-weight: 700;
}
.main_area{
 width: 30%;
 height: 100%;
 margin: auto;
 margin-top: 15%;
 border: solid 1px #ddd;
 box-shadow: 5px 2px 8px 0px #ddd;
}
.join{
	list-style: none;
	width: 30%;
	margin: auto;
	padding-left: 0;
}
.join li{
	margin: 10px 0px 10px 0px;
}
.join li:nth-child(2){
	display: inline;
}
#btnJoin{
	background: #e96b56;
    color: #fff;
    border-color: #e96b56;
    border-style: solid;
    width: 95%;
}
</style>
</head>
<body>
<main class="main_area">
	<div class="logo">
		<h1 id="logoTxt">SIGN UP</h1>
	</div>
	<div>
	<form action="join.do" id="join" name="join" method="post">
		<ul class="join">
			<li><strong>ID</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="joinid" name="joinid" value=""></li>
			<li><strong>PW</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" id="joinpw" name="joinpw"
				value=""></li>
			<li><strong>NAME</strong>&nbsp;<input type="text" id="joinname" name="joinname"
				value=""></li>
			<li><strong>BIRTH</strong><input type="text" id="joinbirth" name="joinbirth"
				value=""></li>
			<li><input type="submit" value="sign up" class="join" id="btnJoin"></li>
		</ul>
	</form>
	</div>
	<a href="#" onclick="history.back();">뒤로가기</a>
</main>
</body>
</html>