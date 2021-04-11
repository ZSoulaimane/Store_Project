package Modele;

public class Articles {
	
	private int CodeArticle;
	private String Designation;
	private int Prix;
	private int Stock;
	private int Categorie;
	private String Photo;
	
	public Articles() {
        super();
    }
	

    public Articles(int CodeArticle, String Designation, String Photo,int Prix ,int Stock, int Categorie) {
        super();
        this.CodeArticle = CodeArticle;
        this.Designation = Designation;
        this.Photo = Photo;
        this.Prix = Prix;
        this.Stock= Stock;
        this.Categorie = Categorie;
    }
	
	public int getCodeArticle() {
		return CodeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		this.CodeArticle = codeArticle;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		this.Designation = designation;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		this.Prix = prix;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}
	public int getCategorie() {
		return Categorie;
	}
	public void setCategorie(int categorie) {
		this.Categorie = categorie;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		this.Photo = Photo;
	}
	
}
