<%@ page language="java" import="java.sql.*,java.util.*,net.sf.json.JSONArray,com.hao.object.User" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<!--[if IE 8]>         <html class="no-js lt-ie9"> </html><![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8" />
<title>face</title>
<meta name="description" content="neil-hao" />
<meta name="author" content="neil-hao" />
<meta name="robots" content="noindex, nofollow" />
<meta name="viewport" content="width=device-width,maximum-scale=1.3,user-scalable=no"><!--手机自动缩放-->
<link rel="shortcut icon" href="./img/favicon.ico" /><!--网页标题图标-->
<!-- 引入 PROUI 的样式表  不用更改它的设置-->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/plugins.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<!-- PROUI 样式结束-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
.nav.navbar-nav-custom>li.open>a,.nav.navbar-nav-custom>li>a:focus,.nav.navbar-nav-custom>li>a:hover{background:none;}
</style>
</head>
<body style=" background:#FFFFFF; margin:0; padding:0; padding-bottom:55px">
<div id="page-container" style=" background:#FFFFFF">
<!--没有内容的时候start-->
<div style="position:absolute; left:50%; top:20%; margin-left:-40px; font-size:80px; display:none; z-index:9999; color:#EAEAEA" id="nocontent">
	<i class="fa fa-frown-o"></i>
</div>
<!--没有内容的时候END-->
<div class="row" style="padding-top:8px" id="msgl">  
<!--列表循环开始-->
<!--div class="col-xs-12" style="padding-bottom:8px;">  
	<a href="msg.html?uid=zhy"> 
		<div class="col-xs-2">
			<img src="img/6.jpg" class="widget-image image-circle" style="width:50px;height:50px; border-radius:0px">
		    <span  style="background:#FF0000; position:absolute;left:59px; top:-2px; width:10px; height:10px; border-radius:5px;"></span>
		</div>    
		<div class="col-xs-10">
			<span class="pull-left" style="padding-left:5px; font-size:16px; color:#000000">
				<b>订阅号</b>
				<font style="font-size:12px; color:#CCCCCC"></font>
			</span>
			<span class="pull-right" style="padding-top:5px; color:#CCCCCC; font-size:12px">早上11:56</span>
			<br>
			<div style="width:100%;padding-top:10px; color:#999999; padding-left:5px; font-size:14px" class="text-left">广告也是一种生活
				<span class="pull-right">&nbsp;</span>
			</div>	
		</div>
	</a>
</div-->
<!--列表循环end-->
</div>  
<script type="text/javascript" >
alert(window.innerWidth);
alert(window.devicePixelRatio);
function changeFrameHeight(){
    var ifm= document.getElementById("iframepage"); 
    ifm.height=document.documentElement.clientHeight;
    ifm.width=document.documentElement.clientWidth;
}
window.onresize=function(){  
     changeFrameHeight();  
} 
</script>
<iframe  id="iframepage" src="/jslinux-bellard/kb.html"  scrolling="no" onload="changeFrameHeight()" frameborder="0"></iframe>	
	
<footer class="navbar navbar-default navbar-fixed-bottom slideUp" role="navigation" style="  background-color:FEFFFF;border-top:#E6E6E6 1px solid; opacity:0.9; line-height:55px;  height:55px;  z-index:1; padding-top:0px;" id="st-footer-bar">
<div class="row" style=" padding-left:15px; padding-right:10px">
<ul class="nav navbar-nav-custom col-xs-6 text-center pull-left">
	<li class="col-xs-6">
		<a onclick="javascript:$(this).css('color','#33CC00');$('#st-footer-bar').css('color','#FFFFFF');" href="index.jsp" style="color:#999999;" id="fchat">
			<!--未读红点
			<span  style="background:#FF0000; position:absolute;left:38px; top:7px; width:10px; height:10px; border-radius:5px; display:block" id="footer_qipao"></span>-->
			<i class="gi gi-chat" style="font-size:30px"></i>
			<div class="text-center" style=" line-height:18px; padding-bottom:25px;font-size:12px;">微信</div>
		</a>
	</li>
	<li class="col-xs-6">
		<a onclick="javascript:$(this).css('color','#33CC00');$('#st-footer-bar').css('color','#FFFFFF');"  href='users.jsp' style="color:#999999;" id="users">
			<i class="gi gi-parents" style="font-size:30px"></i>
			<div class="text-center" style=" line-height:18px; padding-bottom:25px;font-size:12px;">通讯录</div>
		</a>
	</li>
</ul>
<ul class="nav navbar-nav-custom pull-right col-xs-6 text-center" >
	<li class="col-xs-6">
		<a onclick="javascript:$(this).css('color','#33CC00');$('#st-footer-bar').css('color','#FFFFFF');"  style="color:#33CC00;"  id="discover">
			<i class="gi gi-compass" style="font-size:30px; color:#33CC00"></i>
			<div  class="text-center" style=" line-height:18px; padding-bottom:25px;font-size:12px;" >发现</div>
		</a>
	</li>
	<li class="col-xs-6">
		<a onclick="javascript:$(this).css('color','#33CC00');$('#st-footer-bar ').css('color','#FFFFFF');" href="login.jsp" style="color:#999999;" id="myself">
			<i class="gi gi-user" style="font-size:30px"></i>
			<div class="text-center" style=" line-height:18px; padding-bottom:25px;font-size:12px;" >我</div>
		</a>
	</li>
</ul>
</div>
</footer>  
</div>   
<script src="js/jquery-1.11.0.min.js"></script>
</body>
</html> 
      
