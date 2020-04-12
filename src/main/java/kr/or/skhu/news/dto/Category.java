package kr.or.skhu.news.dto;

//CategoryDto class, category table 의 항목을 저장하는 javaBeans, toString 메서드만 override 해둠
public class Category {
	private int id;
	private String category;

	public Category() {
	};

	public Category(int id, String category) {
		this.id = id;
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}
}
