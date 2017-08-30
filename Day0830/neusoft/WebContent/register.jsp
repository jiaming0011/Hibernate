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
<script type="text/javascript" src="/neusoft/js/register.js"></script>
<body>
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
        <form action="/neusoft/RegisterAction" method="post">
        	<dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text" class="inputh lf"  id="register-account" onkeyup="checkAccount()" name="newName"/>
             <div class="lf red laba" id="message-box1"></div>
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input type="text" class="inputh lf" id="register-password" onkeyup="checkPassword()" name="newPassword"/>
              <div class="lf red laba" id="message-box2"></div>
            </dd>
            <dd>
              <label> <small>*</small>身份证号</label>
              <input type="text" class="inputh lf" id="register-card" onkeyup="checkCard()" name="newCard"/>
              <div class="lf red laba" id="message-box3"></div>
            </dd>
            <dd>
              <label> <small>*</small>电话</label>
              <input type="text" class="inputh lf" id="register-tel" onkeyup="checkTel()" name="newTel"/>
              <div class="lf red laba" id="message-box4"></div>
            </dd>
            <dd>
              <label> <small></small>住址</label>
              <input type="text" class="inputh lf" value="" name="newAddress" />
            </dd>
            <dd>
              <label> <small></small>邮政编码</label>
              <input type="text" class="inputh lf" value="" name="newEmail"/>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
               <input name=""  type="checkbox" id="rem_u"  onclick="checkAll()" />
              <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
              <input name="" type="submit" value="立即注册" id="rg" disabled="true"/>
            </dd>
          </dl>
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
</div>
</body>
</html>