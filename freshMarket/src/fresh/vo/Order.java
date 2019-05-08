package fresh.vo;

import java.io.Serializable;

public class Order implements Serializable {
	private String orderId ;
	private String freshId ;
	private String addId ;
	private String userId ;
	private String orderState ;
	private Integer fee;
	private Integer num;
	private String time;
	public String getorderId() {
		return orderId;
	}
	public void setorderId(String orderId) {
		this.orderId = orderId;
	}
	public String getfreshId () {
		return freshId ;
	}
	public void setfreshId (String freshId ) {
		this.freshId  = freshId ;
	}
	public String getaddId() {
		return addId;
	}
	public void setaddId(String addId) {
		this.addId = addId;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public  Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee= fee;
	}
	public  Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num= num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
