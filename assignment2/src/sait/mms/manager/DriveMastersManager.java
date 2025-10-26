//Patrick Cook & Jace Borden 10/26/2025
//main class that runs all methods
package sait.mms.manager;

import java.io.*;
import java.util.*;

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
		
		//constructor to run program
		public DriveMastersManager() {
			loadVehicleList();
			menu();
			
		}
		
		private void loadVehicleList()
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
					//test
					
					//sedan
					if (lineData[0].startsWith("1") ) {
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;TrunkSize 10
						Sedan newSedan = new Sedan(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Integer.parseInt(lineData[8]), Integer.parseInt(lineData[9]), lineData[10]);
						vehicles.add(newSedan);
						
					}
					//hatchback
					else if (lineData[0].startsWith("2")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;HatchType 10
						Hatchback newHatchback = new Hatchback(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Integer.parseInt(lineData[8]), Integer.parseInt(lineData[9]), lineData[10]);
						vehicles.add(newHatchback);
					}
					//suv
					else if (lineData[0].startsWith("3")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9
						SUV newSUV = new SUV(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Integer.parseInt(lineData[8]), Integer.parseInt(lineData[9]));
						vehicles.add(newSUV);
					}
					//hybrid
					else if (lineData[0].startsWith("4") || lineData[0].startsWith("5")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;Powertrain 10; ElectricRange 11
						Hybrid newHybrid = new Hybrid(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Integer.parseInt(lineData[8]), Integer.parseInt(lineData[9]), lineData[10], Integer.parseInt(lineData[11]));
						vehicles.add(newHybrid);
					}
					//pickup
					else if (lineData[0].startsWith("6")){
						
						//CarID 0;VehicleType 1;Subtype 2;Speed 3;Fuel 4;Seats 5;Year 6;Drivetrain 7;Price 8;Quantity 9;CargoBed 10; CargoCapacity 11
						PickupTruck newPickupTruck = new PickupTruck(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], 
								Integer.parseInt(lineData[8]), Integer.parseInt(lineData[9]), lineData[10], Integer.parseInt(lineData[11]));
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
			//takes items in vehicles array list and saves it back to the .txt file
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
		//asks user for input. Finds input in list then reduces the quantity by one if applicable. Error message if not.
		private void purchaseVehicle() {
			boolean searchSuccess = false;
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter CarID: ");
			String userInput = myObj.nextLine();
			
			for(Vehicle currentVehicle : vehicles) {
				
				if(currentVehicle.getCarID().equals(userInput)) {
					searchSuccess = true;
					if (currentVehicle.vehicleSale()) {
						System.out.println("\nThe Vehicle " + currentVehicle.getVehicleType() + " " + currentVehicle.getSubType() + " has been checked out.\n");
					}
					else {
						System.out.println("\nThe Vehicle " + currentVehicle.getVehicleType() + " " + currentVehicle.getSubType() + " has no remaining inventory. No purchase made\n");
					}
				}
			}
			if (searchSuccess == false) {
				System.out.println("No vehicle with ID " + userInput);
			}
			menu();
		}

		//searchs all vehicles by the selected type
		private void displayByType() {
			boolean searchSuccess = false;
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter Vehicle Type (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) : ");
			String userInput = myObj.nextLine();
			
			System.out.println("Matching vehicles:");
			for(Vehicle currentVehicle : vehicles) {
				if(currentVehicle.getVehicleType().toLowerCase().equals(userInput.toLowerCase()) ) {
					searchSuccess = true;
					selectToString(currentVehicle);
					System.out.println();
				}
			}
			if (searchSuccess == false) {
				System.out.println("No vehicle with Vehice Type " + userInput);
			}
			menu();
		}

		// first user selects vehicle type then further selects the unique subtype of each vehicle subclass. Prints list for all in subclass
		private void displayBySubtype() {
			boolean searchSuccess = false;
			Scanner myObj = new Scanner(System.in);
			System.out.println("#     Subtype:");
			System.out.println("1.    Sedan");
			System.out.println("2.    Hatchback");
			System.out.println("3.    SUV");
			System.out.println("4.    Hybrid");
			System.out.println("5.    Pickup Truck\n");
			System.out.println("Enter type of vehicle:");
			String userInput = myObj.nextLine();
			String subtype;
			switch (userInput) 
			{
			case "1":
				System.out.println("Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): ");
				subtype = myObj.nextLine();
				System.out.println("Matching vehicles:");
				for(Vehicle currentVehicle : vehicles) {
					if(currentVehicle instanceof Sedan) {
						if(((Sedan) currentVehicle).getTrunkSize().equals(subtype.toUpperCase())) {
							searchSuccess = true;
							selectToString(currentVehicle);
							System.out.println();
						}
					}
				}
				break;
			case "2":
				System.out.println("Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): ");
				subtype = myObj.nextLine();
				System.out.println("Matching vehicles:");
				for(Vehicle currentVehicle : vehicles) {
					if(currentVehicle instanceof Hatchback) {
						if(((Hatchback) currentVehicle).getHatchType().equals(subtype.toUpperCase())) {
							searchSuccess = true;
							selectToString(currentVehicle);
							System.out.println();
						}
					}
				}
				break;
			case "3":
				System.out.println("Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): ");
				subtype = myObj.nextLine();
				System.out.println("Matching vehicles:");
				for(Vehicle currentVehicle : vehicles) {
					if(currentVehicle instanceof SUV) {
						if(currentVehicle.getDrivetrain().equals(subtype.toUpperCase()) ) {
							searchSuccess = true;
							selectToString(currentVehicle);
							System.out.println();
						}
					}
				}
				break;
			case "4":
				System.out.println("Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): ");
				subtype = myObj.nextLine();
				System.out.println("Matching vehicles:");
				for(Vehicle currentVehicle : vehicles) {
					if(currentVehicle instanceof Hybrid) {
						if(((Hybrid) currentVehicle).getPowertrain().equals(subtype.toUpperCase())) {
							searchSuccess = true;
							selectToString(currentVehicle);
							System.out.println();
						}
					}
				}
				break;
			case "5":
				System.out.println("Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): ");
				subtype = myObj.nextLine();
				System.out.println("Matching vehicles:");
				for(Vehicle currentVehicle : vehicles) {
					if(currentVehicle instanceof PickupTruck) {
						if(((PickupTruck) currentVehicle).getCargoBed().equals(subtype.toUpperCase())) {
							searchSuccess = true;
							selectToString(currentVehicle);
							System.out.println();
						}
					}
				}
				break;
			default:
				System.out.println("Invalid input. Returning to menu.\n");
				menu();
				break;
			}
			
			
			
			
			if (searchSuccess == false) {
				System.out.println("No vehicle with Vehice Subtype " + userInput);
			}
			menu();
		}

		// user selects number of vehicles to include in random list. Random list prints vehicle details
		private void randomVehicleList() {
			//gets user to input number of movies they want in a list. selects movies from master list randomly
			Scanner userInput = new Scanner(System.in);
			System.out.println("\nEnter number of vehicles: ");
			int numberOfVehicles = Integer.parseInt(userInput.nextLine());
			ArrayList<Vehicle> randomVehicleList = vehicles;
			System.out.println("\nRandom Vehicles:");
			for(int count = 0; count < numberOfVehicles; count++)
			{
				Random rand = new Random();
				int randomIndex = rand.nextInt(randomVehicleList.size());
				Vehicle currentVehicle = randomVehicleList.get(randomIndex);
				randomVehicleList.remove(randomIndex);
				selectToString(currentVehicle);
				System.out.println();
				
				
			}
			menu();
		}

		//main menu. user inputs selection and the program is directed to proper method
		private void menu() {
			System.out.println("Welcome to DriveMasters");
			System.out.println("===============================");
			System.out.println("Select one of the following:\n");
			
			Scanner myObj = new Scanner(System.in);
			System.out.println("1.    Purchase Vehicle");
			System.out.println("2.    Display Vehicles by Type");
			System.out.println("3.    Display Vehicles by Subtype");
			System.out.println("4.    Produce a Random List of Vehicles");
			System.out.println("5.    Save & Exit\n\n");
			System.out.println("Enter option:");
			String userInput = myObj.nextLine();
			
			
			switch (userInput) 
			{
			case "1":
				purchaseVehicle();
				break;
			case "2":
				displayByType();
				break;
			case "3":
				displayBySubtype();
				break;
			case "4":
				randomVehicleList();
				break;
			case "5":
				saveVehicleList();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input. Please try again.\n");
				menu();
				break;
			}
			
		}

		//to ensure that the toString of the subclass is selected. Used to generate lists.
		private void selectToString(Vehicle currentVehicle) {
			
			if (currentVehicle instanceof Sedan) {
				System.out.println(((Sedan) currentVehicle).toString());
			}
			if (currentVehicle instanceof Hatchback) {
				System.out.println(((Hatchback) currentVehicle).toString());
			}
			if (currentVehicle instanceof SUV) {
				System.out.println(((SUV) currentVehicle).toString());
			}
			if (currentVehicle instanceof Hybrid) {
				System.out.println(((Hybrid) currentVehicle).toString());
			}
			if (currentVehicle instanceof PickupTruck) {
				System.out.println(((PickupTruck) currentVehicle).toString());
			}
		}
		
		
		
}

