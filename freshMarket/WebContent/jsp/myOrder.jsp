<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*"%>
<%@ page import="java.util.*" %>
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

	<body id="buy">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		<div class="container" >
			<ul class="nav nav-tabs" id="myTab">
                <li class="active"><a href="#home">所有订单</a></li>
                <li><a href="#obligation">待付款</a></li>
                <li><a href="#unfilled">待发货</a></li>
                <li><a href="#notGet">待收货</a></li>
               
            </ul>
                      <%
                      //String userId=String.valueOf(request.getSession().getAttribute("id"));
                        String userId=String.valueOf(request.getSession().getAttribute("id"));
                        List<Order> all = DAOFactory.getIOrderDAOInstance().findAll(userId) ;
                        Iterator<Order> iter = all.iterator() ;
                        %>
 
            <div class="tab-content">
                <div class="tab-pane active" id="home">
               
                	<div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
					 <%
					
                while(iter.hasNext()){
                	 Order order1= iter.next() ;
                    String freshId=order1.getFreshId();
                    Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
                %>
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="6">
									
								    <span>商家：网上生鲜超市</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=fresh.getFreshImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=fresh.getFreshName() %>》</p>
								
								    
								    <p>
									   金额：￥<%=order1.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order1.getFee()*order1.getNum() %>
								    </p>
							    </td>
								    
							    <td>
									<p>数量：<%=order1.getNum() %></p>
								</td>
								<td>
									<p>订单状态：<%=order1.getOrderState() %></p>
								</td>
							  
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
								
							</tr>
							
						</table>	
						</li>
						<%
                	}%>
					
		    </div>
   
                	
                 </div>	 
                <div class="tab-pane" id="obligation">
                <div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
		        	<%
                      //String userId=String.valueOf(request.getSession().getAttribute("id"));
                        String userId2=String.valueOf(request.getSession().getAttribute("id"));
                        List<Order> all2 = DAOFactory.getIOrderDAOInstance().findAll(userId2) ;
                        Iterator<Order> iter2 = all2.iterator() ;
                        %>
 
                	 <%
                while(iter2.hasNext()){
    				
    				Order order2= iter2.next() ;
    				if(order2.getOrderState().equals("未付款")){
                    String freshId=order2.getFreshId();
                   
                    	
                   
                    Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
                %>
                
               
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="7">
									
								    <span>商家：网上生鲜超市</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=fresh.getFreshImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=fresh.getFreshName() %>》</p>
								
								    
								    <p>
									   金额：￥<%=order2.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order2.getFee()*order2.getNum() %>
								    </p>
							    </td>
								    
							    <td>
									<p>数量：<%=order2.getNum() %></p>
								</td>
							  
							    <td>
									<p>订单状态：<%=order2.getOrderState() %></p>
								</td>
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
							     <td>
								   <a href="PayOrderServlet?orderId=<%=order2.getOrderId() %>" class="btn" >去付款</a>
							    </td>
								
							</tr>
							
						</table>	
						</li>
						<% }
                	}%>
				</ul>	
              </div>
              </div>
                <div class="tab-pane" id="unfilled">
                	<div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
		        	<%
                      //String userId=String.valueOf(request.getSession().getAttribute("id"));
                        String userId3=String.valueOf(request.getSession().getAttribute("id"));
                        List<Order> all3 = DAOFactory.getIOrderDAOInstance().findAll(userId3) ;
                        Iterator<Order> iter3 = all3.iterator() ;
                        %>
 
                	 <%
                while(iter3.hasNext()){
    				
    				Order order3= iter3.next() ;
    				if(order3.getOrderState().equals("待发货")){
                    String freshId=order3.getFreshId();
                   
                    	
                   
                    Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
                %>
                
               
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="6">
									
								    <span>商家：网上书店</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=fresh.getFreshImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=fresh.getFreshName() %>》</p>
								
								    
								    <p>
									   金额：￥<%=order3.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order3.getFee()*order3.getNum() %>
								    </p>
							    </td>
								    
							    <td>
									<p>数量：<%=order3.getNum() %></p>
								</td>
							  
							    <td>
									<p>订单状态：<%=order3.getOrderState() %></p>
								</td>
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
								
							</tr>
							
						</table>	
						</li>
						<% }
                	}%>
				</ul>	
              </div>

                </div>
                <div class="tab-pane" id="notGet">
                <div class="buy_order buy_boder">
		        	<ul class="thumbnails lists">
		        	<%
                      //String userId=String.valueOf(request.getSession().getAttribute("id"));
                        String userId4=String.valueOf(request.getSession().getAttribute("id"));
                        List<Order> all4 = DAOFactory.getIOrderDAOInstance().findAll(userId4) ;
                        Iterator<Order> iter4= all4.iterator() ;
                        %>
 
                	 <%
                while(iter4.hasNext()){
    				
    				Order order4= iter4.next() ;
    				if(order4.getOrderState().equals("已发货")){
                    String freshId=order4.getFreshId();
                   
                    	
                   
                    Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
                %>
                
               
						<li class="span11 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="7">
									
								    <span>商家：网上生鲜超市</span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=fresh.getFreshImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=fresh.getFreshName() %>》</p>
								
								    
								    <p>
									   金额：￥<%=order4.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order4.getFee()*order4.getNum() %>
								    </p>
							    </td>
								    
							    <td>
									<p>数量：<%=order4.getNum() %></p>
								</td>
							  
							    <td>
									<p>订单状态：<%=order4.getOrderState() %></p>
								</td>
							    <td>
								    <p>
									配送费：无
								    </p>
							    </td>
							    <td>
								   <a href="GetfreshServlet?orderId=<%=order4.getOrderId() %>" class="btn" onclick="event.returnValue = confirm('确认收货将扣取费用，你确认要收货吗？');">确认收货</a>
							    </td>
								
							</tr>
							
						</table>	
						</li>
						<% }
                	}%>
				</ul>	
              </div>	
                </div>
                
            </div>
           
           
		       
		    
		</div>
	     <%@include file="login.jsp"%>
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	     <script>
          
            
                $(function () {
                	
               $('#myTab a').click(function (e) {
                   e.preventDefault();
                   $(this).tab('show');
                   })
                })
             
        </script>
	</body>

	</html>