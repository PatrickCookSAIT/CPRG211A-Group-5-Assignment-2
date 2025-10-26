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
	
	//CarID;VehicleType;Subtype;Speed;Fuel;Seats;Year;Drivetrain;Price;Quantity;HatchType
	public Hatchback(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, int Price, int Quantity, String HatchType) {
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
		
		this.HatchType = HatchType;
		
		
	}
	
	//converts hatch type of S, T and P to a full description
		public String hatchTypeDetailed() {
			String hatchTypeMessage = null; 
			if (HatchType.equals("S")) {
				hatchTypeMessage = "Standard Liftgate";
				
			}
			if (HatchType.equals("T")) {
				hatchTypeMessage = "Split Liftgate";
				
			}
			if (HatchType.equals("P")) {
				hatchTypeMessage = "Power Liftgate ";
				
			}
			return hatchTypeMessage;
		}
	//toString
	@Override
	public String toString() {
		return "Car ID: " + getCarID() + "\nVehicle type: " + getVehicleType() + "\nSub type: " + getSubType() + "\nSpeed: " + getSpeed()+ "km/h\nFuel: " + getFuel() + 
				"L\nNumber of Seats: " + getSeats() + "\nYear: " + getYear() + "\nDriveTrain: " + getDrivetrain() + "\nPrice: $" + getPrice() + 
				"\nAvailable: " + getQuantity() + "\nTrunk Size: " + hatchTypeDetailed();
	}
	
	
}