<?php
require "conn.php";
$user_name = $_POST["user"];
$user_pass = $_POST["pass"];
$user_idpas = $_POST["idpas"];
$mysql_qry = "select * from docdoc where username like '$user_name' and password like '$user_pass' and idpas like '$user_idpas';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0 ) {
mysqli_close($conn);
while ($row = $result->fetch_assoc()) {
        echo $row['clave'];
    }
}
else {
echo "no conecto";
}


?>