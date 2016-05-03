<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="jquery-2.2.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户空间</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user.css"
	type="text/css" />
<script>
	function doLogout() {
		//访问LogoutServlet注销当前登录的用户
		var b = window.confirm("您确认要注销吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
		}
	}
	function deleteCollection(id) {
		   $.ajax({
				  url:"${pageContext.request.contextPath}/DeleteHouseServlet?id="+id,
				  type:"GET",
				  dataType:"json",
				  success: function(flag){
					  }  
				  }) 
				  window.location.href = "${pageContext.request.contextPath}/UserPageServlet";
	}
</script>
</head>
<body>
	<div class="nav">
		<p
			style="color: #FFF; float: right; margin-top: 2px; margin-right: 10px;">
			<c:if test="${user!=null }">
				<a class="dl"
					href="${pageContext.request.contextPath}/UserPageServlet"> <c:out
						value="welcome:" /> ${user.userName }
				</a>
				<input type="button" value="注销" onclick="doLogout()">
			</c:if>
			<c:if test="${user==null }">
				<a class="dl"
					href="${pageContext.request.contextPath}/RegisterUIServlet">注册</a>
				<a class="dl"
					href="${pageContext.request.contextPath}/LoginUIServlet">登录</a>
			</c:if>
		</p>
	</div>
	<div class="nav1">
		<a href="${pageContext.request.contextPath}/IndexUIServlet"><img
			src="images/icon3.png" width="140" height="70"></a>
		<div class="nav2">
			<input type="text" name="target"
				style="height: 36px; width: 509px; float: left; margin-top: 10px; border-color: #FF6; font-size: 18px;">
			<button type="submit" class="sbutton">搜 &nbsp索</button>
		</div>
	</div>
	<p style="height: 2px"></p>
	<h>用户信息</h>
	<div class="user">
		<img src="images/usericon.png"
			style="position: absolute; width: 300px; height: 310px; margin-top: 40px; margin-left: 60px; border-color: #CCC; border-style: solid; border-width: 1px; background-color: #CCC;" />
		<div
			style="position: absolute; margin-left: 460px; margin-top: 120px;">
			<p style="font-size: 16px">用户名：&nbsp&nbsp&nbsp ${user.userName }</p>
			<p>邮箱：&nbsp&nbsp&nbsp&nbsp ${user.email }</p>
			<p>手机号码：&nbsp&nbsp ${user.phoneNumber }</p>
		</div>
	</div>
	<h1>用户收藏</h1>
	<div class="save">
		<c:forEach var="h" items="${house }">
			<div class="h2">
				<div class="close">
					<button type="submit" onclick="deleteCollection(${h.id})">
						<img src="images/close.jpg" width="20" height="20" />
					</button>
				</div>
				<a
					href="${pageContext.request.contextPath}/DetailHouseServlet?id=${h.id}"
					target="_blank"><img src="${h.firstimg }" width="191"
					height="116" /></a><a
					href="${pageContext.request.contextPath}/DetailHouseServlet?id=${h.id}"
					target="_blank">${h.name }</a> <span style="float: right;">${h.cost }万</span>
			</div>
		</c:forEach>
		<div style="clear: both"></div>
	</div>
	<footer
		style="width:99%;padding-top:1px;background-color:#202020;height:50px;text-align:center;position:relative;margin-top:30px;">
	<Pre style="color: #AAA; font-size: 12px;">copyright@circus工作室  All Right Reserved</Pre>
	</footer>
</body>
</html>