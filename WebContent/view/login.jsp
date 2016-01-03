<!doctype html>
<html lang="en-US">
<head>
<meta charset="utf-8">
<title>Login</title>
<!--  link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Varela+Round" -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript">

</script>
</head>

<body>
	<div id="login">
		<h3>
			<span class="fontawesome-lock" style="align:center">Happy Desk Login</span>
		</h3>
		<form action="loginprocess.do" method="post">
			<fieldset>
				<p>
					<label for="email">E-mail address</label>
				</p>
				<p>
					<input type="email" name="email" value="mail@address.com"
						onBlur="if(this.value=='')this.value='mail@address.com'"
						onFocus="if(this.value=='mail@address.com')this.value=''">
				</p>
				<p>
					<label for="password">Password</label>
				</p>
				<p>
					<input type="password" name="password" value="password"
						onBlur="if(this.value=='')this.value='password'"
						onFocus="if(this.value=='password')this.value=''">
				</p>
				<p>
					<input type="submit" value="Sign In">
				</p>
			</fieldset>
		</form>

	</div>
</body>
</html>