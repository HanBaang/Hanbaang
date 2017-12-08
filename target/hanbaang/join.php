<?php
   $con=mysqli_connect("localhost:9983","root","0706","hanbaang");
if(mysqli_connect_errno($con))
{
	echo "Failed to connect to MySQL: " .mysqli_connect_error();
}
mysqli_set_charset($con, "utf8");
 
   // ���� ����
   session_start();
   $name = $_POST['Name'];
   $id = $_POST['ID'];
   $pw = $_POST['PW'];
   $phone = $_POST['Phone'];
   $email = $_POST['Email'];
 
   $sql = "SELECT id, pw FROM test where id = '$id'";
 
   $result = mysqli_query($con,$sql);
 
   if(!$result)
         echo "ERROR";
   else
        echo "SUCCESS"
 
?>


