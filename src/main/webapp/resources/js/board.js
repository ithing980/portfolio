$(function(){	
	let offset = getParam("offset");
    let curPage = Number(offset)/15;
    let pageCnt = 0;
    $.ajax({
        url:"/api/postCount?board_seq="+board_seq/*+"&keyword="+getParam("keyword")+"&type="+type*/,
        type:"get",
        success:function(data){
            pageCnt = Math.ceil(data.count/15);
            $(".pagers").html(""); // .pagers 내부 HTML 삭제
            let start = 0;
            if(curPage - 4 >= 0){
                start = curPage-4;
            }
            else {
                start = 0;
            }
            for(let i=start; i<pageCnt; i++){
                let template;
                if(offset == i*15){
                    template='<a href="/'+board_name+'?offset='+i*15+'&keyword='+getParam("keyword")+'&type='+type+'" class="current">'+(i+1)+'</a>';
                }
                else {
                    template='<a href="/'+board_name+'?offset='+i*15+'&keyword='+getParam("keyword")+'&type='+type+'">'+(i+1)+'</a>';
                }
                $(".pagers").append(template);
                if(i-start == 8){
                    break;
                }
            }
        }
	})
		$("#prev_page").click(function(){
			alert("ㅇㄹㅇㄹㅇ");
	        let newOffset = offset - 15;
	        if(newOffset < 0) return;
	        location.href="/"+board_name+"?offset="+newOffset+"&keyword="+getParam("keyword")+"&type="+type;
	    })
	    $("#next_page").click(function(){
	        let newOffset = Number(offset) + 15;
	        console.log(newOffset, pageCnt);
	        if(newOffset/15 >= pageCnt) return;
	        location.href="/"+board_name+"?offset="+newOffset+"&keyword="+getParam("keyword")+"&type="+type;
	    })
	    $("#prev_10").click(function(){
	        let newOffset = offset - 150;
	        if(newOffset < 0) newOffset = 0;
	        location.href="/"+board_name+"?offset="+newOffset+"&keyword="+getParam("keyword")+"&type="+type;
	    })
	    $("#next_10").click(function(){
	        let newOffset = Number(offset) + 150;
	        if(newOffset/15 >= pageCnt) newOffset = (pageCnt-1)*15;
	        location.href="/"+board_name+"?offset="+newOffset+"&keyword="+getParam("keyword")+"&type="+type;
	    })
    })

  