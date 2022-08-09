package one.digitalinovation.parking.model;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Parking {

	public Parking() {}
	public Parking(Object id,String license, String state, String model, String color  ) {
	this.id = (String) id;
	this.license = license;
	this.state= state;
	this.model = model;
	this.color = color;
	}
	
	@Id
	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime entryTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime exitTime;
	private double bill;
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getLicense() {return license;}
	public void setLicense(String license) {this.license = license;}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
	public LocalDateTime getEntryTime() {return entryTime;}
	public void setEntryTime(LocalDateTime entryTime) {this.entryTime = entryTime;}
	public LocalDateTime getExitTime() {return exitTime;}
	public void setExitTime(LocalDateTime exitTime) {this.exitTime = exitTime;}
	public double getBill() {return bill;}
	public void setBill(double bill) {this.bill = bill;}
	
	
	
}
