<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="fresh.factory.DAOFactory,fresh.vo.*"%>
<%@ page import="java.util.*" %>
<% 
	request.setCharacterEncoding("utf-8") ; 
%>

    	<div id="dropdowns" class="tab-pane">
            	<ul class="thumbnails lists">
				
<%
String keyWord3=null;
if(keyWord3==null){
	keyWord3="";
}
List<Order> all3 = DAOFactory.getIOrderDAOInstance().findAll(keyWord3) ;
Iterator<Order> iter3 = all3.iterator() ;
while(iter3.hasNext()){
	Order order = iter3.next() ;
	
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
									<p>
									订单状态：<%=order.getOrderState() %>
								    </p>
								</td>
							</tr>
							
						</table>	
									
								
					
					</li>
					<%
					}

					%>
					
				</ul>
            </div>
