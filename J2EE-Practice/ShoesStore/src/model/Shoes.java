package model;


public class Shoes {
	private int id;
    private String name;
    private String brand;
    private float price;
 
    public Shoes() {
    }
 
    public Shoes(int id) {
        this.id = id;
    }
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Shoes(String name, String brand, float price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    
    public Shoes(int id, String name, String brand, float price) {
        this(name, brand, price);
        this.id = id;
    }
}
