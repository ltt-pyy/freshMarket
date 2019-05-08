package fresh.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.vo.Cart;
import book.vo.Product;
import book.factory.DAOFactory;
/**
 * Servlet implementation class AddInCartServlet
 */
@WebServlet("/jsp/AddInCartServlet")
public class AddInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //转码
		PrintWriter out=response.getWriter();
		String freshId=request.getParameter("freshId");
		String userId=request.getParameter("userId");
		Integer counts=Integer.parseInt(request.getParameter("counts"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String cartId = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+userId;
		Product fresh =new Product();
		fresh.setFreshId(freshId);
		out.println("</script>");
		try{
			fresh=DAOFactory.getIProductDAOInstance().findById(freshId);
			Integer fee=(fresh.getNew_price()>0?fresh.getNew_price():fresh.getPrice());
			Cart cart=new Cart();
			cart.setfreshId(freshId);
			cart.setCartId(cartId);
			cart.setCounts(counts);
			cart.setFee(fee);
			cart.setuserId(userId);
			
			if(DAOFactory.getICartDAOInstance().doCreate(cart)){
				 //out.println("<%=fresh.getCount()%>");
			   out.println("<script>");
			  out.println("alert('成功添加商品入购物车！');");
			  out.println("history.back();");
			  
			  out.println("</script>");
				  
				//response.setHeader("refresh","0;URL=fresh-info.jsp" );
			}
		}catch(Exception e){
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
