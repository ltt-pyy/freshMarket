package fresh.vo;

import java.io.Serializable;

public class Cart implements Serializable {
	private String cartId ;
	private String freshId ;
	private String userId ;
	private Integer counts ;
	private Integer fee;
	public String getcartId() {
		return cartId;
	}
	public void setcartId(String cartId) {
		this.cartId = cartId;
	}
	public String getfreshId() {
		return freshId;
	}
	public void setfreshId(String freshId) {
		this.freshId = freshId;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public  Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee= fee;
	}
	
}


