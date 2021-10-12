<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INCLUDE 연습</title>
<!--  JQUERY -->
<script src="js/jquery-3.6.0.min.js"></script>
<!--  주소 -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">


</head>

<body>
	<header id="header">
		<div class="container">
			<h1 id="logo">
				<a href="">welsh</a>

			</h1>
			<nav id="gnb">
				
						<ul>
							<li><a href="">디지털 쇼룸</a></li>
							<li><a href="">검색창</a></li>
							<li><a href="">배송조회</a></li>
							<li><a href="LoginForm.do">내정보</a></li>
							<li><a href="">좋아요</a></li>
							<li><a href="">장바구니</a></li>
							<!-- <li><a href="../board/faq.jsp">자주하는 질문</a></li> -->
						</ul>
					
					
			</nav>
		</div>
	
	</header>
	<!-- 내용은 여기에 들어감... -->