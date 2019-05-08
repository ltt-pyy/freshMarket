package fresh.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.DAOFactory;
import fresh.vo.Order;
import fresh.vo.Fresh;
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
		Order ord=new Order();
		Fresh fresh=new Fresh();
		try{
		ord=DAOFactory.getIOrderDAOInstance().findById(orderId);
		fresh=DAOFactory.getIFreshDAOInstance().findById(ord.getFreshId());
		}catch(Exception e){
			
		}
		Integer countFee=ord.getNum()*ord.getFee();
		request.setAttribute("freshId", fresh.getFreshId());
		request.setAttribute("typeId", fresh.getTypeId());
		request.setAttribute("name", fresh.getName());
		request.setAttribute("image", fresh.getImage());
		request.setAttribute("production", fresh.getProduction());
		request.setAttribute("introduct", fresh.getIntroduct());
		request.setAttribute("price", fresh.getPrice());
		request.setAttribute("new_price", fresh.getNew_price());
		request.setAttribute("production_date", fresh.getProduction_date());
		request.setAttribute("expiration_day", fresh.getExpiration_day());
		request.setAttribute("num", fresh.getNum());
		request.setAttribute("orderId", ord.getOrderId());
		
		request.setAttribute("orderState", ord.getOrderState());
		request.setAttribute("chooseNum", ord.getNum());
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
