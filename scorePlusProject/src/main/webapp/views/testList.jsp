<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
<%@ include file="include/header.jsp" %>
<main>
<div class="select_area">
 <form action="">
 	<span>검색년도</span>
 	<select>
 	<option>2023</option>
 	<option>2022</option>
 	<option>2021</option>
 	<option>2020</option>
 	</select>
 </form>
</div>
<div class="test_list_area">
	<table id="tableList">
		<thead>
			<tr>
				<th>Test Name</th>
				<th>Test Round</th>
				<th>Test Date</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Registration</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${tlist }" var="test">
			<tr>
				<td>${test.test_name }</td>
				<td>${test.test_round }</td>
				<td>${test.test_date }</td>
				<td>${test.test_rgsstart }</td>
				<td>${test.test_rgsend }</td>
				<td>
					<c:choose>
						<c:when test="${test.test_yn == 'Y'}">
						<form action="rgsList.do" id="rgs" name="rgs" onsubmit="return putRgsTest()" method="post">
							<input type="text" hidden="true" name="testId" value=${test.test_id }></input>
							<button type="submit" class="rgs_btn">Registration</button>
						</form>
						</c:when>
						<c:otherwise>
							${test.test_yn }
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		 
	</table>
</div>
</main>
<%@ include file="include/footer.jsp" %>
<script>

	window.onload = function(){
		var str = "${param.rspCd}";
		
		if(str!=""){
			var a;
			
			if(str == "0000"){
				
			}else if(str == "0001"){
				a = "접수 실패하였습니다.";
				alert(a);
			}else{
				a = "중복접수는 불가합니다.";
				alert(a);
			}
			
		}

	}
	
	function putRgsTest() {
		var confirmYn = confirm("시험 접수 하시겠습니까?");
		return confirmYn;
	}
	
</script>
</body>
</html>