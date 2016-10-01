<?php
    $con = mysqli_connect("swappee.comuf.com", "a4481230_Swap", "Swappee12345**", "a4481230_BDSwap");

    $username = $_POST["username"];
    $email = $_POST["email"];
    $pass = $_POST["pass"];
    $country = $_POST["country"];
    $city = $_POST["city"];
    $gender = $_POST["gender"];
    $statement = mysqli_prepare($con, "INSERT INTO user (username, email, gender, country, city, pass) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $username, $email, $gender, $country, $city, $pass);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
