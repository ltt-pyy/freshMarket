package fresh.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.cosnaming.IiopUrl.Address;

import fresh.factory.* ;
import fresh.vo.Order;
import fresh.vo.AddressInfo;
import fresh.vo.Fresh;

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/jsp/FreshInfoServlet")
public class FreshInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public FreshInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path ="buy.jsp";
		request.setCharacterEncoding("utf-8");
		String userId=request.getParameter("id");
		String freshId = request.getParameter("freshId") ;
		Integer chooseNum=Integer.parseInt(request.getParameter("chooseNum")); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss:SSS");
		String orderId = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+userId;
		String time=sdf2.format(new java.sql.Date(new java.util.Date().getTime()));
		Fresh fresh=new Fresh();
		try {
			 fresh=DAOFactory.getIFreshDAOInstance().findById(freshId);
			 path ="buy.jsp";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order ord=new Order();
		ord.setOrderId(orderId);
		ord.setFreshId(freshId);
		ord.setOrderState("Î´¸¶¿î");
		ord.setUserId(userId);
		ord.setAddId("Î´ÌîÐ´");
		ord.setNum(chooseNum);
		ord.setFee(fresh.getNew_price()!=0?fresh.getNew_price():fresh.getPrice());
		ord.setTime(time);
		
		try{
			if(DAOFactory.getIOrderDAOInstance().doCreate(ord)){
				path ="buy.jsp";
			}
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer countFee=chooseNum*ord.getFee();
		request.setAttribute("freshId", fresh.getFreshId());
		request.setAttribute("typeId", fresh.getTypeId());
		request.setAttribute("name", fresh.getName());
		request.setAttribute("Image", fresh.getImage());
		request.setAttribute("production", fresh.getProduction());
		request.setAttribute("introduct", fresh.getIntroduct());
		request.setAttribute("price", fresh.getPrice());
		request.setAttribute("new_price", fresh.getNew_price());
		request.setAttribute("expiration_day", fresh.getExpiration_day());
        request.setAttribute("production_date", fresh.getProduction_date());  
		
		
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
		this.doGet(request, response);
	}

}
