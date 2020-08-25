<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TIL</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.container {
	margin: 0;
	padding: 0;
	max-width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}
.container .header_Area {
	width: 100vw;
	height: 30vh;
	background: linear-gradient(45deg, #ee5454, #8572EE);
}
.container .header_Area .search_Area {
	text-align: center;
	padding: 70px;
}
.container .header_Area .search_Area h2 {
	color: #fff;
	font-style: italic;
	font-weight: bold;
	font-size: 2rem;
}
.container .header_Area .search_Area .search {
	padding: 30px;
	display: flex;
	justify-content: center;
}
.container .header_Area .search_Area .search input {
	width: 15vw;
	border-radius: 5px;
	border: none;
	height: 40px;
	padding-left: 20px;
}
.container .header_Area .search_Area .search input:focus {
	outline: none;
}
.container .header_Area .search_Area .search .search_button {
	width: 40px;
	height: 40px;
	background: #fff;
	border-radius: 5px;
	margin-left: 5px;
	display: flex;
	justify-content: center;
	align-items: center;
	cursor: pointer;
	transition: 0.5s;
}

.container .header_Area .search_Area .search .search_button:hover {
	box-shadow: 3px 3px 3px rgba(0, 0, 0, .2);
}
.container .header_Area .search_Area .search .search_button i {
	color: #54a0ee;
}
.container .searchArea {
	width: 100vw;
	margin-top: 4vh;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 0 10vw;
}

.container .searchArea .filter {
	float: left;
	padding: 0;
	font-size: 18px;
	font-weight: bold;
}

.container .searchArea .filter a {
	text-decoration: none;
	color: #000;
	padding: 3px 5px;
	transition: 0.5s;
}
.container .searchArea .filter span a {
	border-bottom: 2px solid #fff;
}
.container .searchArea .filter span a:hover {
	border-bottom: 2px solid #f00;
	transition: 0.5s;
}
.container .searchArea .plus {
	float: right;
	padding: 0;
}

.container .searchArea .plus .box {
	border: 2px solid lightcoral;
	background: #ffcccc;
	border-radius: 5px;
	width: 34px;
	height: 34px;
	display: flex;
	justify-content: center;
	align-items: center;
	cursor: pointer;
	transition: 0.5s;
}
.container .searchArea .plus .box:hover {
	box-shadow: 1px 1px 1px rgba(0, 0, 0, .2);
}
.container .searchArea .plus .box a {
	color: #ff0000;
	background: transparent;
	transition: 0.5s;
}
.container .searchArea .plus .box:hover a {
	color: #fff;
}
.container .content {
	display: flex;
	justify-content: flex-start;
	padding: 0 10vw;
	margin-top: 30px;
	width: 100%;
}
.container .content .optionbox{
	width: 20%;
	padding: 20px 10px;
}

.container .content .optionbox .hashbox #hashinput {
	width: 100%;
	margin-top: 20px;
	padding-left: 5px;
}

.container .content .optionbox .hashbox #searchhash {
	margin-top: 10px;
	background: #00b8f4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 30px;
	border-radius: 5px;
	cursor: pointer;
	transition: 0.5s;
}
.container .content .optionbox .hashbox #searchhash:hover {
	box-shadow: 3px 3px 3px rgba(0, 0, 0, .2);
}
.container .content .optionbox .hashbox #searchhash i {
	color: #fff;
}
.container .content .contentbox{
	display: flex;
	flex-wrap: wrap;
	flex-direction: row;
	width: 100%;
	justify-content: center;
}
.container .content .container-fluid {
	padding: 15px;
	margin: 0;
	width: auto;
} 
.card {
	position: relative;
	width: 250px;
	height: 185px;
	overflow: hidden;
	font-family: 'Roboto Condensed', sans-serif !important;
	transition: 0.5s;
}
.card:hover {
	box-shadow: 5px 5px 5px rgba(0, 0, 0, .1);
}
.card .news-content {
	position: absolute;
	padding: 10px 20px 60px;
	background: #fff;
	transition: .5s;
	height: 155px;
	width: 250px;
}


.card .news-content .post-meta {
	font-size: 12px;
}

.card .news-content .post-meta .author a {
	text-decoration: none;
	padding-right: 10px;
	color: black;
	font-weight: bold;
	transition: .5s;
}

.card .news-content .post-meta .time {
	padding-right: 10px;
	color: black;
	font-weight: bold;
	transition: .5s;
}

.card .news-content .post-meta .author a:hover {
	color: #DF084A;
}

.card .news-content .post-header {
	margin: 0;
	padding: 10px 0;
	color: #007DA6;
	height: 50px;
	font-size: 18px;
	overflow: hidden;
	font-weight: bold;
}

.card .news-content .hashlist {
	font-size: 16px;
	margin: 0 0 10px;
	padding: 0;
	color: black;
	transition: .5s;
	opacity: 1;
	height: 40px;
	display: flex;
	flex-wrap: wrap;
	justify-content: flex-start;
}

.card:hover .news-content .hashlist a:hover {
	color: #DF084A;
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header_Area">
			<div class="search_Area">
				<h2>Expand your knowledge.</h2>
				<div class="search">
				<input type="text" placeholder="Search..." id="searchinput">
				<div class="search_button" id="search"><i class="fa fa-search"></i></div>
				</div>
			</div>
		</div>
		<div class="searchArea">
			<div class="filter">
				<span><a href="#">최신순</a>&nbsp;/</span> <span><a href="#">트렌딩</a>&nbsp;/</span>
				<span><a href="#">구독 TIL</a></span>
			</div>
			<div class="plus">
				<div class="box">
					<a href="write.dev"><i class="fa fa-plus"></i></a>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="contentbox">
			<c:forEach var="data" items="${tillist}">
				<div class="container-fluid">
					<div class="container">
						<div class="row">
							<div class="col-sm-4">
								<div class="card">
									<div class="news-content">
										<h2 class="post-header">
											<a href="${path}/til/info.dev?bno=${data.bno}&no=${data.no}">${data.title }
											</a>
										</h2>
										<%-- <div class="hashlist">
											<c:forEach var="hash" items="${data.hashlist }">
												<a><span>#${hash }</span></a>&nbsp;
											</c:forEach>
										</div> --%>
										<div class="post-meta">
											<span class="author"><a href="#"> <i class="fa fa-user"></i> ${data.name }</a></span> 
											<span class="time"> <i class="fa fa-clock-o"></i> <fmt:formatDate value="${data.regdate}" pattern="yyyy-MM-dd" /></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="optionbox">
				<div class="checkbox-btn">
					<input type="checkbox" name="">
					<div>
						<span class="slide"></span>
					</div>
				</div>
				<div class="hashbox">
					<input type="text" placeholder="관련 기술" id="hashinput">
					<div class="search_button" id="searchhash"><i class="fa fa-search"></i></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".container .searchArea .plus .box").click(function() {
				location.href = "write.dev";
			})
		})
	</script>
</body>
</html>
