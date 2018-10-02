<?php
require "conn.php";
$username = $_POST["username"];
$id = $_POST["id"];
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



$mysql_qry = "UPDATE tesis SET a='$a', b='$b', c='$c', d='$d', e='$e', f='$f', g='$g', h='$h', i='$i'
, j='$j', k='$k', l='$l', m='$m', n='$n', o='$o', p='$p', q='$q'
 where id like '$id' and username like '$username';";

$result = mysqli_query($conn, $mysql_qry);

if($result)
{echo 'Employee Updated Successfully';
 }else{
 echo 'Could Not Update Employee Try Again';
 }
mysqli_close($conn);

?>

