<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆界面</title>
<style type="text/css">
body {
	background-color: #FFF;
}

h1 {
	position: relative;
	left: 28px;
	margin-top: 4px;
	font-size: 20px;
	color: #666;
	font-family: "YaHei";
}

.dl {
	position: absolute;
	left: 150px;
	top: 160px;
	width: 300px;
	height: 330;
	padding-top: 20px;
	padding-bottom: 10px;
	background-color: #FFF;
	border-style: solid;
	border-color: #F3F3F3;
	border-width: 2px;
}

.input {
	margin-left: 25px;
}

a {
	color: #63F;
	font-size: 13px;
}

a:hover {
	color: #CCC;
	background-color: #3366CC;
}

.sr {
	background-image: url(images/denglu/sr.png);
	BORDER-TOP: 0px;
	BORDER-BOTTOM: 0PX;
	BORDER-LEFT: 0px;
	BORDER-RIGHT: 0px;
	font-size: 18px;
	float: left;
	margin-left: 1px;
	width: 189px;
	height: 39px;
	color: #999;
	padding-left: 10px;
	font-size: 0.85em;
}

.srkwm {
	position: relative;
	left: 34px;
	font-size: small;
	color: #666;
	font-family: "Arial Black", Gadget, sans-serif;
}

.bn {
	background-image: url(images/denglu/dl.png);
	width: 82px;
	height: 35px;
	border: none;
	position: relative;
	left: 84px;
}

img {
	float: right;
	margin-right: 100px;
	z-index: -1;
}
</style>
</head>

<body>
	<div style="float: left; margin-top: 50px; margin-left: 160px;">
		<a href="${pageContext.request.contextPath}/IndexUIServlet"><img
			src="images/icon2.png" width="140" height="70"></a>
	</div>
	<div class="dl">
		<h1>用户登录</h1>
		<br />
		<form method="post"
			action="${pageContext.request.contextPath}/LoginServlet">
			<div class="input">
				<img src="images/denglu/jb2.png"
					style="float: left; margin-right: 0px;" /> <input type="text"
					name="username" class="sr" /><br /> <br />
				<p class="srkwm">
					用户名 <span style="color: #F00;">${message }</span>
				</p>
			</div>
			<div class="input">
				<img src="images/denglu/jb2.png"
					style="float: left; margin-right: 0px;" /> <input type="password"
					name="password" class="sr" /><br /> <br />
				<p class="srkwm">密码</p>
			</div>
			<div class="input">
				<input name="login" type="submit" class="bn" value="" />
			</div>
		</form>
	</div>
	<p
		style="float: left; position: absolute; margin-top: 480px; margin-left: 184px; font-size: 14px; color: #666; font-family:"YaHei";">
		> 没有账户？ <a href="zhuce.html">立即注册</a>
	</p>
	<img src="images/bj5.jpg" width="692" height="528" />
	<footer
		style="width:auto;margin-top:600px;margin-left:560px;position:absolute;">
	<Pre style="line-height: 1px; color: #AAA;">copyright@circus工作室 All Right Reserved</Pre>
	</footer>
</body>
</html>