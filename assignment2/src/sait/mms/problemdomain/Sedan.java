package sait.mms.problemdomain;
 
public class Sedan extends Vehicle{
	
	private String TrunkSize;
	
	//getters and setters
	public String getTrunkSize() {
		return TrunkSize;
	}
 
	public void setTrunkSize(String trunkSize) {
		TrunkSize = trunkSize;
	}
	//constructor
	
	//CarID;VehicleType;Subtype;Speed;Fuel;Seats;Year;Drivetrain;Price;Quantity;TrunkSize
	public Sedan(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, int Price, int Quantity, String TrunkSize) {
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
		this.TrunkSize = TrunkSize;
		
		
	}
	//converts trunk size of L, M or S to a full description
	public String trunkSizeDetailed() {
		String trunkSizeMessage = null; 
		if (TrunkSize.equals("L")) {
			trunkSizeMessage = "Large/spacious trunk";
			
		}
		if (TrunkSize.equals("S")) {
			trunkSizeMessage = "Small";
			
		}
		if (TrunkSize.equals("M")) {
			trunkSizeMessage = "Moderate";
			
		}
		return trunkSizeMessage;
	}
	//toString
	@Override
	public String toString() {
		
		return "Car ID: " + getCarID() + "\nVehicle type: " + getVehicleType() + "\nSub type: " + getSubType() + "\nSpeed: " + getSpeed()+ "km/h\nFuel: " + getFuel() + 
				"L\nNumber of Seats: " + getSeats() + "\nYear: " + getYear() + "\nDriveTrain: " + getDrivetrain() + "\nPrice: $" + getPrice() + 
				"\nAvailable: " + getQuantity() + "\nTrunk Size: " + trunkSizeDetailed();
		 
	}
	
	
}