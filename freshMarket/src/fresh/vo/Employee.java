package fresh.vo;
import java.util.Date ;
public class Employee {
	private int empId ;
	private String empname ;
	private float wages ;
	private Date hiredate ;
	private float sal_sum ;
	public void setempId(int empId){
		this.empId = empId ;
	}
	public void setempname(String empname){
		this.empname = empname ;
	}
	public void setwages(float wages){
		this.wages = wages ;
	}
	public void setHiredate(Date hiredate){
		this.hiredate = hiredate ;
	}
	public void setsal_sum(float sal_sum){
		this.sal_sum = sal_sum ;
	}
	public int getempId(){
		return this.empId ;
	}
	public String getempname(){
		return this.empname ;
	}
	public float getwages(){
		return this.wages ;
	}
	public Date getHiredate(){
		return this.hiredate ;
	}
	public float getsal_sum(){
		return this.sal_sum ;
	}
}
