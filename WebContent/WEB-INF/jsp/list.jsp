<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>二手房</title>
<script type="text/javascript">
	function doLogout() {
		var b = window.confirm("您确定要注销吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath}/LogoutServlet";
		}
	}
	function openpage() {
		var para = document.getElementById("cost1").value + "-"
				+ document.getElementById("cost2").value;
		var url = "${pageContext.request.contextPath}/ListHousesServlet?cost="
				+ para;
		window.location.replace(url);
	}

	function toChange() {
		var oSelectNode = document.getElementById("selectchange");
		var condi = oSelectNode.options[oSelectNode.selectedIndex].value;
		var la;
		var searchs;
		if (location.search.indexOf("co") || location.search.indexOf("ar")) {
			searchs = location.search.replace("&co=up", "");
			searchs = searchs.replace("&co=down", "");
			searchs = searchs.replace("&ar=up", "");
			searchs = searchs.replace("&ar=down", "");
		}
		if (condi == "cost1") {
			la = "&co=up";
		} else if (condi == "cost2") {
			la = "&co=down";
		} else if (condi == "area1") {
			la = "&ar=up";
		} else if (condi == "area2") {
			la = "&ar=down";
		}
		url = "${pageContext.request.contextPath}/ListHousesServlet" + searchs
				+ la;
		window.location.href = url;

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
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return r[2];
		return false;
	}

	function nextPage() {
		var paras = location.search.split("&");
		var old;
		var num;
		for (var i = 0; i < paras.length; i++) {
			if (paras[i].indexOf("page") != -1) {
				old = parseInt(paras[i].split("=")[1]);
				num = parseInt(paras[i].split("=")[1]) + 1;
			}
		}
		var url = "${pageContext.request.contextPath}/ListHousesServlet"
				+ location.search.replace("page=" + old.toString(), "page="
						+ num.toString());
		window.location.href = url;
	}

	function lastPage() {
		var paras = location.search.split("&");
		var old;
		var num;
		for (var i = 0; i < paras.length; i++) {
			if (paras[i].indexOf("page") != -1) {
				old = parseInt(paras[i].split("=")[1]);
				if (old != 1) {
					num = parseInt(paras[i].split("=")[1]) - 1;
				} else {
					num = 1;
				}
			}
		}
		var url = "${pageContext.request.contextPath}/ListHousesServlet"
				+ location.search.replace("page=" + old.toString(), "page="
						+ num.toString());
		window.location.href = url;
	}

	//组合参数
	function submits(x1, x2, x3) {
		var paras = "";
		var searchs = window.location.search;
		//alert(searchs);
		//alert("&district="+getUrlParam("district"));
		if (x1 == "district") {
			if (x2 != "" || x3 != "") {
				if (!getUrlParam("district")) {
					paras = paras + "district=" + x2 + "&";
				} else {
					searchs = searchs.replace(getUrlParam("district"), x2);
				}
			} else {
				searchs = searchs.replace("&district="
						+ getUrlParam("district"), "");
			}
		}
		if (x1 == "cost") {
			if (x2 != "" || x3 != "") {
				if (!getUrlParam("cost")) {
					paras = paras + "cost=" + x2 + "&";
				} else {
					searchs = searchs.replace(getUrlParam("cost"), x2);
				}
			} else {

				searchs = searchs.replace("&cost=" + getUrlParam("cost"), "");
			}
		}
		if (x1 == "room") {
			if (x2 != "" || x3 != "") {
				if (!getUrlParam("room")) {
					paras = paras + "room=" + x2 + "&";
				} else {
					searchs = searchs.replace(getUrlParam("room"), x2);
				}
			} else {
				searchs = searchs.replace("&room=" + getUrlParam("room"), "");
			}
		}
		if (x1 == "area") {
			if (x2 != "" || x3 != "") {
				if (!getUrlParam("area")) {
					paras = paras + "area=" + x2 + "&";
				} else {
					searchs = searchs.replace(getUrlParam("area"), x2);
				}
			} else {
				searchs = searchs.replace("&area=" + getUrlParam("area"), "");
			}
		}

		//alert(paras);

		if (searchs == "") {
			paras = "?" + paras;

		} else {
			paras = searchs + "&" + paras;
		}
		//alert(paras);
		var x1 = paras.split('&');
		var paras2 = "";
		for (var i = 0; i < x1.length - 1; i++) {
			if (i < x1.length - 2) {
				paras2 = paras2 + x1[i] + "&";
			} else {
				paras2 = paras2 + x1[i];
			}
		}

		//alert(paras2);
		var cururl = window.location.href;
		var ur = cururl.split('?')[0];
		var url = ur + paras2;

		var pp = location.search.split("&");
		var old;
		for (var i = 0; i < pp.length; i++) {
			if (pp[i].indexOf("?page") == 0) {
				old = parseInt(pp[i].split("=")[1]);
			}
		}
		url = url.replace("page=" + old.toString(), "page=" + "1");
		//alert(url);
		window.location.href = url;

	}
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css"
	type="text/css" />
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
			</select> <input type="text" name="target"
				style="height: 36px; width: 450px; float: left; margin-top: 10px; border-color: #FF9900; font-size: 18px;">
			<button type="submit" class="sbutton"  onClick="toSearch()">搜 &nbsp索</button>
		</div>
	</div>



	<div class="title1">按条件查询</div>
	<div class="title4"></div>
	<div class="select">
		<label>区域： </label><a href="#" onClick="submits('district','','')"
			class="bx">不限</a>&nbsp <a href="#">白云</a>&nbsp <a href='#'
			onClick="submits('district','天河','')">天河</a>&nbsp <a href="#">花都</a>&nbsp<a
			href="#">黄埔</a>&nbsp<a href="#">越秀</a>&nbsp<a href='#'
			onClick="submits('district','番禺','')">番禺</a><br /> <br /> <label>总价：
		</label><a href='#' onClick="submits('cost','','')" class="bx">不限 </a>&nbsp<a
			href='#' onClick="submits('cost','50','')">50万以下</a>&nbsp <a href='#'
			onClick="submits('cost','50-80','')">50~80万</a>&nbsp <a href='#'
			onClick="submits('cost','80-100','')">80~100万</a>&nbsp <a href='#'
			onClick="submits('cost','100-150','')">100~150万</a>&nbsp <a href='#'
			onClick="submits('cost','150-200','')">150~200万</a>&nbsp <a href='#'
			onClick="submits('cost','200','')">200万以上</a>&nbsp <input type="text"
			id="cost1" style="height: 15px; width: 40px"> - <input
			type="text" id="cost2" style="height: 15px; width: 40px"> 万
		<button onclick="openpage()">确定</button>
		<br /> <br /> <label>户型： </label><a href="#"
			onClick="submits('room','','')" class="bx">不限</a>&nbsp <a href='#'
			onClick="submits('room','1室','')">一室</a>&nbsp <a href='#'
			onClick="submits('room','2室','')">二室</a>&nbsp <a href='#'
			onClick="submits('room','3室','')">三室</a>&nbsp <a href='#'
			onClick="submits('room','4室','')">四室</a>&nbsp <a href='#'
			onClick="submits('room','5室','')">五室</a><br /> <br /> <label>面积：
		</label><a href="#" onClick="submits('area','','')" class="bx">不限 </a>&nbsp<a
			href='#' onClick="submits('area','50','')">50平米以下</a>&nbsp <a
			href='#' onClick="submits('area','50-70','')">50~70平米</a>&nbsp <a
			href='#' onClick="submits('area','70-90','')">70~90平米</a>&nbsp <a
			href='#' onClick="submits('area','90-140','')">90~140平米</a>&nbsp <a
			href='#' onClick="submits('area','140','')">140平米以上</a>
	</div>
	<br />
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

	<div class="title2">
		<b>全部房源</b>
	</div>

	<div class="title3"></div>
	<div class="order">
		<select name="order"
			style="margin-left: 780px; margin-top: 5px; border-color: #ff9900;"
			id="selectchange" onchange="toChange()">
			<option value="default" selected>默认排序</option>
			<option value="cost1">总价由小到大</option>
			<option value="cost2">总价由大到小</option>
			<option value="area1">面积由小到大</option>
			<option value="area2">面积由大到小</option>
		</select>
	</div>

	<c:forEach var="h" items="${house }">
		<div class="date">
			<a
				href="${pageContext.request.contextPath}/DetailHouseServlet?id=${h.id}"
				target="_blank"><img width="230" height="150"
				src="${h.firstimg }" class="img2" /></a>
			<dd class="date1">
				<p class="title">
					<a
						href="${pageContext.request.contextPath }/DetailHouseServlet?id=${h.id}"
						class="bx" style="color: #FF9900; font-size: 17px;"
						target="_blank"> <strong>汇景新城 ${h.title }</strong></a>
				</p>
				<p>${h.room }&nbsp|&nbsp${h.floor}&nbsp|&nbsp
					${h.city}&nbsp|&nbsp 房屋年份：${h.year }</p>
				<p style="font-size: 16px">${h.name }</p>
				<p style="color: #666;">${h.seller }</p>
			</dd>
			<div class="area1">${h.area }㎡</div>
			<div class="cost1">
				<span class="price">${h.cost } </span>万&nbsp ${h.prize }
			</div>
		</div>
		<br>
	</c:forEach>
	<br>

	<p style="margin-left: 500px;">
		<button type="button"
			style="background-color: #FF9900; color: #FFF; border-color: #FF6; font-size: 12px;"
			onclick="lastPage()">上一页</button>
		<button type="button"
			style="background-color: #FF9900; color: #FFF; border-color: #FF6; font-size: 12px;"
			onclick="nextPage()">下一页</button>
	</p>
	<div style="clear: both"></div>
	<footer
		style="width:auto;padding-top:1px;background-color:#202020;height:50px;text-align:center;position:relative;">
	<Pre style="color: #AAA; font-size: 12px;">copyright@circus工作室  All Right Reserved</Pre>
	</footer>
</body>
<br>
</body>
</html>