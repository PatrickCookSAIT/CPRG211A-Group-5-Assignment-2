package sait.mms.problemdomain;

public class Vehicle {
	
	//attributes
	private String CarID;
	
	private String VehicleType;
	private String SubType;
	private int Speed;
	private double Fuel;
	private int Seats;
	
	private int Year;
	
	private String Drivetrain;
	//adjust to be .00
	private double Price;
	private int Quantity;
	
	//getters and setters
	
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getCarID() {
		return CarID;
	}
	public void setCarID(String carID) {
		CarID = carID;
	}
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}
	public String getSubType() {
		return SubType;
	}
	public void setSubType(String subType) {
		VehicleType = subType;
	}
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public double getFuel() {
		return Fuel;
	}
	public void setFuel(double fuel) {
		Fuel = fuel;
	}
	public int getSeats() {
		return Seats;
	}
	public void setSeats(int seats) {
		Seats = seats;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getDrivetrain() {
		return Drivetrain;
	}
	public void setDrivetrain(String drivetrain) {
		Drivetrain = drivetrain;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	
	//method for reducing quantity
	public void vehicleSale() {
		if (Quantity > 1) {
			Quantity = Quantity - 1;
		}
		else {
			System.out.println("This vehicle is not currently in stock.");
		}
	}
	
}
