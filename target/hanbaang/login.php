<?php
 $con=mysqli_connect("localhost","root","","artfolio");
if(mysqli_connect_errno($con))
{
	echo "Failed to connect to MySQL: " .mysqli_connect_error();
}
mysqli_set_charset($con, "utf8");
 
   // 세션 시작
   session_start();
   $id = $_POST['ID'];
   $pw = $_POST['PW'];
 
   $result = mysqli_query($con,"SELECT * FROM user WHERE ID='$id' AND PW='$pw'");
    
    $rows = mysqli_fetch_array($result);
    $data = $rows[0];
    if(!$data) { 
        echo "ERROR"; 
    }
    else  {
        echo "SUCCESS"; 
    }
   
?>