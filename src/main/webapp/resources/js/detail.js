$(function(){	
	$("#post_delete").click(function(e){
	   e.preventDefault(); 
	    if(confirm("삭제하시겠습니까?")){
	        $.ajax({
	            url:"/api/deletePost?seq="+$("#dhn_seq").html(),
	            method:"delete",
	            success:function(){
	                alert("삭제되었습니다.");
	                location.href="/notice"
	            },
	            error:function(){
	                alert("에러");
	            }
	        })
	    }
	})
		$.ajax({
        url:"/api/patchPostCnt?post_seq="+$("#dhn_seq").html(),
        type:"patch",
        success:function(data) {
            console.log(data);
        },
        error:function(){
            alert("에러");
        }
    })
		
})

