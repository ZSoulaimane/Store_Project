package Modele;

public class Categories {

	private int RefCat;
	private String Cat;
	
	public Categories(int refCat, String cat) {
		// TODO Auto-generated constructor stub
		this.RefCat = refCat;
		this.Cat = cat;
	}
	public int getRefCat() {
		return RefCat;
	}
	public void setRefCat(int refCat) {
		RefCat = refCat;
	}
	public String getCat() {
		return Cat;
	}
	public void setCat(String cat) {
		Cat = cat;
	}
	
}
