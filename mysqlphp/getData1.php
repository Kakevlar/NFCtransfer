<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $id  = $_GET['id'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM pokemon WHERE id='".$id."'";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 $res['Nombre'],
 $res['Tipo'],
 $res['username']
 )
 );
 
 echo json_encode(array($result));
 
 mysqli_close($con);
 
 }
