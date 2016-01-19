<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">




<title>CS - Graduate Admission</title>
</head>

<body background="http://www.kwiatki.org/kwiaty/grafika-kwiaty-2.jpeg">



	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">

				<p>
					<a href="AddNewApplication">Add New Application</a>
				</p>

				<div class="form" class="form-horizontal">
					<table class="table table-bordered table table-striped ">



						<tr>
							<th><a href="CsGradAdmiMain?sort=applicant"> Applicant </a></th>
							<th><a href="CsGradAdmiMain?sort=dates"> Application Received On </a></th>
							<th><a href="CsGradAdmiMain?sort=gpa"> GPA </a></th>
							<th><a href="CsGradAdmiMain?sort=status"> Status </a></th>
							<th>Operations</th>
						</tr>

						<c:forEach items="${entries}" var="entry" varStatus="status">
							<tr>
								<td>${entry.applicant}</td>
								<td><fmt:formatDate pattern="M/d/yyyy"
										value="${entry.date}" /></td>
								<td>${entry.gpa}</td>
								<td>${entry.status}</td>
								<td><a href="EditApplication?index=${status.index}">Edit</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>

		</div>
	</div>

</body>
</html>