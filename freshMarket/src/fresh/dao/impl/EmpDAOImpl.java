package fresh.dao.impl ;
import java.util.* ;


import java.sql.* ;

import fresh.dao.*;
import fresh.vo.*;

public class EmpDAOImpl implements IEmpDAO {
	private Connection conn = null ;
	private PreparedStatement pstmt = null ;
	public EmpDAOImpl(Connection conn){
		this.conn = conn ;
	}
	public boolean doCreate(Employee employee) throws Exception{
		boolean flag = false ;
		String sql = "INSERT INTO employee(empId,empname,wages,hiredate,sale_sum) VALUES (?,?,?,?,?)" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1,employee.getempId()) ;
		this.pstmt.setString(2,employee.getempname()) ;
		this.pstmt.setString(3,employee.getwages()) ;
		this.pstmt.setDate(4,new java.sql.Date(employee.getHiredate().getTime())) ;
		this.pstmt.setFloat(5,employee.getsale_sum()) ;
		if(this.pstmt.executeUpdate() > 0){
			flag = true ;
		}
		this.pstmt.close() ;
		return flag ;
	}
	public List<Employee> findAll(String keyWord) throws Exception{
		List<Employee> all = new ArrayList<Employee>() ;
		String sql = "SELECT empId,empname,wages,hiredate,sale_sum FROM employee WHERE empname LIKE ? OR wages LIKE ?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1,"%"+keyWord+"%") ;
		this.pstmt.setString(2,"%"+keyWord+"%") ;
		ResultSet rs = this.pstmt.executeQuery() ;
		Employee employee = null ;
		while(rs.next()){
			employee = new Employee() ;
			employee.setempId(rs.getInt(1)) ;
			employee.setempname(rs.getString(2)) ;
			employee.setwages(rs.getString(3)) ;
			employee.setHiredate(rs.getDate(4)) ;
			employee.setsale_sum(rs.getFloat(5)) ;
			all.add(employee) ;
		}
		this.pstmt.close() ;
		return all ;
	}
	public Employee findById(int empId) throws Exception{
		Employee employee = null ;
		String sql = "SELECT empId,empname,wages,hiredate,sale_sum FROM employee WHERE empId=?" ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1,empId) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			employee = new Employee() ;
			employee.setempId(rs.getInt(1)) ;
			employee.setempname(rs.getString(2)) ;
			employee.setwages(rs.getInt(3)) ;
			employee.setHiredate(rs.getDate(4)) ;
			employee.setsale_sum(rs.getFloat(5)) ;
		}
		this.pstmt.close() ;
		return employee ;
	}
}