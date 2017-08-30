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
	function fabu(){
		
		location.href="/neusoft/addAuction.jsp";
	}
	function fabu2(){		
		alert("请先登录！");
	}
</script>
<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <c:if test="${sessionScope.auctionUser!=null}">
    	<div class="logout right"><a href="/neusoft/cancelAction" title="注销">注销</a></div>
    </c:if>
    <c:if test="${sessionScope.auctionUser==null}">
    	<div class="logout right"><a href="login.jsp" title="">登录</a></div>
    </c:if>
  </div>
  <div class="forms">
  <form action="/neusoft/PageAction?pageIndex=1" method="post">
    <label for="name">名称</label>
    <input name="cName" type="text" class="nwinput" id="name" value="${au.auctionName}"/>
    <label for="names">描述</label>
    <input name="cDesc" type="text" id="names" class="nwinput" value="${au.auctionDesc}"/>
    <label for="time">开始时间</label>
    <input name="cStartTime" type="text" id="time" class="nwinput" value="${au.auctionStartTime}"/>
    <label for="end-time">结束时间</label>
    <input name="cEndTime" type="text" id="end-time" class="nwinput" value="${au.auctionEndTime}"/>
    <label for="price">起拍价</label>
    <input name="cPrice" type="text" id="price" class="nwinput" value="${au.auctionStartPrice}"/>
    <input  type="submit"  value="查询" class="spbg buttombg f14  sale-buttom"/>
  </form>
    <c:if test="${sessionScope.auctionUser!=null}">
    <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb" onclick="fabu()"/>
    </c:if>
    <c:if test="${sessionScope.auctionUser==null}">
    <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb" onclick="fabu2()"/>
    </c:if>
  </div>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <c:if test="${requestScope.AuctionPage!=null}">
      <c:forEach var="Auction" items="${requestScope.AuctionPage.list}" varStatus="state">
      <c:if test="${state.index%2==0}">
      	<ul class="rows">
        <li><a href="国书" title="">${Auction.auctionName}</a></li>
        <li class="list-wd">${Auction.auctionDesc}</li>
        <li>${Auction.auctionStartTime}</li>
        <li>${Auction.auctionEndTime}</li>
        <li>${Auction.auctionStartPrice}</li>
        <li class="borderno red">
        <c:if test="${sessionScope.auctionUser!=null&&sessionScope.auctionUser.userIsadmin==1}">
          <a href="/neusoft/UpdateAuction?id=${Auction.auctionId}" title="竞拍" >修改</a>|
          <a href="/neusoft/DelAuction?id=${Auction.auctionId}"  title="竞拍" onclick="javascript:return dele()">删除</a>
        </c:if>
        <c:if test="${sessionScope.auctionUser==null}">
          <a href="javascript:fabu2()" title="竞拍">竞拍</a>          
        </c:if>
        <c:if test="${sessionScope.auctionUser!=null&&sessionScope.auctionUser.userIsadmin==0}">
          <a href="/neusoft/AuctionAction?id=${Auction.auctionId}" title="竞拍">竞拍</a>          
        </c:if>          
        </li>
      </ul>
      </c:if>
      <c:if test="${state.index%2!=0}">
      <ul class="rows even">
        <li><a href="国书" title="">${Auction.auctionName}</a></li>
        <li class="list-wd">${Auction.auctionDesc}</li>
        <li>${Auction.auctionStartTime}</li>
        <li>${Auction.auctionEndTime}</li>
        <li>${Auction.auctionStartPrice}</li>
        <li class="borderno red">
        <c:if test="${sessionScope.auctionUser!=null&&sessionScope.auctionUser.userIsadmin==1}">
          <a href="/neusoft/UpdateAuction?id=${Auction.auctionId}" title="竞拍" >修改</a>|
          <a href="/neusoft/DelAuction?id=${Auction.auctionId}"  title="竞拍" onclick="javascript:return dele()">删除</a>
        </c:if>
        <c:if test="${sessionScope.auctionUser==null}">
          <a href="javascript:fabu2()" title="竞拍">竞拍</a>          
        </c:if>
        <c:if test="${sessionScope.auctionUser!=null&&sessionScope.auctionUser.userIsadmin==0}">
          <a href="/neusoft/AuctionAction?id=${Auction.auctionId}" title="竞拍">竞拍</a>          
        </c:if>         
        </li>
      </ul>
      </c:if>
      </c:forEach> 
      </c:if>   
      <div class="page">
        <a href="/neusoft/PageAction?pageIndex=${1}" title="">首页</a>
        <c:if test="${requestScope.AuctionPage.pageIndex!=1}">
        <a href="/neusoft/PageAction?pageIndex=${requestScope.AuctionPage.pageIndex-1}" title="">上一页</a>
 		</c:if>
 		<c:forEach var="x" begin="1" end="${requestScope.AuctionPage.numpage}">
        <a href="/neusoft/PageAction?pageIndex=${x}" title="">${x}</a> 
        </c:forEach>
        <c:if test="${requestScope.AuctionPage.pageIndex!=requestScope.AuctionPage.numpage}">
        <a href="/neusoft/PageAction?pageIndex=${requestScope.AuctionPage.pageIndex+1}" title="">下一页</a>
        </c:if>
        <a href="/neusoft/PageAction?pageIndex=${requestScope.AuctionPage.numpage}" title="">尾页</a> 
      </div>
  </div>
  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){
	    
		   return true;
		 }
		 else{
			 return false;
			 }
			 
	   };
	   function dele(){
		   if(confirm("你真的确认要修改吗？请确认")){
			   return true;
			   }
			   else{
				   return false;
				   }
		   }
  </script>
<!-- main end-->
</div>
</body>
<script language="javascript">
	
</script>
</html>