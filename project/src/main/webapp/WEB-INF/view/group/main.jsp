<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Group</title>
<style type="text/css">
.container {
	display: flex;
}
.container .nav_content {
	width: 20%;
	height: 919px;
	background: #fff;
	border-right: 3px solid #000;
}
.container .nav_content .navbar {
	padding: 20px;
}
.container .nav_content .navbar .nav ul {
	list-style: none;
	padding: 20px;
	margin: 0;
	padding: 0;
}
.container .nav_content .navbar .nav ul li {
	text-align: center;
}
.container .content {
	width: 80%;
	height: 919px;
	background: #fff;
}
.content h2 {
	text-align: center;
}
.content .board {
	padding: 0 50px;
	width: 600px;
	float: left;
}
.content .board table {
	width: 500px;
	border-collapse: collapse;
	border-top: 3px solid #000;
	border-bottom: 3px solid #000;
}
.content .board table td{
	border-collapse: collapse;
	border-top: 1px solid #000;
	text-align: center;
}
.content .board table td{
	text-align: center;
}
.content .member {
	width: 400px;
	padding: 0 150px 0 50px;
	float: right;
}
.content .member .memberlist {
	border: 3px solid #000;
}
.content .member .memberlist ul {
	list-style: none;
	padding: 0
}
.content .member .memberlist ul li {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="nav_content">
			<div class="navbar">
				<div class="nav">
					<ul>
						<li>-스터디-
							<ul></ul>
						</li>
						<li>-프로젝트-
							<ul></ul>
						</li>
						<li>-공모전-
							<ul></ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="content">
			<h2>강남 스터디</h2>
			<div class="board">
			<a href="#">공지사항</a>
				<table>
					<tr>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
					<tr>
						<td>Test123</td>
						<td>Test123</td>
						<td>2020-08-10</td>
					</tr>
				</table>
			</div>
			<div class="member">
				<a href="#">인원  (2/5)</a>
				<div class="memberlist">
				<ul>
					<li>admin123</li>
					<li>test123</li>
				</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>