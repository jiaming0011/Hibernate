<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
function formSubmit(){ 
	
    var action="/neusoft/UpLoad2";         
    action+="?auctionName="+document.getElementById("txt1").value;
    action+="&startPrice="+document.getElementById("txt2").value;
    action+="&upSet="+document.getElementById("txt3").value;
    action+="&startTime="+document.getElementById("txt4").value;
    action+="&endTime="+document.getElementById("txt5").value;
    action+="&desc="+document.getElementById("txt6").value;
    action+="&id2="+${requestScope.Auction1.auctionId};
    document.upload.action=action;        
    document.upload.submit(); 
     
} 
function abolish(){
	location.href="/neusoft/index.html";
}
</script>
<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form id="upload" name="upload" action="" method="post" enctype="multipart/form-data">
          <dl>
            <dd >
              <label>名称：</label>
              <input type="text" class="inputh lf" value="${requestScope.Auction1.auctionName}" name="auctionName" id="txt1"/>
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input type="text" class="inputh lf" value="${requestScope.Auction1.auctionStartPrice}" name="startPrice" id="txt2"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input type="text" class="inputh lf" value="${requestScope.Auction1.auctionUpset}" name="upSet"id="txt3"/>
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input type="text" class="inputh lf" value="${requestScope.Auction1.auctionStartTime}" name="startTime" id="txt4"/>
              <div class="lf red laba">格式：2010-05-05 12:30:00</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input type="text" class="inputh lf" value="${requestScope.Auction1.auctionEndTime}" name="endTime" id="txt5"/>
              <div class="lf red laba">格式：2010-05-06 16:30:00</div>
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
              <div class="lf salebd"><a href="#"><img src="${requestScope.Auction1.auctionPic}" width="100" height="100" /></a></div>
              <input type="file" class="offset10 lf" name="fileName"/>
             
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea name="desc" cols="" rows="" class="textarea" id="txt6" value="${requestScope.Auction1.auctionDesc}">${requestScope.Auction1.auctionDesc}</textarea>
            </dd>
            <dd class="hegas">
                <input name="" type="button" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" onclick="formSubmit()"/>
                <input name="" type="button" value="取 消" class="spbg buttombg buttombgs buttomb f14 lf" onclick="abolish()"/>
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