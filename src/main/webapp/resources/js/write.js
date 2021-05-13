$(function(){	
	$("#save").click(function(){
		if($("#post_title").val() == '') {
			alert("제목을 입력하세요.");
			return;
		}
		if($("#post_content").val()=='') {
			alert("내용을 입력하세요.");
			return;
		}
		let data= {
			"user_seq":1,
			"board_seq":board_seq,			
			"post_title":$("#post_title").val(),
			"post_content":$("#post_content").val()
		}
		
		$.ajax({
			url:"/api/write",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(result) {
				alert("등록되었습니다.");
				location.href="/notice";
			},
			error:function() {
				alert("에러");
			}
		})
	})
	$("#cancel").click(function(){
		if(confirm("취소하시겠습니까?")) {
			location.href="/notice";
		}
	})
})