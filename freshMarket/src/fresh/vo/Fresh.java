package fresh.vo;

import java.io.Serializable;

import java.util.Date;
public class Fresh implements Serializable {
	private String freshId ;
	private String typeId ;
	private String name ;
	private String production ;
	private String introduct ;
	private String image ;
	private Float expiration_day;
	private Integer price;
	private Integer new_price;
	private Date production_date;
	private Integer num;
	public String getfreshId() {
		return freshId;
	}
	public void setfreshId(String freshId) {
		this.freshId = freshId;
	}
	public String typeId() {
		return typeId;
	}
	public void settypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getproduction() {
		return production;
	}
	public void setproduction(String production) {
		this.production = production;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	public float getexpiration_day() {
		return expiration_day;
	}
	public void setexpiration_day(float expiration_day) {
		this.expiration_day = expiration_day;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price= price;
	}
	public Integer getNew_price() {
		return new_price;
	}
	public void setNew_price(Integer new_price) {
		this.new_price = new_price;
	}
	public Date production_date() {
		return production_date;
	}
	public void setproduction_date(Date production_date) {
		this.production_date = production_date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num= num;
	}
}
