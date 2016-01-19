<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New Application</title>
</head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<body background="http://www.kwiatki.org/kwiaty/grafika-kwiaty-2.jpeg">

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">



				<form action="AddNewApplication" method="post">


					<div class="form" class="form-horizontal">
						<table class="table table-bordered table table-striped ">

					<p>	<a href="CsGradAdmiMain"> CS Grad Admission </a> >  Add New Application </p>	

			
							<tr>
								<td>Applicant:</td>
								<td><input type="text" name="applicant"></td>
							</tr>

							<tr>
								<td>Application Received On (M/d/yyyy):</td>
								<td><input type="text" name="date"></td>
							</tr>

							<tr>
								<td>GPA:</td>
								<td><input type="text" name="gpa"></td>
							</tr>

							<tr>
								<td>Status:</td>

								<td><select name="stats">

										<c:forEach items="${statuslst}" var="stats"
											varStatus="statuss">

											<option value="${statuss.index}">${stats}</option>

										</c:forEach>
								</select></td>
							</tr>

							<tr>
								<td></td>
								<td><input type="submit" name="Add" value="Add"></td>
							</tr>

						</table>
					</div>


				</form>

			</div>
		</div>
	</div>


</body>
</html>