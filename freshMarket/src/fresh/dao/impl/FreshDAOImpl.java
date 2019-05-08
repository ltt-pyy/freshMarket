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

import fresh.dao.IFreshDAO;
import fresh.vo.Fresh;

public class FreshDAOImpl implements IFreshDAO {
	private Connection conn;
	private PreparedStatement pstmt = null;

	public FreshDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateCount(Integer id) throws Exception {
		String sql = "UPDATE fresh SET count=count+1 WHERE freshId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		this.pstmt.executeUpdate();
	}

	public List<Fresh> findAll(Set<Integer> key) throws Exception {
		List<Fresh> all = new ArrayList<Fresh>();
		StringBuffer sql = new StringBuffer(); // 循环修改内容的时候使用StringBuffer
		sql
				.append("SELECT freshId,typeId,name,image,Freshion,introduct ,price,new_price,Freshion_date,experation_day,num FROM fresh WHERE freshId IN (");
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
			Fresh pro = new Fresh();
			pro.setfreshId(rs.getString(1));
			pro.settypeId(rs.getString(2));
			pro.setname(rs.getString(3));
			pro.setimage(rs.getString(4));
			pro.setFreshion(rs.getString(5));
			pro.setIntroduct(rs.getString( 6));
			pro.setPrice(rs.getInt(7));
			pro.setNew_price(rs.getInt(8));
			pro.setFreshion_date(rs.getDate(9));
			pro.setexperation_day(rs.getString(10));
			pro.setNum(rs.getInt(11));
			all.add(pro);
		}
		return all;
	}

	public boolean doCreate(Fresh vo) throws Exception {
		boolean flag = false;
		//PrintWriter out=response.getWriter();
	   
		String sql = "INSERT INTO fresh(freshId,typeId,name,image,author,Freshion,introduct ,price,new_price,Freshion_date,experation_day,num)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getfreshId());
		this.pstmt.setString(2, vo.gettypeId());
		this.pstmt.setString(3, vo.getname());
		this.pstmt.setString(4, vo.getimage());
		this.pstmt.setString(5 ,vo.getFreshion());
		this.pstmt.setString(6, vo.getIntroduct());
		this.pstmt.setInt(7, vo.getPrice());
		this.pstmt.setInt(8, vo.getNew_price());
		this.pstmt.setDate(9, new java.sql.Date(vo.getFreshion_date().getTime()));
		this.pstmt.setString(10, vo.getexperation_day());
		this.pstmt.setInt(11, vo.getNum());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM fresh WHERE freshId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doUpdate(Fresh vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE fresh SET typeId=?,name=?,image=?,author=?,Freshion=?,introduct=? ,price=?,new_price=?,Freshion_date=?,experation_day=?,num=? WHERE freshId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(11, vo.getfreshId());
		this.pstmt.setString(1, vo.gettypeId());
		this.pstmt.setString(2, vo.getname());
		this.pstmt.setString(3, vo.getimage());
		this.pstmt.setString(4, vo.getFreshion());
		this.pstmt.setString(5, vo.getIntroduct());
		this.pstmt.setInt(6, vo.getPrice());
		this.pstmt.setInt(7, vo.getNew_price());
		this.pstmt.setDate(8, new java.sql.Date(vo.getFreshion_date().getTime()));
		this.pstmt.setString(9, vo.getexperation_day());
		this.pstmt.setInt(10, vo.getNum());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Fresh> findAll(String keyWord) throws Exception {
		List<Fresh> all = new ArrayList<Fresh>();
		String sql = "SELECT freshId,typeId,name,image,author,Freshion,introduct ,price,new_price,Freshion_date,experation_day,num"
				+ " FROM fresh WHERE typeId LIKE ? OR name LIKE ? OR author LIKE ? OR Freshion LIKE ? OR price LIKE ? OR Freshion_date LIKE ? order by freshId desc";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Fresh pro = new Fresh();
			pro.setfreshId(rs.getString(1));
			pro.settypeId(rs.getString(2));
			pro.setname(rs.getString(3));
			pro.setimage(rs.getString(4));
			pro.setFreshion(rs.getString(5));
			pro.setIntroduct(rs.getString(6));
			pro.setPrice(rs.getInt(7));
			pro.setNew_price(rs.getInt(8));
			pro.setFreshion_date(rs.getDate(9));
			pro.setexperation_day(rs.getString(10));
			pro.setNum(rs.getInt(11));
			all.add(pro);
		}
		return all;
	}



	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		String sql = "SELECT COUNT(freshId) FROM fresh ";
//				+ "  WHERE freshId LIKE ? OR typeId LIKE ? OR name LIKE ? OR author LIKE ? OR Freshion LIKE ? OR price LIKE ? OR Freshion_date LIKE ? ";
//		this.pstmt = this.conn.prepareStatement(sql);
//		this.pstmt.setString(1, "%" + keyWord + "%");
//		this.pstmt.setString(1, "%" + keyWord + "%");
//		this.pstmt.setString(2, "%" + keyWord + "%");
//		this.pstmt.setString(3, "%" + keyWord + "%");
//		this.pstmt.setString(4, "%" + keyWord + "%");
//		this.pstmt.setString(5, "%" + keyWord + "%");
//		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) { // 取得全部的记录数
			count = rs.getInt(1);
		}
		return count;
	}
	public List<Fresh> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}
	public Fresh findById(String id) throws Exception {
		Fresh pro = null;
		String sql = "SELECT freshId,typeId,name,image,author,Freshion,introduct ,price,new_price,Freshion_date,experation_day,num FROM fresh WHERE freshId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			pro = new Fresh();
			pro.setfreshId(rs.getString(1));
			pro.settypeId(rs.getString(2));
			pro.setname(rs.getString(3));
			pro.setimage(rs.getString(4));
			pro.setFreshion(rs.getString(5));
			pro.setIntroduct(rs.getString( 6));
			pro.setPrice(rs.getInt(7));
			pro.setNew_price(rs.getInt( 8));
			pro.setFreshion_date(rs.getDate(9));
			pro.setexperation_day(rs.getString(10));
			pro.setNum(rs.getInt(11));
		}
		return pro;
	}
	public List<Fresh> findByType(String keyWord) throws Exception {
		List<Fresh> all = new ArrayList<Fresh>();
		String sql = "SELECT freshId,typeId,name,image,author,Freshion,introduct ,price,new_price,Freshion_date,experation_day,num"
				+ " FROM fresh WHERE typeId LIKE ? order by freshId desc";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord+ "%");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Fresh pro = new Fresh();
			pro.setfreshId(rs.getString(1));
			pro.settypeId(rs.getString(2));
			pro.setname(rs.getString(3));
			pro.setimage(rs.getString(4));
			pro.setFreshion(rs.getString(5));
			pro.setIntroduct(rs.getString( 6));
			pro.setPrice(rs.getInt(7));
			pro.setNew_price(rs.getInt(8));
			pro.setFreshion_date(rs.getDate( 9));
			pro.setexperation_day(rs.getString(10));
			pro.setNum(rs.getInt(11));
			all.add(pro);
		}
		return all;
	}



}
