package sait.mms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sait.mms.problemdomain.Hatchback;
import sait.mms.problemdomain.Hybrid;
import sait.mms.problemdomain.PickupTruck;
import sait.mms.problemdomain.SUV;
import sait.mms.problemdomain.Sedan;
import sait.mms.problemdomain.Vehicle;



public class DriveMastersManager {
	//constants
		private final static String FILE_NAME = "res/vehicles.txt";
		//attributes
		private static ArrayList<Vehicle> vehicles = new ArrayList<>();
		private static void loadVehicleList()
		{
			// loads file through file name. Reads in vehicles into the proper child class depending on the type of vehicle
			File file = new File(FILE_NAME);
			
			try {
				Scanner in = new Scanner(file);
				while (in.hasNext())
				{
					String line = in.nextLine();
					// checks if the first character of the first data point in the file to determine vehicle sub-type
					// 1 for sedan, 2 for hatchback, 3 for suv, 4 or 5 for hybrid
					
					
					
				
					String[] lineData = line.split(";");
					//sedan
					if (lineData[0].startsWith("1") ) {
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;TrunkSize 10
						Sedan newSedan = new Sedan(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]), lineData[10]);
						vehicles.add(newSedan);
					}
					//hatchback
					else if (lineData[0].startsWith("2")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;HatchType 10
						Hatchback newHatchback = new Hatchback(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]), lineData[10]);
						vehicles.add(newHatchback);
					}
					//suv
					else if (lineData[0].startsWith("3")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9
						SUV newSUV = new SUV(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]));
						vehicles.add(newSUV);
					}
					//hybrid
					else if (lineData[0].startsWith("4") || lineData[0].startsWith("5")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;Powertrain 10; ElectricRange 11
						Hybrid newHybrid = new Hybrid(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]), lineData[10], Integer.parseInt(lineData[11]));
						vehicles.add(newHybrid);
					}
					//pickup
					else if (lineData[0].startsWith("6")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;CargoBed 10; CargoCapacity 11
						PickupTruck newPickupTruck = new PickupTruck(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Double.parseDouble(lineData[8]), Integer.parseInt(lineData[9]), lineData[10], Integer.parseInt(lineData[11]));
						vehicles.add(newPickupTruck);
					}
					
					
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private void saveVehicleList()
		{
			//takes items in movie arrary list and saves it back to the .txt file
			try {
				PrintWriter out = new PrintWriter(new File(FILE_NAME));
				for(Vehicle currentVehicle : vehicles)
				{
					out.println(currentVehicle.getCarID() +";"+currentVehicle.getSubType() +";"+ currentVehicle.getSpeed() +
							currentVehicle.getFuel() +";"+currentVehicle.getSeats() +";"+ currentVehicle.getYear() +
							currentVehicle.getDrivetrain() +";"+currentVehicle.getPrice() +";"+ currentVehicle.getQuantity());
					if (currentVehicle instanceof Sedan) {
						out.print(";"+((Sedan) currentVehicle).getTrunkSize());
					}
					if (currentVehicle instanceof Hatchback) {
						out.print(";"+((Hatchback) currentVehicle).getHatchType());
					}
					if (currentVehicle instanceof Hybrid) {
						out.print(";"+((Hybrid) currentVehicle).getPowertrain()+";"+((Hybrid) currentVehicle).getElectricRange());
					}
					if (currentVehicle instanceof PickupTruck) {
						out.print(";"+((PickupTruck) currentVehicle).getCargoBed()+";"+((PickupTruck) currentVehicle).getCargoCapacity());
					}
				}
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
