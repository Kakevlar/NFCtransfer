<?php
require "conn.php";
$username = $_POST["username"];
$password = $_POST["password"];
$a = $_POST["a"];
$b = $_POST["b"];
$c = $_POST["c"];
$d = $_POST["d"];
$e = $_POST["e"];
$f = $_POST["f"];
$g = $_POST["g"];
$h = $_POST["h"];
$i = $_POST["i"];
$j = $_POST["j"];
$k = $_POST["k"];
$l = $_POST["l"];
$m = $_POST["m"];
$n = $_POST["n"];
$o = $_POST["o"];
$p = $_POST["p"];
$q = $_POST["q"];



$mysql_qry = "insert into tesis (username, password,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q
) values ('$username','$password','$a','$b','$c','$d','$e','$f','$g','$h','$i','$j','$k','$l','$m','$n','$o','$p','$q')";

if($conn->query($mysql_qry) === TRUE){
echo "Registro satisfactorio";
}
else {
echo mysql_error();
echo "Registro fallido";
}
$conn->close();
?>