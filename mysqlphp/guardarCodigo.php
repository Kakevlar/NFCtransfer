<?php
require "conn.php";
$Nombre = $_POST["username"];
$Tipo = $_POST["password"];
$Elemento = $_POST["idpas"];
$username = $_POST["clave"];

$mysql_qry = "insert into docdoc (username, password, idpas, clave) values ('$Nombre','$Tipo','$Elemento','$username')";

if($conn->query($mysql_qry) === TRUE){
echo "clave registrada";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>