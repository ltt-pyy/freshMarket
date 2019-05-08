package fresh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.DAOFactory;
import fresh.vo.Member;
import fresh.vo.Order;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/jsp/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ;
		String path="pay.jsp";
		String orderId=request.getParameter("orderId");
		String addId=request.getParameter("addId");
		Integer countFee=Integer.parseInt(request.getParameter("countFee"));
		Integer fee=Integer.parseInt(request.getParameter("fee"));
		
		Order order=new Order();
		order.setOrderState("Î´¸¶¿î");
		order.setAddId(addId);
		order.setOrderId(orderId);		
		try{					 
			if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
				path="pay.jsp";
			}
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		request.setAttribute("fee", fee);
        request.setAttribute("countFee", countFee);
        request.setAttribute("orderId", orderId);
        request.setAttribute("addId", addId);      		
		request.getRequestDispatcher(path).forward(request,response) ;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
