$(function(){
	let id_check = false;
	
	$("#dup_check").click(function(){
		if($("#member_id").val()==null || $("#member_id").val()=='') {
			alert("아이디를 입력하세요");
			return;
		}
		$.ajax({
			url:"/member/id_check?id="+$("#member_id").val(),
			type:"get",
			success:function(result){
				if(result.status == "ok") {
					id_check = true;
				}
				alert(result.message); 
			}
		});
	
	});
	$("#member_id").change(function(){
		id_check=false;
	})
	$("#join_btn").click(function(){
		if($("#member_id").val() == null || $("#member_id").val() == ""){
			alert("아이디를 입력하세요");
			return;
		}		
		if(!$("#dup_check")) {
			alert("아이디 중복확인을 해주세요");
			return;
		}	
		if($("#member_pwd").val() == null || $("#member_pwd").val() == ""){
			alert("비밀번호를 입력하세요");
			return;
		}
		if($("#member_pwd").val() != $("#member_pwd_confirm").val()) {
			alert("비밀번호가 일치하지않습니다.");
			return;
		}
		if($("#member_name").val() == null || $("#member_name").val() == ""){
			alert("이름 입력하세요");
			return;
		}
		if($("#member_email").val() == null || $("#member_email").val() == ""){
			alert("이메일을 입력하세요");
			return;
		}
		if($("#member_phone").val() == null || $("#member_phone").val() == ""){
			alert("전화번호를 입력하세요");
			return;
		}
		
		let data = {
			dhm_id:$("#member_id").val(),
			dhm_pwd:$("#member_pwd").val(),
			dhm_name:$("#member_name").val(),
			dhm_email:$("#member_email").val(),
			dhm_phone:$("#member_phone").val()
		}
		
		$.ajax({
			url:"/join",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(result){
				alert(result.message);
				location.href="/";
			},
			error:function() {
				alert("에러");				
			}
		}) 
	})
})