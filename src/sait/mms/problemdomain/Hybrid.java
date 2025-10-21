package sait.mms.problemdomain;
 
public class Hybrid extends Vehicle{
	
	private String HybridType;
	private int ElectricRange;
	
	public int getElectricRange() {
		return ElectricRange;
	}

	public void setElectricRange(int electricRange) {
		ElectricRange = electricRange;
	}

	//getters and setters
	public String getHybridType() {
		return HybridType;
	}
 
	public void setHybridType(String hybridType) {
		HybridType = hybridType;
	}
	//constructor
	public void Hybrid(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, int ElectricRange, String Drivetrain, double Price, String HybridType) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setElectricRange(ElectricRange);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		this.HybridType = HybridType;
		
		
	}
	//toString. needs to be edited
	@Override
	public String toString() {
		return "Hybrid [HybridType=" + HybridType + "]";
	}
	
	
}