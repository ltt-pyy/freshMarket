package fresh.dao.proxy ;
import java.util.* ;




//import java.sql.* ;

import fresh.dao.*;
import fresh.dao.impl.*;
import fresh.dbc.*;
import fresh.vo.*;

public class EmpDAOProxy implements IEmpDAO {
	private DatabaseConnection dbc = null ;
	private IEmpDAO dao = null ;
	public EmpDAOProxy() throws Exception {
		this.dbc = new DatabaseConnection() ;
		this.dao = new EmpDAOImpl(this.dbc.getConnection()) ;
	}
	public boolean doCreate(Emp emp) throws Exception{
		boolean flag = false ;
		try{
			if(this.dao.findById(emp.getEmpId()) == null){
				flag = this.dao.doCreate(emp) ;
			}
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return flag ;
	}
	public List<Emp> findAll(String keyWord) throws Exception{
		List<Emp> all = null ;
		try{
			all = this.dao.findAll(keyWord) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return all ;
	}
	public Emp findById(int empId) throws Exception{
		Emp emp = null ;
		try{
			emp = this.dao.findById(empId) ;
		}catch(Exception e){
			throw e ;
		}finally{
			this.dbc.close() ;
		}
		return emp ;
	}
}
