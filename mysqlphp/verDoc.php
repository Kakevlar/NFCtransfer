<?php
require "conn.php";
$id = $_POST["id"];
$mysql_qry = "select * from docdoc where id like '$id' and idpas like '0';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0 ) {
mysqli_close($conn);
while ($row = $result->fetch_assoc()) {
        echo $row['username'];
    }
}
else {
echo "Doctor invalido";
}

?>