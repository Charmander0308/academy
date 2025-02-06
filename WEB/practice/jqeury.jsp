<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 연습하기</title>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(document).ready(function(){
			$("button.h1").click(function(){	//1. 이벤트 발생 대상
//				$("p").hide();
				$("p").fadeOut("slow");				//2. 처리할 기능
			});
			$("button.s1").click(function(){
//				$("p").show();
				$("p").fadeIn("slow");
			});
		});
	
	</script>
</head>
<body>	
	<p> 메시지 : 제이쿼리를 공부하고 있습니다.</p>
	<button class="h1">메시지 삭제</button>
	<button class="s1">메시지 보이기</button>

</body>
</html>