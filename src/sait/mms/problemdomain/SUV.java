package sait.mms.problemdomain;
 
public class SUV extends Vehicle{
	
	private String SUVType;
	
	//getters and setters
	public String getSUVType() {
		return SUVType;
	}
 
	public void setSUVType(String suvType) {
		SUVType = suvType;
	}
	//constructor
	public void SUV(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, double Price, String SUVType) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		this.SUVType = SUVType;
		
		
	}
	//toString. needs to be edited
	@Override
	public String toString() {
		return "SUV [SUVType=" + SUVType + "]";
	}
	
	
}