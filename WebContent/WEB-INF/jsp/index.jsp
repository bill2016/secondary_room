<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>首页</title>
<script type="text/javascript">
	var baseText = null;
	function doLogout() {
		//访问LogoutServlet注销当前登录的用户
		var b = window.confirm("您确认要注销吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
		}
	}
	function toSearch() {
		var oSelectNode = document.getElementById("selectsearch");
		var condi = oSelectNode.options[oSelectNode.selectedIndex].value;
		var x = document.getElementsByName("target")[0].value;
		var url;
		if (x != "") {
			url = "${pageContext.request.contextPath}/ListHousesServlet"
					+ searchs + "&" + condi + "=" + x;
		} else {
			url = "${pageContext.request.contextPath}/ListHousesServlet"
					+ searchs;
		}
		window.location.href = url;
	}
	var searchs = "?page=1";
	function function1() {
		var popUp = document.getElementById("change");
		var oRadioNode = document.getElementsByName("city");
		for (var x = 0; x < oRadioNode.length; x++) {
			if (oRadioNode[x].checked) {
				//	window.location.search = "?city=" + oRadioNode[x].value+ "&page=1";
				searchs = searchs + "&city=" + oRadioNode[x].value;

				document.getElementById("abc").innerHTML = oRadioNode[x].value;
				popUp.style.visibility = "hidden";
			}
		}
	}
	function function2() {
		var url;
		if (searchs.indexOf("city") > 0) {
			url = "${pageContext.request.contextPath}/ListHousesServlet"
					+ searchs;
		} else {
			url = "${pageContext.request.contextPath}/ListHousesServlet?page=1"
		}
		if(searchs.indexOf("深圳") > 0){
			url = "${pageContext.request.contextPath}/List2HousesServlet"
				+ searchs;
		}
		window.location.href = url;
	}

	function showchange() {
		var popUp = document.getElementById("change");
		popUp.style.top = "72px";
		popUp.style.left = "216px";
		popUp.style.visibility = "visible";
	}
</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/index.css" type="text/css" />
</head>

<body
	style="text-align: center; background-image: url(images/bj4.jpg); background-size: cover; background-repeat: no-repeat;">
	<p>
	<div style="float: left; margin-top: 0px; margin-left: 30px;">
		<a id="imgcity" href="#" onclick="function2()"> <img
			src="images/icon1.png" width="140" height="70">
		</a>
	</div>
	<span class="city"><span id="abc">城市</span> <a
		onclick="showchange()">[ 切换 ]</a></span>
	</p>
	<div class="nav">
		<div class="nav1">
			<c:if test="${user!=null }">
				<c:out value="welcome: ${user.userName }" />
				<input type="button" value="注销" onclick="doLogout()">
			</c:if>
		</div>
		<div class="nav1">
			<c:if test="${user==null }">
				<a href="${pageContext.request.contextPath}/RegisterUIServlet">注册</a>
				<a href="${pageContext.request.contextPath}/LoginUIServlet">登录</a>
			</c:if>
		</div>
	</div>
	<div class="slogan">
		兜兜转转<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;原来幸福在这里
	</div>





	<div class="search">
		<p class="hot1">
			热门搜索：&nbsp <a
				href="${pageContext.request.contextPath}/ListHousesServlet?district=天河"><u>天河</u></a>&nbsp&nbsp
			<a
				href="${pageContext.request.contextPath}/ListHousesServlet?district=番禺"><u>番禺</u></a>&nbsp&nbsp
			<a
				href="${pageContext.request.contextPath}/ListHousesServlet?district=增城"><u>增城</u></a>
		</p>
	</div>
	<span class="input"> <select name="order" id="selectsearch"
		style="height: 56px; width: 120px; float: left; margin-top: 10px; margin-left: 6px; font-size: 20px; font-family:"FZYaoti";color:#000;font-weight:bold;">
			<option value="title">标题</option>
			<option value="district">辖区</option>
			<option value="room">户型</option>
			<option value="year">年份</option>
			<option value="name">楼盘名称</option>
	</select> <input type="text" name="target" id="searchtext"
		style="height: 50px; width: 560px; float: left; margin-top: 10px; margin-left: 0px; font-size: 18px;">
		<button class="sbutton" onClick="toSearch()">搜 索</button>
	</span>
	<div id="change" class="change">
		<p style="font-size: 16px; color: #000;">请选择城市：</p>
		<form style="text-align: center;">
			<input type="radio" name="city" value="北京" onclick="function1()">北京
			&nbsp&nbsp <input type="radio" name="city" value="广州"
				onclick="function1()">广州<br /> <input type="radio"
				name="city" value="上海" onclick="function1()">上海 &nbsp&nbsp <input
				type="radio" name="city" value="深圳" onclick="function1()">深圳<br />
			<br />
		</form>

	</div>

</body>
</html>