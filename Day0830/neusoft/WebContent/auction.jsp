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

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="#" title="注销">注销</a></div>
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${a.auctionName}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${a.auctionDesc}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${a.auctionStartTime}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${a.auctionEndTime}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${a.auctionStartPrice}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="${a.auctionPic}" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  <form action="/neusoft/PriceAction?id=${a.auctionId}" method="post">
  <div class="top10 salebd">
       <p>
       <label for="sale">出价：</label>
       <input type="text"  class="inputwd" id="sale" value="4000" name="auctionPrice"/>
       <input name="" type="submit" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </p>
       <p class="f14 red">不能低于最高竞拍价</p>
  </div>
  </form>
  <div class="top10">
    <input name="" type="submit" value="刷 新" class="spbg buttombg f14" />
    <input name="" type="submit" value="返回列表" class="spbg buttombg f14" />
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
      <c:forEach var="record" items="${a.record1}">
      <ul class="rows">
        <li>${record.auctionTime}</li>
        <li>${record.auctionPrice}</li>
        <li class="borderno">${record.userId.userName}</li>
      </ul>
      </c:forEach>
  </div>
  </div>
<!-- main end-->
</div>
</body>
</html>