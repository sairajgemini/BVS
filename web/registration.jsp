<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration Form-Bengali Baidya Samaj</title>

    <!-- Bootstrap core CSS -->
    <link href="css_lib/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="js_lib/ie10-viewport-bug-workaround.js" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/regestration.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="js_lib/jquery-3.2.1.min.js"></script>
    <script src="js/registration.js"></script>
</head>

<body>
<div>
    <h4 class="container-fluid">${successMsg}</h4>
</div>
<div class="container">
    <form action="/registerUser.html" class="form-reg" method="post">
        <h2 class="form-reg-heading">Register yourself</h2>
        <label for="userName" class="sr-only">User name</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="User name" required
               autofocus>
        <label for="companyName" class="sr-only">Company name</label>
        <input type="text" id="companyName" name="companyName" class="form-control" placeholder="Company name">
        <label for="residentialAddress" class="sr-only">Residential/Postal Address</label>
        <input type="text" id="residentialAddress" name="residentialAddress" class="form-control"
               placeholder="Residential/Postal Address"
               required>
        <label for="pinNumber" class="sr-only">Pin number</label>
        <input type="text" id="pinNumber" name="pinNumber" class="form-control" placeholder="Pin number" maxlength="6"
               required>
        <label for="emailId" class="sr-only">Email address</label>
        <input type="email" id="emailId" name="emailId" class="form-control" placeholder="Email address" required>
        <label for="webSiteAdress" class="sr-only">Website</label>
        <input type="text" id="webSiteAdress" name="webSiteAdress" class="form-control" placeholder="Website">
        <label for="landLine" class="sr-only">Phone number</label>
        <input type="tel" id="landLine" name="landLine" class="form-control" placeholder="Phone number">
        <label for="mobileNumber" class="sr-only">Mobile number</label>
        <input type="tel" id="mobileNumber" name="mobileNumber" class="form-control" placeholder="Mobile number"
               required>
        <label for="panCardNo" class="sr-only">PAN number</label>
        <input type="text" id="panCardNo" name="panCardNo" class="form-control" placeholder="PAN number" maxlength="10"
               required>
        <label for="bloodGroup" class="sr-only">Blood group</label>
        <input type="text" id="bloodGroup" name="bloodGroup" class="form-control" placeholder="Blood group" required>
        <label for="payAmount" class="sr-only">Registration amount</label>
        <input type="number" id="payAmount" name="payAmount" class="form-control" placeholder="Registration amount"
               required>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="">Register</button>
    </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js_lib/ie10-viewport-bug-workaround.js"></script>
</body>
</html>