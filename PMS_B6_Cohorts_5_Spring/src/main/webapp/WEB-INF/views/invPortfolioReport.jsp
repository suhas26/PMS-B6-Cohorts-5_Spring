<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Portfolio Report</title>
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
	width: 0;
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
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
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
.search{
	margin:2%;
	display: flex;
    justify-content: center;
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
span{
	margin: auto;
}
#errors{
	color:red;
}

table, th, td {
	  margin-left: 10px;
	  height: 50px;
	  border: 1px solid black;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	table{
		width:80%;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
</style>
<body>
	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<a href="${pageContext.request.contextPath}/user/home">Dashboard</a> 
		<a href="${pageContext.request.contextPath}/user/searchCompany">Search Company</a>
		<a href="${pageContext.request.contextPath}/user/searchCommodity">Search Commodity</a> 
		<a href="#">Sector</a>
		<a href="#">Portfolio Report</a> 
		<a href="${pageContext.request.contextPath}/user/wallet">Wallet</a>
	</div>
	<div id="main">

		<nav class="navbar navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" onclick="openNav()"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div><a href="${pageContext.request.contextPath}/user/home" class="text-light font-weight-bold" id="primaryNavigators">Home</a></div>
			<span class="text-light font-weight-bold">Portfolio Report</span>
			<div><a href="${pageContext.request.contextPath}/logout" class="text-light font-weight-bold">Logout</a></div>
		</nav>
		<h4 id="errors" class="search">${message}</h4>
		<div class="search">
			
		</div>
	</div>
	<hr/>
	<div class="search">
		<table>
			<thead>
				<tr>
					<td>Stock Name</td>
					<td>Company/Commodity</td>
					<td>Quantity</td>
					<td>Avg Price</td>
					<td>Invested Amount</td>
					<td>Current Price</td>
					<td>Current Total Amount</td>
					<td>Profit/Loss</td>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="portfolio" items="${portfolioReportDto}">
					<tr>
						<td>
							<core:choose>
							  <core:when test="${portfolio.companyCommodity=='Company'}">
							    <a href ="${pageContext.request.contextPath}/user/company/${portfolio.stockName}">${portfolio.stockName}</a>
							  </core:when>
							  <core:when test="${portfolio.companyCommodity=='Commodity'}">
							   <a href ="${pageContext.request.contextPath}/user/commodity/${portfolio.stockName}">${portfolio.stockName}</a>
							  </core:when>
							</core:choose>
						</td>
						<td>${portfolio.companyCommodity}</td>
						<td>${portfolio.stockQuantity}</td>
						<td>${portfolio.avgStockPrice}</td>
						<td>${portfolio.investedAmount}</td>
						<td>${portfolio.currentStockPrice}</td>
						<td>${portfolio.currentAmount}</td>
						<td>${portfolio.earning}</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function openNav() {
			document.getElementById("mySidebar").style.width = "270px";
			document.getElementById("main").style.marginLeft = "250px";
		}

		function closeNav() {
			document.getElementById("mySidebar").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>

</body>
</html>