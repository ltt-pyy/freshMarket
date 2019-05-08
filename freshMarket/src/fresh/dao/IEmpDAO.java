package fresh.dao ;
import java.util.* ;


import fresh.vo.Emp;

public interface IEmpDAO {
	public boolean doCreate(Employee employee) throws Exception ;
	public List<Employee> findAll(String keyWord) throws Exception ;
	public Employee findById(int EmpId) throws Exception ;
}
