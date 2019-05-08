<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="fresh.util.*"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*"%>

<% 
	request.setCharacterEncoding("utf-8") ; 
%>
<html>

	<head>
		<meta charset="utf-8" />
		<title></title>

		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/index.css" />
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	</head>

<%
String freshId=null;
try {
freshId = request.getParameter("freshId") ;
} catch (Exception e){}
Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
%>

	<body>

		<header>
			<%@include file="header.jsp"%>
		</header>
		<div class="container">
      <div id="update">
    <div >
            <div>
    	     <a href="houtai.jsp" class="btn"> 返回</a>
    	     </div>
    	<form action="UpdateServlet" method="post">
    	     
    		<div>
    			<span class="left_label">选择生鲜类别：</span>
    			<select name="fresh_type">
                    <option value="01">水果</option>
                    <option value="02">蔬菜</option>
                    <option value="03">海鲜</option>
                    <option value="04">禽畜</option>
                    <option value="05">饮品</option>
					<option value="06">粮油</option>
					<option value="07">零食</option>
                </select>
    		
    		</div>
    		<div>
    		    <input name="fresh_id" value="<%=freshId%>" type="hidden">
    			<span class="left_label">生鲜名：</span>
    			<input type="text" required name="fresh_name" value="<%=fresh.getfreshName()%>"/>
    		</div>
    		
    		<div>
    			<span class="left_label">添加封面图：</span>
    			<input type="hidden" name="fresh_img" value=<%=fresh.getfreshImg()%>>
    			
               
                <img id="preview_size_fake" src=<%=fresh.getfreshImg()%>>
    	    </div>
    	  
    		<div>
    			<span class="left_label">产地：</span>
    			<input type="text" name="fresh_production" value="<%=fresh.getproduction()%>"/>
    		</div>
    		<div>
    			<span class="left_label">简介：</span>
    			<textarea  name="fresh_introduct"><%=fresh.getIntroduct() %></textarea>
    			
    		</div>
    		<div>
    			<span class="left_label">价格：</span>
    			<input type="text" name="fresh_price" value="<%=fresh.getPrice()%>"/>
    		</div>
    		<div>
    			<span class="left_label">优惠价格：</span>
    			<input  type="text" name="fresh_newprice" value="<%=fresh.getNew_price()%>"/>
    		</div>
    		<div>
    			<span class="left_label">库存：</span>
    			<input type="text" name="fresh_num" value="<%=fresh.getNum()%>"/>
    		</div>
    	
    		<div>
    		    <button type="submit" class="btn btn-info">保存修改并上架</button>
    		</div>
    	</form>
    	<div>
    	     <a href="houtai.jsp" class="btn btn-info">取消并返回</a>
    	 </div>
    </div>        	
</div>
</div>
		<%@include file="login.jsp"%>
		<footer>
		<%@ include file="footer.jsp"%>
			
		</footer>
		
		
	</body>
	

</html>

