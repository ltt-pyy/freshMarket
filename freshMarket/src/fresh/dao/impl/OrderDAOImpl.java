package fresh.dao.impl;
import java.io.*;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import fresh.dao.IOrderDAO;
import fresh.vo.Order;

public class OrderDAOImpl implements IOrderDAO {
	private Connection conn;
	private PreparedStatement pstmt = null;

	public OrderDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateCount(Integer id) throws Exception {
		String sql = "UPDATE order SET count=count+1 WHERE orderId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		this.pstmt.executeUpdate();
	}

	public List<Order> findAll(Set<Integer> key) throws Exception {
		List<Order> all = new ArrayList<Order>();
		StringBuffer sql = new StringBuffer(); // 循环修改内容的时候使用StringBuffer
		sql
				.append("SELECT orderId,freshId,addId,userId,orderState,fee,num ,time FROM order WHERE orderId IN (");
		int count = 0;
		Iterator<Integer> iter = key.iterator();
		while (iter.hasNext()) {
			count++;
			sql.append(iter.next());
			if (count <= key.size() - 1) {
				sql.append(",");
			}
		}
		sql.append(")");
		this.pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Order ord = new Order();
			ord.setorderId(rs.getString(1));
			ord.setfreshId(rs.getString(2));
			ord.setaddId(rs.getString(3));
			ord.setuserId(rs.getString(4));
			ord.setOrderState(rs.getString(5));
			ord.setFee(rs.getInt(6));
			ord.setNum(rs.getInt(7));
			ord.setTime(rs.getString(8));
		}
		return all;
	}

	public boolean doCreate(Order vo) throws Exception {
		boolean flag = false;
		//PrintWriter out=response.getWriter();
	   
		String sql = "INSERT INTO order(orderId,freshId,addId,userId,orderState,fee,num,time)"
				+ " VALUES (?,?,?,?,?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getorderId());
		this.pstmt.setString(2, vo.getfreshId());
		this.pstmt.setString(3, vo.getaddId());
		this.pstmt.setString(4, vo.getuserId());
		this.pstmt.setString(5, vo.getOrderState());
		this.pstmt.setInt(6, vo.getFee());
		this.pstmt.setInt(7, vo.getNum());
		this.pstmt.setString(8, vo.getTime());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM order WHERE orderId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doUpdate(Order vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE order SET  freshId=?,addId=?,userId=?,orderState=?,fee=?,num=? ,time=? WHERE orderId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(8, vo.getorderId());
		this.pstmt.setString(1, vo.getfreshId());
		this.pstmt.setString(2, vo.getaddId());
		this.pstmt.setString(3, vo.getuserId());
		this.pstmt.setString(4, vo.getOrderState());
		this.pstmt.setInt(5, vo.getFee());
		this.pstmt.setInt(6, vo.getNum());
		this.pstmt.setString(7, vo.getTime());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}
	public boolean doUpdateSth(Order vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE order SET  orderState=?,addId=?  WHERE orderId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getOrderState());
		this.pstmt.setString(2, vo.getaddId());
		this.pstmt.setString(3, vo.getorderId());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> all = new ArrayList<Order>();
		String sql = "SELECT orderId,freshId,addId,userId,orderState,fee,num,time"
				+ " FROM order WHERE userId LIKE ? OR orderState LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Order ord = new Order();
			ord.setorderId(rs.getString(1));
			ord.setfreshId(rs.getString(2));
			ord.setaddId(rs.getString(3));
			ord.setuserId(rs.getString(4));
			ord.setOrderState(rs.getString(5));
			ord.setFee(rs.getInt(6));
			ord.setNum(rs.getInt(7));
			ord.setTime(rs.getString(8));
			all.add(ord);
		}
		return all;
	}



	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		String sql = "SELECT COUNT(orderId) FROM order "
				+ "  WHERE orderState LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) { // 取得全部的记录数
			count = rs.getInt(1);
		}
		return count;
	}
	public List<Order> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}
	public Order findById(String id) throws Exception {
		Order ord = null;
		String sql = "SELECT orderId,freshId,addId,userId,orderState,fee,num,time  FROM order WHERE orderId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ord = new Order();
			ord.setorderId(rs.getString(1));
			ord.setfreshId(rs.getString(2));
			ord.setaddId(rs.getString(3));
			ord.setuserId(rs.getString(4));
			ord.setOrderState(rs.getString(5));
			ord.setFee(rs.getInt(6));
			ord.setNum(rs.getInt(7));
			ord.setTime(rs.getString(8));
		}
		return ord ;
	}
	

}
