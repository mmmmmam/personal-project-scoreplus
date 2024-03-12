<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
<%@ include file="include/header.jsp" %>
<main>
<div class="my_profile_area">
	<h2>My Profile</h2>
	<table id="tableList">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>BIRTH</th>
				<th>JOIN DATE</th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td>${cstprofile.cst_id }</td>
				<td>${cstprofile.cst_name }</td>
				<td>${cstprofile.cst_birth }</td>
				<td>${cstprofile.cst_rgsdate }</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="change_pw_area">
	<h3>Change Information</h3>
	<hr>
		<div>
			<form action="myProfile.do" method="post">
				<strong>New Password</strong>
				<input type="password" name="newpass">
				<input type="submit" value="Change" >
			</form>
		</div>
</div>
</main>
<%@ include file="include/footer.jsp" %>
<script>
		var str = "${param.message}";
		
		if(str!=""){
			alert(str);
		}
</script>
</body>
</html>