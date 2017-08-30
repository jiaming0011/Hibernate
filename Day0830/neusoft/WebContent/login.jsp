<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="/neusoft/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
function changeImg(){
	var img = document.getElementById("img");  
	img.src = "/neusoft/ValidateCodeServlet?date=" + new Date();
}

</script>
<body>
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebar">
     <p><img src="images/img1.jpg" width="443" height="314" alt="" /></p>
   </div>
   <div class="sidebarg">
     <form action="/neusoft/UserAction" method="post" >
    <div class="login">
      <dl>
        <dt class="blues">用户登陆</dt>
        <dd><label for="name">用户名：</label><input type="text" class="inputh"  id="name" name="uname"/></dd>
        <dd><label for="password">密 码：</label><input type="password" class="inputh"  id="password" name="upassword"/></dd>
        <dd>
           <label class="lf" for="passwords">验证码：</label>
           <input type="text" class="inputh inputs lf"  id="passwords" name="yanzhengma"/>
           <span class="wordp lf">
           <img id="img" src="/neusoft/ValidateCodeServlet" width="96" height="27" />
           </span>
           <span class="blues lf">
			<a href='#' onclick="javascript:changeImg()"><label>看不清？</label></a>
			</span>
        </dd>
        <dd>
           <input name="admin"  type="checkbox" id="rem_u"  />
           <span for="rem_u">管理员</span>
        </dd> 
           <input name="" type="submit" value="登 录" class="spbg buttombg f14 lf" />
           <input type="button" value="注 册" class="spbg buttombg f14 lf" id="button1" />
           <span class="blues  lf"><a href="" title="">忘记密码?</a></span>
           <div class="cl"></div>
        </dd>
       
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->
 
</div>
</body>
<script language="JavaScript">
$("#button1").click(function(){
	$(location).attr('href','register.jsp');
});
</script>
</html>