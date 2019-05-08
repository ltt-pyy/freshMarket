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
 * Servlet implementation class PayResultServlet
 */
@WebServlet("/jsp/PayResultServlet")
public class PayResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ;
		String orderId=request.getParameter("orderId");
		String addId=request.getParameter("addId");
		Integer countFee=Integer.parseInt(request.getParameter("countFee"));
//		Order order=new Order();
//		order.setOrderState("´ý·¢»õ");
//		order.setOrderId(orderId);
//		order.setAddId(addId);
		String userrId=request.getParameter("userId");
		Member mem=new Member();
		
		
		try{
			mem=DAOFactory.getIMemberDAOInstance().findById(userId);
			
			int money =mem.getMoney();
			
			if(money<countFee){
				response.setHeader("refresh","1;URL=pay_erro.jsp?orderId="+orderId+"&addId="+addId);
				
			}else{
				//if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
				response.setHeader("refresh","1;URL=pay_sub.jsp?orderId="+orderId+"&countFee="+countFee+"&addId="+addId);
				
					//path="pay_success.jsp";
					
				//}
			}
			
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		//request.setAttribute("orderId", order);
		//request.getRequestDispatcher(path).forward(request,response) ;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
