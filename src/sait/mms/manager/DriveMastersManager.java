package sait.mms.manager;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
import sait.mms.problemdomain.Hatchback;
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
						
						Sedan newSedan = new Sedan(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], Double.parseDouble(lineData[8]),lineData[9]);
						vehicles.add(newSedan);
					}
					//hatchback
					else if (lineData[0].startsWith("2")){
						
						Hatchback newHatchback = new Hatchback(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], Double.parseDouble(lineData[8]),lineData[9]);
						vehicles.add(newHatchback);
					}
					//suv
					else if (lineData[0].startsWith("3")){
						
						SUV newSUV = new SUV(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], Double.parseDouble(lineData[8]));
						vehicles.add(newSUV);
					}
					//hybrid
					else if (lineData[0].startsWith("4") || lineData[0].startsWith("5")){
						
						Hybrid newHybrid = new newHybrid(lineData[0],lineData[1],lineData[2],Integer.parseInt(lineData[3]),Double.parseDouble(lineData[4]),
								Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]),lineData[7], Double.parseDouble(lineData[8]),lineData[9]);
						vehicles.add(newHatchback);
					}
					//pickup
					else if (lineData[0].startsWith("6")){
						
						PartTime newPartTime = new PartTime(lineData[0],lineData[1],lineData[2],lineData[3],Long.parseLong(lineData[4]),
								lineData[5],lineData[6],Double.parseDouble(lineData[7]), Double.parseDouble(lineData[8]));
						employees.add(newPartTime);
					}
					
					
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
 