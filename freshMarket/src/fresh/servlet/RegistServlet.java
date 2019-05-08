package fresh.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fresh.factory.* ;
import fresh.vo.* ;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/jsp/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User() ;
		String re_userId=request.getParameter("uaserId");
	    String re_pass=request.getParameter("password");
	    String re_email=request.getParameter("email");
		user.setUserId(re_UserId) ;
		user.setPassword(re_pass) ;
		user.setEmail(re_email) ;
		user.setPaypassword(re_pass);
		user.setLastdate(new java.util.Date()) ;
		user.setMoney(200);
		try{
			if(DAOFactory.getIUserDAOInstance().doCreate(user)){	// 注册成功
				response.setHeader("refresh","2;URL=index.jsp") ;
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>恭喜"+user.getUser()+"用户注册成功，两秒后将跳转到首页进行登陆操作！</h3>");
				out.println("<h3>如果没有跳转，请按 <a href='index.jsp'>这里</a>！</h3>");
				out.println("</body>");
				out.println("</html>");
				out.close();
		   }else if(re_userId==null){
			   response.setContentType("text/html;charset=utf-8");
		   }else{
			   response.setHeader("refresh","2;URL=index.jsp") ;
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
			
				out.println("<script>");
				out.println("alert('用户注册失败，此注册ID已经被人使用了！');");
				out.println("</script>");
				out.close();
		   }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request,response) ;
	}

}
