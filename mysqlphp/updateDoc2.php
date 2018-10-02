<?php
require "conn.php";
$username = $_POST["username"];
$idpas = $_POST["idpas"];
$clave = $_POST["clave"];




$mysql_qry = "UPDATE docdoc SET clave='$clave'
 where idpas like '$idpas' and username like '$username';";

$result = mysqli_query($conn, $mysql_qry);

if($result)
{echo 'Employee Updated Successfully';
 }else{
 echo 'Could Not Update Employee Try Again';
 }
mysqli_close($conn);

?>

