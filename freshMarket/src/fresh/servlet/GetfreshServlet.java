package fresh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.DAOFactory;
import fresh.vo.Order;

/**
 * Servlet implementation class StateChange
 */
@WebServlet("/jsp/GetfreshServlet")
public class GetfreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public GetfreshServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //转码
		PrintWriter out=response.getWriter();
		String orderState="已收货";
		String orderId=request.getParameter("orderId");
		Order order=new Order();
		order.setOrderState(orderState);
		order.setOrderId(orderId);
	
		try{
			String addId=DAOFactory.getIOrderDAOInstance().findById(orderId).getAddId();
			order.setAddId(addId);
			if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
				response.setHeader("refresh","0;URL=myOrder.jsp" );
				
			}
			
		}catch(Exception e){
			
		}
	}
	
}
