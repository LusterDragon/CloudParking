package one.digitalinovation.parking.controller.dto;

public class ParkingCreateDTO {

	private String license;
	private String state;
	private String model;
	private String color;
	
	public ParkingCreateDTO() {
		
	}
	
	public ParkingCreateDTO(String license, String state, String model, String color) {
		this.color = color;
		this.license = license;
		this.model = model;
		this.state = state;
	}
	
	public String getLicense() {return license;}
	public void setLicense(String license) {this.license = license;}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
}
