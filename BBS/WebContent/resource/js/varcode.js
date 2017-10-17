function checkVarcode(){
	var varcode = document.getElementById("varcode").value;
	var XMLHttpRequest = getXMLHttpRequest();
	var divmsg = document.getElementById("msg");
	XMLHttpRequest.open("get","CheckVarcodeServlet?varcode="+varcode);
	XMLHttpRequest.onreadystatechange=function(){
		if(XMLHttpRequest.readyState==4 && XMLHttpRequest.status==200){
			var flag = XMLHttpRequest.responseText;
			if(flag=="false"){
				if(varcode.length==4){
					divmsg.style.color="red";
					divmsg.innerHTML="验证码错误！！！";
					
				}
			}else{
				divmsg.style.color="green";
				divmsg.innerHTML="验证码正确...";
			}			
		}	
	}
	XMLHttpRequest.send(null);
}
function refresh(){  
	document.getElementById("authimg").src="AuthImgServlet?now="+new Date();//使用时间作为参数避免浏览器从缓存取图片  
}
function clearMsg(){
	var divmsg = document.getElementById("msg");
	divmsg.innerHTML="";
}