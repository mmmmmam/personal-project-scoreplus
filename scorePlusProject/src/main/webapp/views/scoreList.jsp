<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
	<%@ include file="include/header.jsp"%>
	<main>
		<div class="test_list_area">
			<h2>My Score</h2>
			<table id="tableList">
				<thead>
					<tr>
						<th>Test Name</th>
						<th>Test Round</th>
						<th>Test Date</th>
						<th>Score</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${slist}" var="score">
						<tr>
							<td>${score.test_name}</td>
							<td>${score.test_round }</td>
							<td>${score.test_date }</td>
							<td>${score.score }</td>
						</tr>
					</c:forEach>


				</tbody>

			</table>
		</div>

	</main>
	<%@ include file="include/footer.jsp"%>
</body>
</html>