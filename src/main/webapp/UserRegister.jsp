<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@include file ="component/allcss.jsp" %>
<style type="text/css">


      
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

<title>USER REGISTRATION</title>
</head>
<body>
<%@include file="component/navbar.jsp" %>


<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">JOB SEEKER REGISTER</p>
						
						<p style="color:magenta">${feedbackmessage}</p>

						
				

						<form action="UserRegister" method="post">
							<div class="mb-3">
								<label class="form-label">First Name</label> <input required
									name="firstname" type="text" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">last Name</label> <input required
									name="lastname" type="text" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email address</label> <input required
									name="email" type="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">confirm Password</label> <input required
									name="confirmpassword" type="password" class="form-control">
							</div>
							
                             <input type="hidden" name="actionType" value="add"/>
							<button   type="submit" class="btn bg-success text-white col-md-12">Register</button>
							
							<p style="color:magenta">${feedbackmessage}</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>