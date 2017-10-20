/**
 * ajax 예제 
 */

//요청값:객체, 리턴값 : boolean 

function login(){ //index.html에서 동작하는 부분
  $("#login").on("submit",function(){//"확인"버튼을 눌렀을 때...
    var d = $(this).serialize();//폼 요소에 전송할 데이터를 재가공합니다.
    
    $.ajax({
      // beforeSend: function (request)
      // {
      //   request.setRequestHeader("Access-Control-Request-Method", "POST");
      //   request.setRequestHeader("Access-Control-Allow-Origin", "http://220.149.124.114/");
      //   //Access - Control - Request - Headers: X - PINGOTHER
      // },
   url:"../server/fucku.json", //URL
   type:"post", //데이터 전송 방식
   dataType: 'json',
   jsonp : "callback",
  
   success: function (result) {
     //var getid = $.parseJSON(result);
     //alert(getid);
     //var jo = JSON.parse(result);
     var jo = result;
     var iid = jo.ob[0].id;
	  if(1==iid){
		  alert("관리자");
      location.href = "../WebContent/index_doc.html";
		  return true;
	  }else if(2==iid){
		  alert("스태프");
		  location.href="../WebContent/index_staff.html";
		  return true;
	  }
   },
   error: function (jqXHR, textStatus, errorThrown) {
    alert(jqXHR);
    alert( textStatus );
    alert( errorThrown );
    }
    });
    
 location.href="#";
 return false;//action 페이지로 전환되는 것을 차단합니다.
});
}

//요청값 : 개별값 , 리턴값 : 객체 (JSON) 
// function select_recep(){
// 	var s_date = document.getElementById('s_date').value;
// 	var d_date = document.getElementById('d_date').value;
// 	alert("날짜 값을 기반으로 검색 수행"+s_date+"~"+d_date);
//     $.ajax({
//       url:"../server/select_recep.jsp?s_date="+s_date+"&d_date="+d_date,
//       type:"get",
//       dataType:"json",
//       success:function(result){
//      	if($(result.rank.length>0)){

//         $.each(result.results,function(i,d){ 
       	 
// 		   $("tbody").append("<tr><td><a href='comUpdateView.php?companyCode="+d['companyCode']+"&companyName="+d['companyName']+"&managerName="+d['managerName']+"&companyTel="+d['companyTel']+"&companyEmail="+d['companyEmail']+"&companyPost="+d['companyPost']+"&companyAddre="+d['companyAddre']+"'>"+d["companyCode"]+"</a></td><td>"+d["companyName"]+"</td><td>"+d["managerName"]+"</td><td>"+d["companyTel"]+"</td><td>"+d["companyEmail"]+
// 		   "</td><td>"+d["companyPost"]+"</td><td>"+d["companyAddre"]+"</td></tr>");
//         });
//      	}
//       },
//       error : function( jqXHR, textStatus, errorThrown ) {
//     	  alert( textStatus );
//     	  alert( errorThrown );
//     	  }
//    }); 
// //	location.href="/Hanbang/server/select_recep.jsp?s_date="+s_date+"&d_date="+d_date
// //	return true;
// }


function managePatient() { //manage.html에서 동작하는 부분
 
  $("#receipt").click(function () {
    $.ajax({
      url: "../server/pntrecdata.json",
      type: "GET",
      dataType: "json",
      success: function (response) {
        var row = response;
        alert("row");
        //$("#patientReceiptList").append(response);
      },
      error: function (e) {
        
      }
    })
  })
  
}

