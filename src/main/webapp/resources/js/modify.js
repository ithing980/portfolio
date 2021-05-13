$(function(){
	$("#post_save").click(function(){
		if($("#post_title").val() ==  null || $("#Post_title").val() == ""){
			alert("제목을 입력하세요");
			return;
		}
		if($("#post_content").val() == null || $("#post_content").val() == "") {
			alert("내용을 입력하세요");
			return;
		}
		let data={
			dhn_seq:$(".title").attr("data-post-seq"),
			dhn_title:$("#post_title").val(),
			dhn_content:$("#post_content").val()
		}
		console.log(JSON.stringify(data));
			$.ajax({
			url:"/api/updatePost",
			type:"patch",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function() {
				alert("수정되었습니다.");
				location.href="/notice";
				
			},
			error:function(){
				alert("에러");
			}
		})
	})	
	$("#post_cancel").click(function(){
		if(confirm("취소하시겠습니까?")) {
			location.href="/notice";
		}
	})
})