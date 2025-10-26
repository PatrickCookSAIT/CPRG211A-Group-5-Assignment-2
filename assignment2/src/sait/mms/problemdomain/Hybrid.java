package sait.mms.problemdomain;
 
public class Hybrid extends Vehicle{
	
	private String Powertrain;
	private int ElectricRange;
	
	public int getElectricRange() {
		return ElectricRange;
	}

	public void setElectricRange(int electricRange) {
		ElectricRange = electricRange;
	}

	//getters and setters
	public String getPowertrain() {
		return Powertrain;
	}
 
	public void setPowertrain(String powertrain) {
		Powertrain = powertrain;
	}
	//constructor
	
	//CarID;VehicleType;Subtype;Speed;Fuel;Seats;Year;Drivetrain;Price;Quantity;PowerTrain ElectricRange;
	public Hybrid(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, int Price, int Quantity, String Powertrain, int ElectricRange) {
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
		setQuantity(Quantity);
		
		this.Powertrain = Powertrain;
		this.ElectricRange = ElectricRange;
		
	}
	
	//converts Powertrain of E, A, PHEV to a full description
			public String powertrainDetailed() {
				String powertrainMessage = null; 
				if (Powertrain == "E") {
					powertrainMessage = "Series Hybrid";
					
				}
				if (Powertrain == "A") {
					powertrainMessage = "Parallel Hybrid";
					
				}
				if (Powertrain == "PHEV") {
					powertrainMessage = "Plug-in Hybrid";
					
				}
				return powertrainMessage;
			}
	//toString
	@Override
	public String toString() {
		return "Car ID: " + getCarID() + "\nVehicle type: " + getVehicleType() + "\nSub type: " + getSubType() + "\nSpeed: " + getSpeed()+ "km/h\nFuel: " + getFuel() + 
				"L\nNumber of Seats: " + getSeats() + "\nYear: " + getYear() + "\nDriveTrain: " + getDrivetrain() + "\nPrice: $" + getPrice() + 
				"\nAvailable: " + getQuantity() + "\nPower Train: " + powertrainDetailed() + "\nElectric Range: " + ElectricRange;
	}
	
	
}

