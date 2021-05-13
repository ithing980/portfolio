$(function(){
    let rootmenu = new Array();
    let submenu = new Array();
    $.ajax({
        url:"/api/category",
        type:"get",
        success:function(data) {
            console.log(data);
            rootmenu = data.filter(menu => menu.dhb_parent_seq == null);
            submenu = data.filter(menu => menu.dhb_parent_seq != null);
          
            rootmenu.forEach(menu => {
                let template = '<li id="rootmenu'+menu.dhb_seq+'"><a href="'+menu.dhb_url+'">'+menu.dhb_name+'</a><ul></ul></li>';
                $("#gnb>ul").append(template);
            })
            submenu.forEach(menu => {
                let template = '<li><a href="'+menu.dhb_url+'">'+menu.dhb_name+'</a></li>';
                let selector = "#rootmenu"+menu.dhb_parent_seq+">ul";
                $(selector).append(template);
            })
        },
        error:function() {
            alert("에러");
        }
    })
})