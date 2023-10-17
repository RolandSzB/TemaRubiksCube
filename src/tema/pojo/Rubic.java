package tema.pojo;

import java.sql.Date;

public class Rubic {

	private int id;
	private String brand;
	private double weight;
	private int sides;
	private Date manufactured;
	
	public Rubic() {
	}

	public Rubic(int id, String brand, double weight, int sides, Date manufactured) {
		this.id = id;
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
		this.manufactured = manufactured;
	}

	public Rubic(String brand, double weight, int sides, Date manufactured) {
		this.brand = brand;
		this.weight = weight;
		this.sides = sides;
		this.manufactured = manufactured;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public Date getManufactured() {
		return manufactured;
	}

	public void setManufactured(Date manufactured) {
		this.manufactured = manufactured;
	}
	
	
	
}
