package sait.mms.problemdomain;
 
public class PickupTruck extends Vehicle{
	
	private String PickupTruckType;
	private int CargoCapacity;
	
	//getters and setters
	
	public int getCargoCapacity() {
		return CargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		CargoCapacity = cargoCapacity;
	}
	public String getPickupTruckType() {
		return PickupTruckType;
	}
 
	public void setPickupTruckType(String pickupTruckType) {
		PickupTruckType = pickupTruckType;
	}
	//constructor
	public void PickupTruck(String CarID, String VehicleType, String SubType, int Speed, double Fuel, int Seats, int Year, int CargoCapacity, String Drivetrain, double Price, String PickupTruckType) {
		setCarID(CarID);
		setVehicleType(VehicleType);
		setSubType(SubType);
		setSpeed(Speed);
		setFuel(Fuel);
		setSeats(Seats);
		setYear(Year);
		setCargoCapacity(CargoCapacity);
		setDrivetrain(Drivetrain);
		setPrice(Price);
		this.PickupTruckType = PickupTruckType;
		
		
	}
	//toString. needs to be edited
	@Override
	public String toString() {
		return "PickupTruck [PickupTruckType=" + PickupTruckType + "]";
	}
	
	
}