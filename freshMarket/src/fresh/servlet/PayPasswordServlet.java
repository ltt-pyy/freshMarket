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
import fresh.vo.Member;
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
		Member mem=new Member();
		mem.setUserId(userId);
		mem.setPaypassword(paypassword);
		
		Order order=new Order();
		order.setOrderState("´ý·¢»õ");
		order.setOrderId(orderId);
		order.setAddId(addId);
		try{
			mem=DAOFactory.getIMemberDAOInstance().findById(userId);
			order=DAOFactory.getIOrderDAOInstance().findById(orderId);
			int money =mem.getMoney();
			int ordermoney=order.getFee()*order.getNum();
		
				if(DAOFactory.getIMemberDAOInstance().findPaypass(mem)&&DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					//if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					money=mem.getMoney()-order.getFee()*order.getNum();
					
					mem.setMoney(money);
					
					if(DAOFactory.getIMemberDAOInstance().doUpdate(mem)){
						response.setHeader("refresh","0;URL=pay_success.jsp?orderno="+orderId);
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
