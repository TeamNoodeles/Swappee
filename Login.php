<?php
    $con = mysqli_connect("swappee.comuf.com", "a4481230_Swap", "Swappee12345**", "a4481230_BDSwap");

    $username = $_POST["username"];
    $pass = $_POST["pass"];

    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ? AND pass = ?");
    mysqli_stmt_bind_param($statement, "ss", $username, $pass);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $username, $pass, $gender, $country, $city, $email);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["gender"] = $gender;
        $response["country"] = $country;
        $response["city"] = $city;
        $response["email"] = $email;

    }

    echo json_encode($response);
?>
