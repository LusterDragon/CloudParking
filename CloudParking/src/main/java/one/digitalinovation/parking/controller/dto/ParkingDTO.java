package one.digitalinovation.parking.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

	private String id;
	private String license;
	private String state;
	private String model;
	private String color;
	@JsonFormat(pattern= "dd/MM/yyyy HH:mm")
	private LocalDateTime entryTime;
	@JsonFormat(pattern= "dd/MM/yyyy HH:mm")
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
