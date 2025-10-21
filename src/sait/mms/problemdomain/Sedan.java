package sait.mms.problemdomain;
 
public class Sedan extends Vehicle{
	
	private String SedanType;
	
	//getters and setters
	public String getSedanType() {
		return SedanType;
	}
 
	public void setSedanType(String sedanType) {
		SedanType = sedanType;
	}
	//constructor
	public void Sedan(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, double Price, String SedanType) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		this.SedanType = SedanType;
		
		
	}
	//toString. needs to be edited
	@Override
	public String toString() {
		return "Sedan [SedanType=" + SedanType + "]";
	}
	
	
}