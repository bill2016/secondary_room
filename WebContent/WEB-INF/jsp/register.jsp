<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>用户注册</title>
<style type="text/css">
body {
	background-color: #FFF;
}

h1 {
	position: absolute;
	left: 44px;
	margin-top: 4px;
	font-size: 20px;
	color: #666;
	font-family: "YaHei";
}

.zc {
	position: absolute;
	left: 134px;
	top: 150px;
	height: 350px;
	width: 360px;
	padding-top: 20px;
	padding-bottom: 10px;
	background-color: #FFF;
	border-style: solid;
	border-color: #F3F3F3;
	border-width: 2px;
}

.sr {
	border-style: solid;
	border-width: 1px;
	border-color: #CCC;
	font-size: 18px;
	width: 210px;
	height: 25px;
	color: #999;
	padding-left: 10px;
}

.input {
	margin-top: 20px;
	position: relative;
	float: right;
	margin-right: 20px;
}

a {
	color: #63F;
	font-size: 13px;
}

a.icon:hover {
	background-color: transparent;
}

a:hover {
	color: #CCC;
	background-color: #3366CC;
}

.srkwm {
	font-size: 16px;
	color: #333;
	font-family: "Arial Black", Gadget, sans-serif;
}

.bn {
	background-image: url(images/denglu/dl.png);
	width: 82px;
	height: 35px;
	border: none;
	position: relative;
	margin-top: 22px;
	margin-left: 80px;
}
</style>
</head>

<body>
	<div style="float: left; margin-top: 50px; margin-left: 160px;">
		<a class="icon"
			href="${pageContext.request.contextPath}/IndexUIServlet"><img
			src="images/icon2.png" width="140" height="70"></a>
	</div>
	<div class="zc">
		<h1>用户注册</h1>
		<form method="post"
			action="${pageContext.request.contextPath}/RegisterServlet">
			<div class="input" style="margin-top: 60px;">
				<label class="srkwm"> * 用户名：</label> <input type="text"
					name="username" class="sr" />
				<c:if test="${exist!=null }">
					<div>${exist }</div>
				</c:if>
			</div>
			<div class="input">
				<label class="srkwm">* 密码：</label> <input type="password"
					name="password" class="sr" />
			</div>
			<div class="input">
				<label class="srkwm">* 确认密码：</label> <input type="password"
					name="confirmpassword" class="sr" />
				<c:if test="${unconsist!=null }">
					<div>${unconsist }</div>
				</c:if>
			</div>
			<div class="input">
				<label class="srkwm"> * 邮箱：</label> <input type="text" name="email"
					class="sr" />
			</div>
			<div class="input">
				<label class="srkwm"> * 手机号码：</label> <input type="text"
					name="phonenumber" class="sr" />
			</div>
			<div>
				<input name="register" type="submit" class="bn" value=""
					style="background-image: url(images/denglu/zc.png); left: 64px;" />
			</div>
		</form>
	</div>
	<p
		style="float: left; position: absolute; margin-top: 550px; margin-left: 230px; font-size: 14px; color: #666; font-family:"YaHei";">
		> 已有账户？ <a href="denglu.html">直接登录</a>
	</p>
	<img src="images/bj5.jpg"
		style="float: right; margin-right: 40px; margin-top: 10px; position: relative; z-index: -1;"
		width="692" height="568" />
	<footer
		style="width:auto;margin-top:600px;margin-left:560px;position:absolute;">
	<Pre style="line-height: 1px; color: #AAA;">copyright@circus工作室 All Right Reserved</Pre>
	</footer>
</body>
</html>