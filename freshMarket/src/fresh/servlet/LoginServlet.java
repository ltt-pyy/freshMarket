package fresh.servlet;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.* ;

import fresh.factory.* ;
import fresh.vo.* ;
/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/jsp/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8") ; 
		resp.setContentType("text/html; charset=UTF-8"); //×ªÂë
		PrintWriter out=resp.getWriter();
		String path = "index.jsp" ;
		String userId = req.getParameter("userId") ;
		String password= req.getParameter("password") ;
			Member member = new Member() ;
			member.setUserId(userId);
			member.setPassword(password) ;	
				try {
					if(DAOFactory.getIMemberDAOInstance().findLogin(member)){
						req.getSession().setAttribute("id", userId) ;
						resp.setHeader("refresh","0;URL=index.jsp" );				
					} else {
						out.println("<script>");
						out.println("alert('µÇÂ¼Ê§°Ü£¬ÓÃ»§Ãû»òÃÜÂë´íÎó£¡');");
						out.println("</script>");
						resp.setHeader("refresh","0;URL=index.jsp" );
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
	}
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet( req,resp) ;
	}

}
