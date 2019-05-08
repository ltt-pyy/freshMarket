package fresh.servlet;
import java.io.IOException;

import java.text.*;
import java.util.Date;
import java.io.PrintWriter;

import javax.servlet.jsp.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import fresh.factory.DAOFactory;
import fresh.vo.Fresh;
import fresh.util.*;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/jsp/AddFresh")
public class AddFresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//public AddBook() {
    public AddFresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8") ; 
		response.setContentType("text/html; charset=UTF-8"); //转码
		PrintWriter out=response.getWriter();
		try{
			  JspFactory _jspxFactory = null;
		       PageContext pageContext = null;
		       _jspxFactory = JspFactory.getDefaultFactory();
		      pageContext = _jspxFactory.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);
			
			SmartUpload smart = new SmartUpload() ;
			smart.initialize(pageContext) ;	// 初始化上传操作
			
			smart.upload() ;			// 上传准备
		  
			//限制上传文件的类型，允许格式为 jpg,gif,bmp
		   smart.setAllowedFilesList("jpg,gif,bmp");
		     //禁止文件上传类型
		   smart.setDeniedFilesList("exe,bat,jsp,htm,html,");
		  //  String name = smart.getRequest().getParameter("uname") ;
			IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ;	// 取得客户端的IP地址
			String ext = smart.getFiles().getFile(0).getFileExt() ;	// 扩展名称
			String fileName = its.getIPTimeRand() + "." + ext ;
			String src1="../img/"+fileName;
			String src="\""+src1+"\"";
			
			smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"img"+java.io.File.separator + fileName,smart.SAVE_PHYSICAL) ;
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String freshId = sdf.format(new java.sql.Date(new java.util.Date().getTime()));
		String typeId=smart.getRequest().getParameter("fresh_type");
		String name=smart.getRequest().getParameter("fresh_name");
		String image=smart.getRequest().getParameter("fresh_img");
		String production=smart.getRequest().getParameter("freshfresh_production");
		String introduct=smart.getRequest().getParameter("fresh_introduct");
		String expiration_day=smart.getRequest().getParameter("fresh_expirationday");
		System.out.print(name.getBytes("utf-8"));
		Integer price=Integer.parseInt(smart.getRequest().getParameter("fresh_price"));
		
		Integer new_price=Integer.parseInt(smart.getRequest().getParameter("fresh_newprice"));
	     
		Date production_date = new java.sql.Date(new java.util.Date().getTime());
		Integer num=Integer.parseInt(smart.getRequest().getParameter("fresh_num"));
		
			Fresh fresh = new Fresh() ;
			fresh.setFreshId(freshId);
			fresh.setTypeId(typeId) ;
			fresh.setImage(src);
			fresh.setName(name);
			fresh.setIntroduct(introduct);
			fresh.setProduction(production);
			fresh.setExpiration_day(Expiration_day);
			fresh.setPrice(price);
			fresh.setNew_price(new_price);
			fresh.setProduction_date(production_date);
			fresh.setNum(num);
			
				
					if(DAOFactory.getIFreshDAOInstance().doCreate(fresh)){
						 out.println("<script>");
						    out.println("alert('添加商品成功！');");
						    out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					
					} else {
						 out.println("<script>");
						 out.println("alert('添加商品失败！');");
						  out.println("</script>");
						response.setHeader("refresh","2;URL=houtai.jsp" );
						
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
		this.doGet( request,response) ;
	}

}
