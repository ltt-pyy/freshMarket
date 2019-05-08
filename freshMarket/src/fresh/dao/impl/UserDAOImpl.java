package fresh.dao.impl;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fresh.dao.IUserDAO;
import fresh.vo.User;
import fresh.vo.Fresh;

public class UserDAOImpl implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateLastdate(String id) throws Exception {
		String sql = "UPDATE user SET lastdate=? WHERE userId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt
				.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setString(2, id);
		this.pstmt.executeUpdate();
	}

	public boolean findLogin(User vo) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(userId) FROM user WHERE userId=? AND password=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getuserId());
		this.pstmt.setString(2, vo.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) > 0) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean doCreate(User vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO user(userId,password,email,lastdate,paypassword,money) VALUES (?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getuserId());
		this.pstmt.setString(2, vo.getPassword());
		
		this.pstmt.setString(3, vo.getEmail());
		
		this.pstmt.setDate(4, new java.sql.Date(vo.getLastdate().getTime()));
		this.pstmt.setString(5, vo.getPaypassword());
		this.pstmt.setInt(6, vo.getMoney());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		throw new Exception("此方法未实现！");
	}

	public boolean doUpdate(User vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE user SET money=? WHERE userId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, vo.getMoney());
		this.pstmt.setString(2, vo.getuserId());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<User> findAll(String keyWord) throws Exception {
		throw new Exception("此方法未实现！");
	}

	public List<User> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}

	public User findById(String id) throws Exception {
		User mem = null ;
		String sql = "SELECT userId,password,email,lastdate,paypassword,money FROM user WHERE userId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			mem = new User() ;
			mem.setuserId(rs.getString(1)) ;
			mem.setPassword(rs.getString(2)) ;
			
			mem.setEmail(rs.getString(3)) ;
			
			mem.setLastdate(rs.getDate(4)) ;
			mem.setPaypassword(rs.getString(5)) ;
			mem.setMoney(rs.getInt(6)) ;
		}
		return mem;
	}

	public long getAllCount(String keyWord) throws Exception {
		throw new Exception("此方法未实现！");
	}
	public boolean findPaypass(User vo) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(userId) FROM user WHERE userId=? AND paypassword=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getuserId());
		this.pstmt.setString(2, vo.getPaypassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) > 0) {
				flag = true;
			}
		}
		return flag;
	}
	public int PageSize() throws Exception {
		int rowCount=0;
		String sql = "select count(*) from user ";
		this.pstmt = this.conn.prepareStatement(sql);
		//this.pstmt.setString(1, id) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		 while(rs.next())  
         {  
             rowCount=rs.getInt(1);  //获取表中记录总数  
         }
		return rowCount;
	}
	public List<User>  findPage(String keyWord) throws Exception {
		List<User> all = new ArrayList<User>();
	    int pageSize=3;  //希望每页显示记录的条数  
        int pageNow=1;   //初始化当前页为第一页  
        //String keyWord=null;
        String sql = "SELECT userId,password,email,lastdate,paypassword,money FROM user "+
				" WHERE userId LIKE ? OR password LIKE ? OR email LIKE ? OR lastdate like ? OR paypassword like ? OR money like ?" ; 
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if(rs.next()){
			User mem = new User() ;
			mem.setuserId(rs.getString(1)) ;
			mem.setPassword(rs.getString(2)) ;
			
			mem.setEmail(rs.getString(3)) ;
			
			mem.setLastdate(rs.getDate(4)) ;
			mem.setPaypassword(rs.getString(5)) ;
			mem.setMoney(rs.getInt(6)) ;
			all.add(mem);
		}
		return all;
	}



	


	
	


}
