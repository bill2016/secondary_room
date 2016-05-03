<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${house.name }</title>
<script type="text/javascript" src="jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	function doLogout() {
		var b = window.confirm("您确定要注销吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
		}
	}
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return r[2];
		return false;
	}
	var searchsglo = "?page=1";
	function fun1(){
		if(getUrlParam("city")){
			searchsglo = searchsglo + "&city=" + getUrlParam("city");
		}
	}
	function toSearch() {
		fun1();
		var oSelectNode = document.getElementById("selectsearch");
		var condi = oSelectNode.options[oSelectNode.selectedIndex].value;
		var x = document.getElementsByName("target")[0].value;
		var url;
		if (x != "") {
			url = "${pageContext.request.contextPath}/ListHousesServlet"
					+ searchsglo + "&" + condi + "=" + x;
		} else {
			url = "${pageContext.request.contextPath}/ListHousesServlet"
					+ searchsglo;
		}
		window.location.href = url;
	}
	function collectHouse(x,flag) {
			window.location.href = "${pageContext.request.contextPath}/CollectHouseServlet?id="+x;
				alert("收藏成功");
	}
	function loadXMLDocBac(x) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
			}
			xmlhttp.open("GET", "${pageContext.request.contextPath}/CollectHouseServlet?id="+x, true);
			xmlhttp.send();
		}
		alert("已收藏");
	}

	function loadXMLDoc(id) {
		   $.ajax({
				  url:"${pageContext.request.contextPath}/CollectHouseServlet?id="+id,
				  type:"GET",
				  dataType:"json",
				  success: function(flag){
					  if(flag=="true"){
						  alert("收藏成功");
						  $('#coll').html("已收藏");
					  }else{
						  alert("已收藏");
						  $('#coll').html("已收藏");
					  }
					  }  
				  }) 
				  //$('.swiper-pagination-bullet:nth-child(3)').click();
	}
</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/detail.css" type="text/css" />
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
	<div class="nav3">
		<a class="bx" href="${pageContext.request.contextPath}/IndexUIServlet"><img
			src="images/icon3.png" width="140" height="70"></a>
		<div class="nav2">
		    <select name="order" id="selectsearch"
		style="height: 42px; width: 100px; float: left; margin-top: 10px; margin-left: 6px; font-size: 20px; font-family:"FZYaoti";color:#000;font-weight:bold;">
			<option value="title">标题</option>
			<option value="district">辖区</option>
			<option value="room">户型</option>
			<option value="year">年份</option>
			<option value="name">楼盘名称</option>
	        </select>
			<input type="text" name="target"
				style="height: 36px; width: 509px; float: left; margin-top: 10px; border-color: #FF9900; font-size: 18px;">
			<button type="submit" class="sbutton"  onClick="toSearch()">搜 &nbsp索</button>
		</div>
	</div>
	<div class="nav5">
		<a href="#">二手房网</a> > <a href="#">广州二手房</a> > <a href="#">番禺二手房</a>
	</div>


	<div class="hold">
		<div class="date">
			<h style="font-size:24px;color:#de3438;"> <strong>${house.title }</strong></h>

			<br /> <br /> <img name="tu" src="${house.firstimg }" width="450"
				height="350"
				style="border-style: solid; border-color: #D8D8D8; border-width: 1px;"><br />
			<br />
			<div style="margin-left: 190px;">
				<button class="imgch"><</button>
				<button class="imgch">></button>
			</div>
		</div>
		<div class="date1">
			<p style="font-size: 16px">
				总价：&nbsp&nbsp <span class="price">${house.cost }</span>万&nbsp
				（31707元/㎡）
			</p>
			<p>户型：&nbsp&nbsp&nbsp${house.room }</p>
			<p>建筑面积：&nbsp&nbsp&nbsp${house.area }㎡</p>
			<p>楼层：&nbsp&nbsp&nbsp${house.floor }</p>
			<p>房屋年份：&nbsp&nbsp&nbsp${house.year }</p>
			<p>楼盘名称：&nbsp&nbsp&nbsp${house.name }</p>
			<button type="submit" class="cbutton" onclick="loadXMLDoc(${house.id})" id="coll">收
				&nbsp藏</button>
		</div>
		<div class="seller">
			<img name="sellerimg" src="images/usericon.png" width="125"
				height="150" alt="" /><br />
			<p>姓名：${house.seller }</p>
			<p>联系电话：${house.phone }</p>
		</div>
	</div>
	<div class="history">
		<div class="h1">浏览历史</div>

		<c:forEach var="h" items="${houses }">
			<div class="h2">
				<a
					href="${pageContext.request.contextPath}/DetailHouseServlet?id=${h.id}"
					target="_blank"><img src="${h.firstimg }" width="191"
					height="116" /></a><br> <a
					href="${pageContext.request.contextPath}/DetailHouseServlet?id=${h.id}"
					target="_blank">${h.name }</a> <br> ${h.cost }万
			</div>
			<hr>
		</c:forEach>
	</div>
	<div class="nav4">
		<b>详细信息</b>
	</div>
	<div class="date2">
		<h style="font-size:24px;font-weight:bolder;">房源信息</h>
		<br />${house.description }<br />
		<h style="font-size:24px;font-weight:bolder;">房源图片</h>
		<br /> <img src="images/例图2.jpg" class="imgzs"><br />房源组图1<br />
		<img src="images/例图3.jpg" class="imgzs"><br />房源组图2<br /> <img
			src="images/例图4.jpg" class="imgzs"><br />房源组图3<br /> <img
			src="images/例图5.jpg" class="imgzs"><br />房源组图4<br />
	</div>
	<footer
		style="width:auto;padding-top:1px;background-color:#202020;height:50px;text-align:center;position:relative;margin-top:100px;">
	<Pre style="color: #AAA; font-size: 12px;">copyright@circus工作室  All Right Reserved</Pre>
	</footer>

</body>
</html>