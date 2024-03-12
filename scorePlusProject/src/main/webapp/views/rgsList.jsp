<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
<%@ include file="include/header.jsp" %>
<main>
	<div class="test_list_area">
	<h2>My Registration</h2>
		<table id="tableList">
			<thead>
				<tr>
					<th>Registration Number</th>
					<th>Test Name</th>
					<th>Test Round</th>
					<th>Test Date</th>
					<th>Cancel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rlist }" var="rgs">
				<tr>
					<td>${rgs.rgs_no }</td>
					<td>${rgs.test_name }</td>
					<td>${rgs.test_round }</td>
					<td>${rgs.test_date }</td>
					<td>
						<c:choose>
							<c:when test="${rgs.cancel_yn == 'Y' }">
							<form action="rgsCancel.do" id="rgs" name="rgs" onsubmit="return cancelRgsTest()" method="post">
								<input type="text" hidden="true" name="rgsno" value=${rgs.rgs_no }>
								<button type="submit" class="cancel_btn">Cancel</button>
							</form>
							</c:when>
							<c:otherwise>
								${rgs.cancel_yn }
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
	function cancelRgsTest() {
		var confirmYn = confirm("접수 취소 하시겠습니까?");
		return confirmYn;
	}
</script>
</body>
</html>