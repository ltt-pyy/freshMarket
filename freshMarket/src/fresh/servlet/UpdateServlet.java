package fresh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import fresh.factory.DAOFactory;
import fresh.util.IPTimeStamp;
import fresh.vo.User;
import fresh.vo.Fresh;
/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/jsp/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//request.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=UTF-8"); //转码
		request.setCharacterEncoding("utf-8") ;
		PrintWriter out=response.getWriter();
		
		try{
		String freshId = request.getParameter("fresh_id");
		String typeId=request.getParameter("fresh_type");
		String name=request.getParameter("fresh_name");
		String image=request.getParameter("fresh_img");
		String production=request.getParameter("fresh_production");
		
		String expiration_day=smart.getRequest().getParameter("fresh_expirationday");
		
		String introduct=request.getParameter("fresh_introduct");
		
		Integer price=Integer.parseInt(request.getParameter("fresh_price"));
		Integer new_price=Integer.parseInt(request.getParameter("fresh_newprice"));
		
	     
		Date production_date = new java.sql.Date(new java.util.Date().getTime());
		Integer num=Integer.parseInt(request.getParameter("fresh_num"));
		
		
			Fresh fresh = new Fresh() ;
			
			fresh.setFreshId(freshId);
			fresh.setTypeId(typeId) ;
			fresh.setImage(image);
			fresh.setName(name);
			fresh.setIntroduct(introduct);
			fresh.setProduction(production);
			fresh.setProduction_date(production_date);
			fresh.setPrice(price);
			fresh.setNew_price(new_price);
			fresh.setExpiration_day(expiration_day);
			fresh.setNum(num);
			
				
					if(DAOFactory.getIProductDAOInstance().doUpdate(fresh)){
						
						out.println("<script>");
						out.println("alert('修改成功！')");
						out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					
					} else {
						
						out.println("<script>");
						out.println("alert('修改失败！')");
						out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					}
		 }
		catch (SmartUploadException ex) {
		    out.print(ex.toString());
		    
		  	
		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(e.toString());
					
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
