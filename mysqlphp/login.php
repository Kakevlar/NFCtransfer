<?php
require "conn.php";
$user_name = $_POST["user"];
$user_pass = $_POST["pass"];
$mysql_qry = "select * from pokemon where username like '$user_name' and password like '$user_pass';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0 ) {
echo "conecto" ;
}
else {
echo "no conecto";
}

?>