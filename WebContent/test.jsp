<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>详情页</title>
</head>
<link rel="stylesheet" href="xinxi.css" type="text/css" />
<body>
	<div class="nav">
		<p
			style="color: #FFF; float: right; margin-top: 2px; margin-right: 10px;">
			<a class="dl" href="denglu.html">登陆</a> | <a class="dl"
				href="zhuce.html">注册</a>
		</p>
	</div>
	<div class="nav1">
		<a href="shouye.html"><img src="images/icon3.png" width="140"
			height="70"></a>
		<div class="nav2">
			<input type="text" name="target"
				style="height: 36px; width: 509px; float: left; margin-top: 10px; border-color: #FF6; font-size: 18px;">
				<button type="submit" class="sbutton">搜 &nbsp索</button>
		</div>
	</div>


	<div class="nav3">
		<a href="#">二手房网</a> > <a href="#">广州二手房</a> > <a href="#">番禺二手房</a>
	</div>


	<div class="hold">
		<div class="date">
			<h style="font-size:24px;color:#de3438;"> <strong>汇景新城
				楼龄四房 装修保养一流 视野开阔 户型方正实用</strong></h>
			<br /> <br /> <img name="tu" src="images/例图1.jpg" width="450"
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
				总价：&nbsp <span class="price">${house.cost }</span>万&nbsp （31707元/㎡）
			</p>
			<p>户型：&nbsp&nbsp${house.room }</p>
			<p>建筑面积：&nbsp&nbsp${house.area }㎡</p>
			<p>楼层：&nbsp&nbsp${house.floor }</p>
			<p>房屋年份：&nbsp&nbsp${house.year }</p>
			<p>楼盘名称：&nbsp&nbsp${house.name }</p>
		</div>
		<div class="seller">
			<img name="sellerimg" src="" width="125" height="150" alt="" /><br />
			<p>姓名：${house.seller }</p>
			<p>联系电话：${house.phone }</p>
		</div>
	</div>
	<div class="history">
		<div class="h1">浏览历史</div>
		<div class="h2">
			<a href="#"><img src="images/例图1.jpg" width="191" height="116" /></a><a
				href="#">汇景新城</a>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			250万
		</div>
	</div>
	<div class="nav4">
		<b>详细信息</b>
	</div>
	<div class="date2">
		<h style="font-size:24px;font-weight:bolder;">房源信息</h>
		<br /> <br />${house.description }<br /> <br />
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
