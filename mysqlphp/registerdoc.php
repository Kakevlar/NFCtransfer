<?php
require "conn.php";
$username = $_POST["username"];
$password = $_POST["password"];

$mysql_qry = "insert into docdoc (username, password) values ('$username','$password')";

if($conn->query($mysql_qry) === TRUE){
echo "Lo metiste";
}
else {
echo "Error: " . $mysql_qry . "<br>" . $conn->error;
}
$conn->close();
?>