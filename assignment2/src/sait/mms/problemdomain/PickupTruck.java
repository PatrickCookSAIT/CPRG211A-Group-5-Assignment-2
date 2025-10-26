package sait.mms.problemdomain;
 
public class PickupTruck extends Vehicle{
	
	private String CargoBed;
	private int CargoCapacity;
	
	public int getCargoCapacity() {
		return CargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		CargoCapacity = cargoCapacity;
	}

	public void setCargoBed(String cargoBed) {
		CargoBed = cargoBed;
	}

	//getters and setters
	public String getCargoBed() {
		return CargoBed;
	}
 

	//constructor
	
	//CarID;VehicleType;Subtype;Speed;Fuel;Seats;Year;Drivetrain;Price;Quantity;CargoBeds; CargoCapacity
	public PickupTruck(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, String Drivetrain, int Price, int Quantity, String CargoBed, int CargoCapacity) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setQuantity(Quantity);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		
		this.CargoBed = CargoBed;
		this.CargoCapacity = CargoCapacity;
		
		
	}
	
	//converts CargoBed of SB, EB, DB to a full description
	public String CargoBedDetailed() {
		String cargoBedMessage = null; 
		if (CargoBed.equals("SB")) {
			cargoBedMessage = "Short Bed";
			
		}
		if (CargoBed.equals("EB")) {
			cargoBedMessage = "Extended Bed";
			
		}
		if (CargoBed.equals("DB")) {
			cargoBedMessage = "Dump Bed";
			
		}
		return cargoBedMessage;
	}
	
	//toString
	@Override
	public String toString() {
		return "Car ID: " + getCarID() + "\nVehicle type: " + getVehicleType() + "\nSub type: " + getSubType() + "\nSpeed: " + getSpeed()+ "km/h\nFuel: " + getFuel() + 
				"L\nNumber of Seats: " + getSeats() + "\nYear: " + getYear() + "\nDriveTrain: " + getDrivetrain() + "\nPrice: $" + getPrice() + 
				"\nAvailable: " + getQuantity() + "\nCargo Bed: " + CargoBedDetailed() + "\nCargo Capacity: " + CargoCapacity;
	}
	
	
}