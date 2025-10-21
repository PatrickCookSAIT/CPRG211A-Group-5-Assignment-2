package sait.mms.problemdomain;
 
public class Hatchback extends Vehicle{
	
	private String HatchType;
	
	//getters and setters
	public String getHatchType() {
		return HatchType;
	}
 
	public void setHatchType(String hatchType) {
		HatchType = hatchType;
	}
	//constructor
	public void Hatchback(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, double Price, String HatchType) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		this.HatchType = HatchType;
		
		
	}
	//toString. needs to be edited
	@Override
	public String toString() {
		return "Hatchback [HatchType=" + HatchType + "]";
	}
	
	
}