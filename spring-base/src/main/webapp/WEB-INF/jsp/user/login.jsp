<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
<script type="text/javascript">
	$(document).ready(function() {
		
		initEvnt();
		
	});
	
	// Evnt 초기화
	function initEvnt() {
		$('#btnSearch').on('click', function() {
			console.log("btnSearch 클릭");
			
			$.ajax({
			    url: "/book/post", 
			})
			.done(function(json) {
				console.log("btnSearch Success 데이터 :::: ", json);
				
				$('#searchResult').val(JSON.stringify(json));
			});
		});
		
		$('#btnReg').on('click', function() {
			console.log("btnReg 클릭");
			
			const data = JSON.stringify($("form[name=regForm]").serializeObject());
			
			$.ajax({
			    url: "/book/post", 
			    type : "post",
		    	data : data,
			    contentType: "application/json", 
			})
			.done(function(json) {
				console.log("btnReg Success 데이터 :::: ", json);
			})
		})
	}

</script>
	
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BookPage</title>
</head>
<body>
	<form action="post" method="post" name="regForm">
		<div>
			Id
			<input name="userId" type="text" />
		</div>
	
		<div>
			password
			<input name="password" type="password" />
		</div>
	
		<div>
			email
			<input name="email" type="text" />
		</div>
		<!-- TODO Form데이터 Controller에서 받을 수 있도록 수정 필요 -->
	</form>
	<button id="btnReg">등록</button> 
</body>
</html>