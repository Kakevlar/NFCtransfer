<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $id  = $_GET['id'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM tesis WHERE id='".$id."'";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
$res['username'],
$res['a'],
$res['b'],
$res['c'],
$res['d'],
$res['e'],
$res['f'],
$res['g'],
$res['h'],
$res['i'],
$res['j'],
$res['k'],
$res['l'],
$res['m'],
$res['n'],
$res['o'],
$res['p'],
$res['q'],

 )
 );
 
 echo json_encode(array($result));
 
 mysqli_close($con);
 
 }