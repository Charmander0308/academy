<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).ready(function() {
		$("div, .s1, .s2").hide();
		$("p.h1").click(function() {
			$("div.h1, p.s1").show();
			$("p.h1").hide();
		});
		$("p.s1").click(function() {
			$("div.h1, p.s1").hide();
			$("p.h1").show();
		});
		
		$("p.h2").click(function(){
			$("div.h2, p.s2").show();
			$("p.h2").hide();
		});
		$("p.s2").click(function(){
			$("div.h2, p.s2").hide();
			$("p.h2").show();
		});
	});
</script>
</head>
<body>
	<h2>질문1 : 대한민국의 수도는 어디입니까?</h2>
	<p class="h1">[정답 보기]</p><p class="s1">[정답 숨기기]</p>
	<div class="h1">대한민국의 수도는 <strong>서울</strong>입니다.</div>
	<h2>질문2 : 대한민국의 국보1호는 무엇입니까?</h2>
	<p class="h2">[정답 보기]</p><p class="s2">[정답 숨기기]</p>
	<div class="h2">대한민국의 국보 1호는 <strong>숭례문</strong> 입니다.</div>
</body>
</html>