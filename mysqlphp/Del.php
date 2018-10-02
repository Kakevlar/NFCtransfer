<?php
require "conn.php";

$username = $_POST["username"];
$password = $_POST["password"];
$idpas = $_POST["idpas"];



$mysql_qry = "delete from docdoc where username like '$username' and password like '$password' and idpas like '$idpas';";

if($conn->query($mysql_qry) === TRUE){
echo "borrado";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>