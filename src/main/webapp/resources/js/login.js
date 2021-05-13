$(function(){
	$("#login_btn").click(function(){
		let data={
			dhm_id:$("#member_id").val(),
			dhm_pwd:$("#member_pwd").val()
		}
		
		if($("#member_id").val()==null || $("#member_id").val() == ""){
			alert("아이디를 입력하세요");
			return;
		}
		else if($("#member_pwd").val()==null || $("#member_pwd").val() == ""){
			alert("비밀번호를 입력하세요");
			return;
		}
		
		$.ajax({
			url:"/login",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(result) {
				location.href="/";
			},
			error:function(error) {
				alert(error.responseJSON.message);				
			}
		})
	})
	$("#member_pwd").keydown(function(e) {
        if(e.keyCode == 13) {
            $("#login_btn").trigger("click");
        }
    })
		$("#home").click(function(){
		location.href="/";
	})
})