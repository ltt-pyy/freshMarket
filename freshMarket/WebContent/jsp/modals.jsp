<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*"%>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>

    	<div id="modals" class="tab-pane">
            	<ul class="thumbnails lists">
				
<%
String keyWord2=null;
if(keyWord2==null){
	keyWord2="";
}
List<Order> all2 = DAOFactory.getIOrderDAOInstance().findAll(keyWord2) ;
Iterator<Order> iter2 = all2.iterator() ;
while(iter2.hasNext()){
	Order order = iter2.next() ;
	if(order.getOrderState().equals("待发货")){
	Fresh fresh=DAOFactory.getIFreshDAOInstance().findById(order.getFreshId());
	
%>	
						<li class="span9 ">
						<table class="table table-bordered table-striped"> 
							<tr>
								<td colspan="5">
									<input type="checkbox" />订单编号：<%=order.getAddId() %>
								    <span>下单时间：<%=order.getTime() %></span>
								</td>
								
							</tr>
							<tr>
								<td>
									<img src=<%=fresh.getFreshImg() %> width="120" >
								</td>
								
							    <td>
								
								    <p>《<%=fresh.getFreshName() %>》</p>
								
								    <p>数量：<%=order.getNum() %></p>
								    <p>
									   金额：￥<%=order.getFee() %>
								    </p>
							    </td>
							
							    <td>
							    	<p>
									订单金额：￥<%=order.getFee()*order.getNum() %>
								    </p>
							    </td>
								    
							    
							    <td>
								    <p>
									无备注
								    </p>
							    </td>
							
								<td>
									<a href="StateChange?orderId=<%=order.getOrderId() %>"class="btn">发货</a>
								    <button class="btn">备注</button>
								</td>
							</tr>
							
						</table>	
									
								
					
					</li>
					<%
					}
}
					%>
					
				</ul>
            </div>
