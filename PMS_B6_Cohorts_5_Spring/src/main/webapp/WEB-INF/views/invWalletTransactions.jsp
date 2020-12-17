<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	  margin-left: 10px;
	  height: 50px;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	
	#footer {
		width:80%;
		position: absolute;
		right:9%;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	#content{
		text-align: center;	
		margin-top: 50px;
	}
	span{
		margin: auto;
	}
</style>
<title>Wallet Transactions</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/user/home" id="primaryNavigators">Home</a></div>
			<span class="text-light font-weight-bold" >Wallet Transactions</span>
			<div><a href="${pageContext.request.contextPath}/logout" id="primaryNavigators">Logout</a></div>
		</nav>
	</div>
	
	<div id=content>
		<table id=footer>
			<thead>
				<tr>
					<td colspan="6" style="color: white;font-size:20px;text-align:center"><b>Wallet Transaction Details</b></td>
				<tr>
					<th scope="col" colspan="1">Wallet Id</th>
					<th scope="col" colspan="1">Transaction Type</th>
					<th scope="col" colspan="1">Amount</th>
					<th scope="col" colspan="1">Share Transaction Id</th>
					<th scope="col" colspan="1">Date Time</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="transactions" items="${walletTransactionsDto}">
					<tr>
						<td>${transactions.walletId}</td>
						<td>${transactions.transactionType}</td>
						<td>${transactions.amount}</td>
						<td>
						<core:choose>
						    <core:when test="${transactions.shareTransactionId==0}">
						        <a>NA</a>
						    </core:when>
						    <core:otherwise>
						        <a href="${pageContext.request.contextPath}/user/shareTransaction/${transactions.shareTransactionId}">${transactions.shareTransactionId}</a>
						    </core:otherwise>
						</core:choose>
						</td>
						<td>${transactions.dateTime}</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>