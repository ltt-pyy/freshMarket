<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*,java.net.URLDecoder"%>
<%@ page import="java.util.*" %>
<%	request.setCharacterEncoding("utf-8") ;	%>
<!DOCTYPE html>

<html>

	<head>
		
		<title></title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/page.js"></script>
		
	</head>

	<body>

		<header>
			<%@include file="header.jsp"%>
		</header>
		<div class="container">
			
			<div id="table1">
				<ul class="thumbnails lists" id="group_one">
				<%

	String keyWord = request.getParameter("key");
				%>
				<%
	if(keyWord == null){
		keyWord = "" ;	// 如果没有查询关键字，则查询全部
	}
	keyWord=URLDecoder.decode(keyWord,"utf-8");
	List<Fresh> all = DAOFactory.getIFreshDAOInstance().findAll(keyWord);
	
	Iterator<Fresh> iter = all.iterator() ;
    while(iter.hasNext()){
		
		Fresh fresh = iter.next() ;
   %>
  
					<a href="fresh-info.jsp?freshId=<%=fresh.getfreshId()%>">
						<li class="span6">
						<div class="thumbnail">
						
							<img src=<%=fresh.getfreshImg()%> alt="">
							<div class="miaoshu">
								<h4><%=fresh.getfreshName()%></h4>
								<p><%=fresh.getIntroduct()%></p>
								<span class="disabled-price price">￥<%=fresh.getPrice()%></span>
								<span class="price"><strong>￥<%=fresh.getNew_price()%></strong></span>
							</div>

						</div>
					</li>
					</a>
					
					<%
	}
	%>

				</ul>
			</div>
			<ul class="pager">
           <li class="previous">
              <a href="#" onclick="page.prePage();">&larr;上一页</a>
           </li>
           <li class="next">
              <a href="#" onclick="page.nextPage();">下一页 &rarr;</a>
           </li>
           </ul>
		</div>
		<%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
			
		</footer>
		
    
	</body>

</html>