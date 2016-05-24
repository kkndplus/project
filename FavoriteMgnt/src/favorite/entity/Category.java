package favorite.entity;

public enum Category {
	//
	Dev("01"),
	Private("02"),
	Beauty("03"),
	Shopping("04"),
	Finance("05");
	
	private String code;
	
	private Category(String code) {
		//
		this.code = code;
	}
	
	public static Category getByCode(String code) {
		//
		for(Category category : Category.values()) {
			if(category.getCode().equals(code)) {
				return category;
			}
		}
		
		return null;
	}

	public String getCode() {
		return code;
	}
}
