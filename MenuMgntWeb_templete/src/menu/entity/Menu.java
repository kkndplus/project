package menu.entity;

public class Menu {
	//
	private String id;
	private String code;
	private String name;
	private String url;
	private int displaySeq;
	
	public Menu() {
		//empty
	}
	
	public Menu(String code, String name) {
		//
		this.code = code;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDisplaySeq() {
		return displaySeq;
	}
	public void setDisplaySeq(int displaySeq) {
		this.displaySeq = displaySeq;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
