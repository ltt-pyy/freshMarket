package fresh.vo;

import java.io.Serializable;

public class Type implements Serializable {
	private String typeId;
	private String typename ;
	public String gettypeId() {
		return typeId;
	}
	public void settypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public String gettypename() {
		return typename;
	}
	public void settypename(String typename) {
		this.typename = typename;
	}
}	