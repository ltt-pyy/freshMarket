package fresh.dao ;
import java.util.* ;


import fresh.vo.Employee;

public interface IEmployeeDAO {
	public boolean doCreate(Employee employee) throws Exception ;
	public List<Employee> findAll(String keyWord) throws Exception ;
	public Employee findById(int Employeeno) throws Exception ;
}