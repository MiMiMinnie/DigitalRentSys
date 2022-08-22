<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'return.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/index.css" type="text/css" rel="stylesheet">
	  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	  <script type="text/javascript">
		  $(function(){
			  $("#next").click(function(){
				  var pages = parseInt($("#pages").html());
				  var page = parseInt($("#currentPage").html());
				  if(page == pages){
					  return;
				  }
				  page++;
				  location.href = "/admin?method=getBorrowed&page="+page;
			  })

			  $("#previous").click(function () {
				  var page = parseInt($("#currentPage").html());
				  if(page == 1){
					  return;
				  }
				  page--;
				  location.href = "/admin?method=getBorrowed&page="+page;
			  })

			  $("#first").click(function () {
				  location.href = "/admin?method=getBorrowed&page=1";
			  })

			  $("#last").click(function(){
				  var pages = parseInt($("#pages").html());
				  location.href = "/admin?method=getBorrowed&page="+pages;
			  })
		  })
	  </script>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
				当前位置:&nbsp;&nbsp;<a href="/admin?page=1">租用管理</a>
				<div id="readerBlock">欢迎回来&nbsp;:${admin.username }&nbsp;<a href="/logout">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort2.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>产品名称</td>
				<td>租出方</td>
				<td>制造商</td>
				<td>用户姓名</td>
				<td>证件编号</td>
				<td>联系电话</td>
				<td>租出时间</td>
				<td>归还时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="borrow">
			<tr>
				<td>
					${borrow.id }
				</td>
				<td>
					${borrow.product.name }
				</td>
				<td>
					${borrow.product.lessor }
				</td>
				<td>
						${borrow.product.manufacturer }
				</td>
				<td>
					${borrow.user.name }
				</td>
				<td>
					${borrow.user.cardId }
				</td>
				<td>
					${borrow.user.tel }
				</td>
				<td>
					${borrow.borrowTime }
				</td>
				<td>
					${borrow.returnTime }
				</td>
				<td>
					<a href="/admin?method=handle&id=${borrow.id }&state=3">归还</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		<hr class="hr"/>
		<div id="pageControl">
			<div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
			<div class="pageControl_item" id="last">最后一页</div>
			<div class="pageControl_item" id="next">下一页</div>
			<div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
			<div class="pageControl_item" id="previous">上一页</div>
			<div class="pageControl_item" id="first">首页</div>
		</div>
	</div>
  	
   <%@ include file="footer.jsp" %>
  </body>
</html>
