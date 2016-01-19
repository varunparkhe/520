<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Application</title>
</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<body background="http://www.kwiatki.org/kwiaty/grafika-kwiaty-2.jpeg">

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">


				<form action="EditApplication" method="post">

					<div class="form" class="form-horizontal">
						<table class="table table-bordered table table-striped ">

            			<p>	<a href="CsGradAdmiMain"> CS Grad Admission </a> >  Edit Application </p>
							

							<tr>
								<td>Applicant:</td>
								<td><input name="applicant" type="text"
									value="${entry.applicant}"></td>
							</tr>

							<tr>
								<td>Application Received On (M/d/yyyy):</td>
								<td><input type="text" name="date"
									value="<fmt:formatDate pattern="M/d/yyyy" value="${entry.date}" />" />
								</td>
							</tr>

							<tr>
								<td>GPA:</td>
								<td><input type="text" name="gpa" value="${entry.gpa}">
								</td>
							</tr>

							<tr>
								<td>Status:</td>



								<td><select name="stats">

										<c:forEach items="${statuslst}" var="stats"
											varStatus="statuss">

											<option value="${statuss.index}"
												${statuss.index == param.index ? 'selected' : '' }>${stats}</option>

										</c:forEach>
								</select>
							</tr>

							<input type="hidden" name="index" value="${param.index}" />

							<tr>
								<td></td>
								<td><input type="submit" name="edit" value="Save"></td>
							</tr>

						</table>
					</div>






				</form>




			</div>
		</div>
	</div>




</body>
</html>