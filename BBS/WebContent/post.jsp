<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>post Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
		<!--<script src="js/jquery-1.11.3.js"></script>	
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>-->
		<script type="text/javascript" src="js/jquery-1.11.3.js" ></script>
		<script src="js/bootstrap.js"></script>
        <style type="text/css">
        .container{width: 1400px;height:1500px;border: 1px solid;}
       	#header{width: 100%;height: 79px;border: 1px solid;}
       	#logo{height:77px; width:80px;margin-left: 120px;float: left;}
<<<<<<< .mine
       	#body{width: 100%;height:900px;border: 1px solid purple;}
       	#body1{width: 350px;height:897px;border:‘ 1px solid red;float: left;}
       	#body2{width: 620px;height:897px;border: 1px solid red;float: left;}
		#body3{width: 379px;height:897px;float: left;background-color: midnightblue;float: left;}
		#txpic{width: 90px;height:85px;margin-left: 100px;background: #E4B9C0;margin-top: 20px;}
=======
       	#body{width: 100%;height: 1300px;border: 1px solid purple;}
       	#body1{width: 300px;height: 997px;border: 1px solid red;float: left;}
       	#body2{width: 640px;height: 997px;border: 1px solid red;float: left;}
       	#comment{width:639px;height:630px;background-color: pink;}
		#body3{width: 389px;height: 997px;float: left;background-color: midnightblue;float: left;}
		#txpic{width: 90px;height: 85px;margin-left: 100px;background: #E4B9C0;margin-top: 60px;}
>>>>>>> .r83
		#username{margin-left: 100px;}
		#postname{margin-left: 250px;}
		#postcontent{width: 639px;height:300px;background-color: lightblue;}
       </style>   
    </head>
   
    <body>
    	<div class="container">
    		<div id="header">
    			<img id="logo" src="img/logo.png" ><br><span id="postname" style="padding-left: 150px;color: #2C8BDE;font-size: 30px;text-align: center;">每天在450万个贴吧中为你搜寻所爱！</span>
    		</div>
    		<div id="body">
    			<div id="body1">
    				<div id="txpic"><img id="tx" src="${param.post.user.userpic}" ></div>
    				<span id="username">${param.post.user.username}</span>
    			</div>
    			<div id="body2">
    			<h2 id="postname">${param.post.ptitle}</h2>
    			<div id="postcontent">${param.article}</div>
    			<div id="comment">一级评论</div>
    			</div>
    			<div id="body3">123</div>
    		</div>
    		你好   		

    	</div>
    		
    	
 	</body>
</html>