$(function(){	
	$("#consult_move").click(function(){
		location.href="/consult";
	})
})

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
			"board_seq":18,
			"user_seq":$(".title").attr("data-user-seq"),
			"post_title":$("#post_title").val(),
			"post_content":$("#post_content").val()
		}
		$.ajax({
			url:"/api/consult",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(result) {
				alert("등록되었습니다.");
				location.href="/consult";
			},
			error:function() {
				alert("에러");
			}
		})
	})
	$("#cancel").click(function(){
		if(confirm("취소하시겠습니까?")) {
			location.href="/consult";
		}
	})
})

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
			dhc_seq:$(".title").attr("data-post-seq"),
			dhc_title:$("#post_title").val(),
			dhc_content:$("#post_content").val()
		}
		console.log(JSON.stringify(data));
			$.ajax({
			url:"/api/updatePostConsult",
			type:"patch",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function() {
				alert("수정되었습니다.");
				location.href="/consult";
			},
			error:function(){
				alert("에러");
			}
		})
	})	
	$("#post_cancel").click(function(){
		if(confirm("취소하시겠습니까?")) {
			location.href="/consult";
		}
	})

})

$(function(){
	$("#post_delete1").click(function(e){
	   e.preventDefault(); 
	    if(confirm("삭제하시겠습니까?")){
	        $.ajax({
	            url:"/api/deletePostConsult?seq="+$("#dhc_seq").html(),
	            type:"delete",
	            success:function(){
	                alert("삭제되었습니다.");
	                location.href="/consult"
	            },
	            error:function(){
	                alert("에러");
	            }
	        })
	    }
	})
	$("#comment_input_btn").click(function(){
		if($("#comment_content").val() == '') {
			alert("댓글을 입력하세요");
			return false;
		}
		let data = {
			"dhci_dhc_seq":$("#dhc_seq").html(),
            "dhci_dhm_seq":/*$(".comment_input").attr("data-user-seq")*/1,
            "dhci_content":$("#comment_content").val()
		}
		 console.log(JSON.stringify(data));
		$.ajax({
			url:"/api/insert_comment",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify(data),
			success:function(data){
				alert("등록되었습니다.");
				location.reload();
				/*$("#comment_content").val("");*/
			},
			error:function(data){
				alert("에러");
			}
		})
	})	
		let offset = 0;
	    let total = 0;
	    getComments();
	    function getComments() {
	        let data = {
	            board_seq:$("#dhc_seq").html(), 
	            offset:offset
	        }
        $.ajax({
            url:"/api/comments",
            type:"post",
            contentType:"application/json",
            data:JSON.stringify(data),
            success:function(data){
                console.log(data);
                total = data.count;
                $("#total_comments").html(total);
                $(".comment_cnt").html("("+total+")");
                if(data.count <= 10) {
                    $("#more_btn").css("display", "none");
                }
				
                for(let i=0; i<data.data.length; i++){
                    let template = null;
					if(userRole == 1)
                    template = 
                        '<div class="comment" id="comment'+i+'" data-comment-seq="'+data.data[i].dhci_seq+'">'+
                            '<div>'+
                                '<span>'+data.data[i].dhm_name+'</span><span>'+makeDate(data.data[i].dhci_reg_date)+'</span>'+
                                    '<span>'+
                                        '<button class="comment_delete">삭제</button>'+
                                    '</span>'+
                                '</div>'+
 								'<p>'+'- '+data.data[i].dhci_content+'</p>'+
                            '</div>';
				 else
                    template = 
                        '<div class="comment" id="comment'+i+'" data-comment-seq="'+data.data[i].dhci_seq+'">'+
                            '<div>'+
                                '<span>'+data.data[i].dhm_name+'</span><span>'+makeDate(data.data[i].dhci_reg_date)+'</span>'+
                                '</div>'+
								'<p>'+'- '+data.data[i].dhci_content+'</p>'+
                            '</div>';

				$(".comment_list").append(template);
					}
				$(".comment_delete").click(function(){
				if(confirm("댓글을 삭제하시겠습니까?") == false) return;
				let seq = $(this).parent().parent().parent().attr("data-comment-seq");
       			 $.ajax({
         		  	 url:"/api/delete_comment?seq="+seq,
           			 type:"delete",
           			 success:function(data) {
           		     alert(data.message);
	                 location.reload();
	           		 },
					error:function(){
						alert("에러");
					}
				})
			})
		},
		error:function(data) {
            alert("에러");
        }				
	})
}				      
	function makeDate(dt) {
        let date = new Date(dt);
        let formatted = "";
        formatted = 
            date.getFullYear()+"-"+
            leadingZero((date.getMonth()+1))+"-"+
            leadingZero(date.getDate())+" "+
            leadingZero(date.getHours())+":"+
            leadingZero(date.getMinutes());
        return formatted;
    }
	function leadingZero(n) {
        return n<10?"0"+n:n;
    }

	$("#more_btn").click(function(){
        offset += 10;
        getComments();
        console.log(offset, total);
        if(offset + 10 >= total) {
            $("#more_btn").css("display", "none");
        }
    })
})
	