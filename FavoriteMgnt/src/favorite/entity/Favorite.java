package favorite.entity;

public class Favorite {
	//
	private String id;
	private String url;
	private String description;
	private Category category;
	
	public Favorite() {
		//empty
	}
	
	public Favorite(String url, String description, Category category) {
		//
		this.url = url;
		this.description = description;
		this.category = category;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
