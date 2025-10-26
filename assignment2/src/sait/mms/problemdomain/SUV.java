package sait.mms.problemdomain;
 
public class SUV extends Vehicle{
	
	
	
	
	//constructor
	
	//CarID;VehicleType;Subtype;Speed;Fuel;Seats;Year;Drivetrain;Price;Quantity
	public SUV(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, int Price, int Quantity) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		setQuantity(Quantity);
		
		
		
	}
	//toString
	@Override
	public String toString() {
		return "Car ID: " + getCarID() + "\nVehicle type: " + getVehicleType() + "\nSub type: " + getSubType() + "\nSpeed: " + getSpeed()+ "km/h\nFuel: " + getFuel() + 
				"L\nNumber of Seats: " + getSeats() + "\nYear: " + getYear() + "\nDriveTrain: " + getDrivetrain() + "\nPrice: $" + getPrice() + 
				"\nAvailable: " + getQuantity() + "\nDriveTrain: " + getDrivetrain();
	}
	
	
}

