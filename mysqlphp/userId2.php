<?php
require "conn.php";
$user_name = $_POST["user"];
$user_pass = $_POST["pass"];
$mysql_qry = "select * from tesis where username like '$user_name' and password like '$user_pass';";
$result = mysqli_query($conn, $mysql_qry);
if(mysqli_num_rows($result) > 0 ) {
mysqli_close($conn);
while ($row = $result->fetch_assoc()) {
        echo $row['id'];
    }
}
else {
echo "no conecto";
}


?>