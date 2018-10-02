<?php
require "conn.php";
$Nombre = $_POST["Nombre"];
$Tipo = $_POST["Tipo"];
$Elemento = $_POST["Elemento"];
$username = $_POST["username"];
$password = $_POST["password"];

$mysql_qry = "insert into pokemon (Nombre, Tipo, Elemento, username, password) values ('$Nombre','$Tipo','$Elemento','$username','$password')";

if($conn->query($mysql_qry) === TRUE){
echo "Lo metiste";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>