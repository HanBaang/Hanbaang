function login(){
    $("#login").on("submit",function(){//"확인"버튼을 눌렀을 때...
    var d=$(this).serialize();//폼 요소에 전송할 데이터를 재가공합니다.
    $.ajax({
     url:"./server/login.jsp", //URL
     type:"post", //데이터 전송 방식
     data:d,
     success:function(result){
        if(1==result){
            alert("관리자");
            location.href="./index_doc.html";
            return true;
        }else if(2==result){
            alert("스태프");
            location.href="./index_staff.html";
            return true;
        }
     }
  });
   location.href="#";
   return false;//action 페이지로 전환되는 것을 차단합니다.
  });
}
  
function signUp() {
    $("#signup").click(function () {
        $.ajax({
            url : './signUp.html',
        })
    })
}