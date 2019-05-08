package fresh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.DAOFactory;
import fresh.vo.Order;
import fresh.vo.Product;

/**
 * Servlet implementation class PayOrderServlet
 */
@WebServlet("/jsp/PayOrderServlet")
public class PayOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path ="buy.jsp";
		String orderId=request.getParameter("orderId");
		Order order=new Order();
		Product fresh=new Product();
		try{
		order=DAOFactory.getIOrderDAOInstance().findById(orderId);
		fresh=DAOFactory.getIProductDAOInstance().findById(order.getFreshId());
		}catch(Exception e){
			
		}
		Integer countFee=order.getNum()*order.getFee();
		request.setAttribute("freshId", fresh.getFreshId());
		request.setAttribute("typeId", fresh.gettypeId());
		request.setAttribute("name", fresh.getFreshName());
		request.setAttribute("image", fresh.getFreshImg());
		request.setAttribute("production", fresh.getProduction());
		request.setAttribute("expiration", fresh.getExpiration());
		request.setAttribute("introduct", fresh.getIntroduct());
		request.setAttribute("price", fresh.getPrice());
		request.setAttribute("new_price", fresh.getNew_price());
		request.setAttribute("production_date", fresh.getProduction_date());
		request.setAttribute("num", fresh.getNum());
		request.setAttribute("orderId", ord.getOrderId());
		request.setAttribute("orderState", ord.getOrderState());
		request.setAttribute("counts", ord.getNum());
		request.setAttribute("fee", ord.getFee());
		request.setAttribute("countFee", countFee);
		request.getRequestDispatcher(path).forward(request,response) ;

		
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
