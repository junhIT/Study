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
	
	jQuery.fn.serializeObject = function() {
	    var obj = null;
	    try {
	        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
	            var arr = this.serializeArray();
	            if (arr) {
	                obj = {};
	                jQuery.each(arr, function() {
	                    obj[this.name] = this.value;
	                });
	            }//if ( arr ) {
	        }
	    } catch (e) {
	        alert(e.message);
	    } finally {
	    }
	 
	    return obj;
	};


</script>
	
    
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BookPage</title>
</head>
<body>
	<form action="post" method="post" name="regForm">
		<div>
			제목
			<input name="title" type="text" />
		</div>
	
		<div>
			내용
			<input name="content" type="text" />
		</div>
	
		<div>
			작성자
			<input name="author" type="text" />
		</div>
		<!-- TODO Form데이터 Controller에서 받을 수 있도록 수정 필요 -->
	</form>
	<button id="btnReg">등록</button> 



	<div style="margin-top:50px">
		<button id="btnSearch">조회</button>
	</div>
	<div>
		<textarea id="searchResult"></textarea>
	</div>

</body>
</html>