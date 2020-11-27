<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	
	#footer {
		width:80%;
		position: absolute;
		right:15%;
	}
	.company{
		width:85%;
		height:60px;
		margin-left:50px;
		text-align: center;
	}
	#logout{
		background-color:red;
		color:white;
		position:relative;
	}
	.container{
		position:absolute;
		left:1000px;
		top:70px;
	}
	#currentPrice{
		margin-left:100px;
		position: relative;
		top:10px;
		border: 2px solid red;
		width:250px;
		text-align: center;
		height: 90px;
		background: #5CACEE;
		color: white;
	}
	#content{
		text-align: center;	
	}
	span{
		margin: auto;
	}
</style>
<title>Company</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >Company Page</span>
			</span>
			<div><a href="#" id="logout">Logout</a></div>
		</nav>
	</div>
	
	<div id=currentPrice>
		<h5>Current Price</h5>
		<hr>
		<h6>38$</h6>
	</div>
	<div>
		<br/>
		<table class="company">
			<thead>
				<tr>
					<th scope="col" colspan="1">Company Code</th>
					<th scope="col" colspan="1">Company Title</th>
					<th scope="col" colspan="1">Operations</th>
					<th scope="col" colspan="1">Share Count</th>
					<th scope="col" colspan="1">Sector</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>123456</td>
					<td>Unilever</td>
					<td>Healthcare</td>
					<td>100000</td>
					<td>Healthcare</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th scope="col" colspan="1">Currency</th>
					<th scope="col" colspan="1">Turnover</th>
					<th scope="col" colspan="1">Stock Exchange</th>
					<th scope="col" colspan="1">IPO Date</th>
					<th scope="col" colspan="1">IPO Price</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>$</td>
					<td>900 M</td>
					<td>US</td>
					<td>1/1/2019</td>
					<td>30</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class=container>
		<form action="addMoney" method="post">
			<input type="text" id="cash" name="cash" placeholder="Amount">
			<input type="submit" value="Buy">
		</form>
		
		<form action="withdrawMoney" method="post">
			<input type="text" id="cash" name="cash" placeholder="Amount">
			<input type="submit" value="Sell">
		</form>
	</div>
	<hr/>
	
	<div id=content>
		<table id=footer>
			<thead>
				<tr>
					<td colspan="4" style="color: white;font-size:20px;text-align:center"><b>Historical Prices</b></td>
				<tr>
					<th scope="col" colspan="1">Company Name</th>
					<th scope="col" colspan="1">Price</th>
					<th scope="col" colspan="2">Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Unilever</td>
					<td>10</td>
					<td>05/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Unilever</td>
					<td>11</td>
					<td>04/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Unilever</td>
					<td>12</td>
					<td>03/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Unilever</td>
					<td>10</td>
					<td>02/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Unilever</td>
					<td>10</td>
					<td>01/11/2020 12 :00 PM</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>