package fresh.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.DAOFactory;
import fresh.vo.User;
import fresh.vo.Order;

/**
 * Servlet implementation class PayPasswordServlet
 */
@WebServlet("/jsp/PayPasswordServlet")
public class PayPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //×ªÂë
		PrintWriter out=response.getWriter();
		String userId=request.getParameter("userId");
		String paypassword=request.getParameter("paypassword");
		String orderId=request.getParameter("orderId");
		String addId=request.getParameter("addId");
		User user=new User();
		user.setUserId(userId);
		user.setPaypassword(paypassword);
		
		Order order=new Order();
		order.setOrderState("´ý·¢»õ");
		order.setOrderId(orderId);
		order.setAddId(addId);
		try{
			user=DAOFactory.getIUserDAOInstance().findById(userId);
			order=DAOFactory.getIOrderDAOInstance().findById(orderId);
			int money =user.getMoney();
			int ordermoney=order.getFee()*order.getNum();
		
				if(DAOFactory.getIUserDAOInstance().findPaypass(user)&&DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					//if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					money=user.getMoney()-order.getFee()*order.getNum();
					
					user.setMoney(money);
					
					if(DAOFactory.getIUserDAOInstance().doUpdate(user)){
						response.setHeader("refresh","0;URL=pay_success.jsp?orderId="+orderId);
					}
					
					
			     }
				else{
					out.println("<script>");
					out.println("alert('Ö§¸¶Ê§°Ü£¬Ö§¸¶ÃÜÂë´íÎó£¡');");
					out.println("history.back();");
					out.println("</script>");
				}
			
			//	}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
