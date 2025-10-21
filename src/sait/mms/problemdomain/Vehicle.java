package sait.mms.problemdomain;

public class Vehicle {

private String CarID;
	//enum for vehicle type?
	private String VehicleType;
	private int Speed;
	private double Fuel;
	private int Seats;
	private int Year;
	private String SubType;
	//enum as well?
	private String Drivetrain;
	//adjust to be .00
	private double Price;
	public String SubType() {
		return SubType;
	}
	public void setSubType(String subType) {
		SubType = subType;
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
}