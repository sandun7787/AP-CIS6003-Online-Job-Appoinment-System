<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa FA-sharp fa-solid fa-user-secret fa-beat-fade fa-2xl"></i> ONLINE JOB APPOINMENT SYSTEM</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link active-toggle" href="index.jsp">HOME</a></li>
				<li class="nav-item"><a class="nav-link active-toggle" href="AdminConsulterManager.jsp">CONSULTER</a></li>
				<li class="nav-item"><a class="nav-link active-toggle" href="getadminconsulter?actionType">VIEW CONSULTER</a></li>
				<li class="nav-item"><a class="nav-link active-toggle" href="patient.jsp">JOB SEEKERS</a></li>


			</ul>

			<form class="d-flex">
				<div class="dropdown">
					<button class="btn btn-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">Admin</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="AdminLogOut">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>