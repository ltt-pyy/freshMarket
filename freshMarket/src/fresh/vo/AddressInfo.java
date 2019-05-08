package fresh.vo;

import java.io.Serializable;

public class AddressInfo implements Serializable {
	private String addId;
	private String userId ;
	private String addname ;
	private String addr;
	private String phone;
	public String getaddId() {
		return addId;
	}
	public void setAddno(String addId) {
		this.addId = addId;
	}
	
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getAddname() {
		return addname;
	}
	public void setAddname(String addname) {
		this.addname = addname;
	}
	public  String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr= addr;
	}
	public  String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone= phone;
	}
	
}

