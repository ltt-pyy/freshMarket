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
import fresh.vo.Product;

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/jsp/FreshInfoServlet")
public class BookInfoServlet extends HttpServlet {
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
		String userId=request.getParameter("userId");
		String freshId = request.getParameter("freshId") ;
		Integer counts=Integer.parseInt(request.getParameter("counts")); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss:SSS");
		String orderId = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+userId;
		String time=sdf2.format(new java.sql.Date(new java.util.Date().getTime()));
		Product fresh=new Product();
		try {
			 fresh=DAOFactory.getIProductDAOInstance().findById(freshId);
			 path ="buy.jsp";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order ord=new Order();
		ord.setOrderId(orderId);
		ord.setfreshId(freshId);
		ord.setOrderState("Î´¸¶¿î");
		ord.setuserId(userId);
		ord.setAddno("Î´ÌîÐ´");
		ord.setNum(counts);
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
		this.doGet(request, response);
	}

}
