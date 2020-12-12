<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Company</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidebar {
	height: 100%;
	width: 25%;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidebar a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 14px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.generateCommision {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 14px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidebar ol {
	color: #818181;
}

.sidebar ul {
	list-style: square;
	color: #818181;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.sidebar .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

.openbtn {
	font-size: 20px;
	cursor: pointer;
	background-color: #111;
	color: white;
	padding: 10px 15px;
	border: none;
}

.openbtn:hover {
	background-color: #444;
}

#main {
	transition: margin-left .5s;
}

#primaryNavigators{
	color:white;
	position:relative;
}

#logout{
	background-color:red;
	color:white;
	position:relative;
	left:5px;
	padding:5px;
}

.container{
	margin:50px;
}

#modifyCompanyForm{
	margin: auto;
	width: 15%;
	margin-top: 5%;
	border: 3px solid green;
	padding: 10px;
	text-align: center;
}


/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}
</style>
<body>
	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<ol>
			<li><a href="#">Create/Modify Company</a></li>
			<li><a href="#">Create/Modify Commodity</a></li>
			<li>
				<label class="generateCommision">Generate Commission</label>
				<ul>
					<li><a href="#">Annual Report</a></li>
					<li><a href="#">Monthly Report</a></li>
					<li><a href="#">Periodic Report</a></li>
				</ul>
			</li>
		</ol>
	</div>
	<div id="main">

		<nav class="navbar navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" onclick="openNav()"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div><a href="${pageContext.request.contextPath}/bouser/home" id="primaryNavigators">Home</a></div>
			<span>
				<span class="text-light font-weight-bold">Modify Company</span>
			</span>
			<div><spring:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
				</spring:form></div>
		</nav>
	</div>
	
	<div id=modifyCompanyForm>
		<spring:form action="${pageContext.request.contextPath}/bouser/modifyCompany" method="POST" modelAttribute="searchCompanyDto">
			<div>
				<div><spring:label path="companyCode">Company ID</spring:label></div>
				<div><spring:input path="companyCode" type="text" value="${searchCompanyDto.companyCode}"/>
				<spring:errors path="companyCode" cssClass="error"/></div>
			</div>
			<br/> 
			<div>
				<div><spring:label path="companyTitle">Company Title</spring:label></div>
				<div><spring:input path="companyTitle" type="text" value="${searchCompanyDto.companyTitle}"/>
				<spring:errors path="companyTitle" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="operation">Operation</spring:label></div>
				<div><spring:input path="operation" type="text" value="${searchCompanyDto.operation}"/>
				<spring:errors path="operation" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="shareCount">Share Count</spring:label></div>
				<div><spring:input path="shareCount" type="text" value="${searchCompanyDto.shareCount}"/>
				<spring:errors path="shareCount" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="sharePrice">Share Price</spring:label></div>
				<div><spring:input path="sharePrice" type="text" value="${searchCompanyDto.sharePrice}"/>
				<spring:errors path="sharePrice" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="sector">Sector</spring:label></div>
				<div><spring:input path="sector" type="text" value="${searchCompanyDto.sector}"/>
				<spring:errors path="sector" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="currency">Currency</spring:label></div>
				<div><spring:input path="currency" type="text" value="${searchCompanyDto.currency}"/>
				<spring:errors path="currency" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="turnover">Turnover</spring:label></div>
				<div><spring:input path="turnover" type="text" value="${searchCompanyDto.turnover}"/>
				<spring:errors path="turnover" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="dateTimeIPO">Date Time IPO</spring:label></div>
				<div><spring:input path="dateTimeIPO" type="text" value="${searchCompanyDto.dateTimeIPO}"/>
				<spring:errors path="dateTimeIPO" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="stockExchange">Stock Exchange</spring:label></div>
				<div><spring:input path="stockExchange" type="text" value="${searchCompanyDto.stockExchange}"/>
				<spring:errors path="stockExchange" cssClass="error"/></div>
			</div>
			<br/>
			<div>
				<div><spring:label path="ipoPrice">IPO Price</spring:label></div>
				<div><spring:input path="ipoPrice" type="text" value="${searchCompanyDto.ipoPrice}"/>
				<spring:errors path="ipoPrice" cssClass="error"/></div>
			</div>
			<br/>
			<input type="submit" Value="Modify Company">
		</spring:form>
	</div>
	<script>
		function openNav() {
			document.getElementById("mySidebar").style.width = "250px";
			document.getElementById("main").style.marginLeft = "250px";
		}

		function closeNav() {
			document.getElementById("mySidebar").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>

</body>
</html>