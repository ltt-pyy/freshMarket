<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*"%>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="utf-8">
		<title>
		</title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
	</head>
<%
String freshId=null;
try {
freshId = request.getParameter("freshId") ;
} catch (Exception e){}
Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);

%>
	<body id="fresh-info">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container">
			<ul class="thumbnails">
				<li class="span4">
					<div class="thumbnail">
						<img src=<%=fresh.getFreshImg()%> alt="" id="fresh-info-img">

					</div>
				</li>
				<li class=" span4">
			
					<div class="">
						<h4 >生鲜名：<%=fresh.getFreshName() %>
						
						</h4>
						<p >价格：
						<span class="disabled-price price">￥<%=fresh.getPrice()%></span>
						</p>
						<p >优惠价格:
						<span class="price"><strong>￥<%=fresh.getNew_price()%></strong></span>
						</p>
						<p >库存：<%=fresh.getNum() %>
						
						
						</p>
						<p >选择数量：<button id="left-btn" class="btn">-</button><input id="choose-num" type="text" value="1" name="chooseNum"><button id="right-btn" class="btn">+</button></p>
					    
					</div>
					<div class="info-btns">
						<button class="btn info-btn">立即购买</button>
						<button class="btn info-btn">加入购物车</button>
					</div>
					
				</li>
			</ul>
			<div >
			    <h4>简介：</h4>
			    <p><%=fresh.getIntroduct() %></p>
			     
				
			</div>
		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	</body>
    <script type="text/javascript">
    window.onload=function(){
    	var left=document.getElementById('left-btn');
    	var right=document.getElementById('right-btn');
    	var num=document.getElementById('choose-num');
    	var btns=document.getElementsByClassName('info-btn');
    	left.onclick=function(){
    		if(num.value<2){
    			num.value=1;
    		}else{
    			num.value--;
    		} 	    		
    	}
    	right.onclick=function(){
    		num.value++;
    	}	
    	
       var id="<%=request.getSession().getAttribute("id")%>";
        ///alert(id=="null");
    	btns[0].onclick=function(){
    		if(id!="null"){
    			var src="FreshInfoServlet?id=<%=request.getSession().getAttribute("id")%>&freshId=<%=fresh.getFreshId()%>&chooseNum="+num.value;
    			//alert(src);
    			window.location.href=src;
    		}else{
    			alert("请先登陆！");
    		}
    		
    	}
    	
    	btns[1].onclick=function(){
    		if(id!="null"){
    			
    			window.location.href="AddInCartServlet?id=<%=request.getSession().getAttribute("id")%>&freshId=<%=fresh.getFreshId()%>&chooseNum="+num.value;
    		}else{
    			alert("请先登陆！");
    		}
    	}
    
    }
    </script>
	</html>