<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
  margin: auto;
  
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
<style type="text/css">
	.leftcol {text-align: left; vertical-align: top;}
	.lefttoptable{
		height: 250px;	border-width: 0px;
		text-align: left;	vertical-align: top;	padding: 0px;
	}
</style>
</head>
<body>
<br><br><br><br><br>
<table id="customers"><tr><td colspan="2">QnA 게시판</td></tr>
	<tr><td width="15%">글쓴이</td>
		<td width="85%" class="leftcol">${board.name}</td></tr>
	<tr><td>제목</td><td class="leftcol">${board.title}</td></tr>
	<tr><td>내용</td><td class="leftcol">
		<table class="lefttoptable">
		<tr><td class="leftcol lefttoptable">${board.content}</td></tr>
		</table></td></tr>

	<tr><td colspan="2">
		<a href="reply.shop?num=${board.no}">[답변]</a>
		<a href="update.shop?num=${board.no}">[수정]</a>
		<a href="delete.shop?num=${board.no}">[삭제]</a>
		<a href="list.shop">[게시물목록]</a>
	</td></tr>
</table>
</body>
</html>