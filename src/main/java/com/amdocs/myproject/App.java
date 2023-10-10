package com.amdocs.myproject;

import java.sql.SQLException;

import java.util.Scanner;

import com.amdocs.myproject.exceptions.*;
import com.amdocs.myproject.entity.Plant;
import com.amdocs.myproject.dao.*;
import com.amdocs.myproject.dao.impl.*;


public class App 
{
    	private static Scanner scanner = new Scanner(System.in);

    	public static void main(String[] args) {
    		try {
    			while (true) {
    				System.out.println("\n 1. Add new plant");
    				System.out.println("\n 2. Update plant cost");
    				System.out.println("\n 3. Delete plant ");
    				System.out.println("\n 4. View all plants");
    				System.out.println("\n 5. Find plant by origin country name");
    				System.out.println("\n 6. Find outdoor plants which requires sunlight");
    				System.out.println("\n 7. Count plants by water supply frequency");
    				System.out.println("\n 8. Exit");
    				int ch = Integer.parseInt(scanner.nextLine());
    		
    			    switch (ch) {
    			
    			    	case 1:
    						addNewPlant();
    						break;
    				    case 2:
    				    	modifyCost();
    				    	break;
    				    case 3:
    				    	deletePlant();
    				    	break;
    				    case 4:
    				    	viewAllPlants();
    				    	break;
    				    case 5:
    				    	viewByOriginCountryName();
    				    	break;
    				    case 6:
    				    	viewOutdoorPlantsWithSunlight();
    				    case 7:
    				    	countPlantByWaterSupplyfreq();
    				    case 8:
    				    	System.exit(0);
    				    	break;
    				    	
    				    }
    					
    					break;
    				    				
            } catch (private static void addnewPlant() {
			// TODO Auto-generated method stub
			
		}
			NumberFormatException e) {
    			System.out.println("Number Format : " + e.getMessage()); 
    		} catch (Exception e) {

    			System.out.println("Error : " + e.getMessage());
    		}
    	}

    		private static Plant createPlant() throws SystemException, InvalidCustomerDataException  {
    			Plant obj = new Plant();
    			try {
    				System.out.println(" Enter the plant Name: ");
    				String plantName = scanner.nextLine();
    				obj.setPlantName(plantName);
    				
    				System.out.println(" Enter The Origin Country Name: ");
    				String countryName = scanner.nextLine();
    				obj.setOriginCountryName(countryName);
    				
    				System.out.println(" Sunlight required or Not: Y/N ");
    				String sunlight = scanner.nextLine();
    				if (sunlight == "Y" || sunlight == "y" )
    				{
    					obj.setSunlightRequired(true);
    				}
    				else if(sunlight == "N" || sunlight == "n")
    				{
    				obj.setSunlightRequired(false);
    				}
    				else 
    				{
    					System.out.println(" Invalid user Input ");
    				}
    				
    				System.out.println("Enter the Plant Type : Indoor/Outdoor ");
    				String plantType = scanner.nextLine();
    				obj.setPantType(plantType);
    				
    				System.out.println("Enter Water Supply Frequency: daily/weekly/alternate days ");
    				String waterSupply = scanner.nextLine();
    				obj.setWaterSupplyFrequency(waterSupply);
    				
    				System.out.println("Enter the Plant Cost ");
    				double plantCost = scanner.nextDouble();
    				obj.setCost(plantCost);
    				
    			} catch (NumberFormatException e) {
    				throw new SystemException("Please Provide a number value\n " + e.getMessage());
    			}

    			return obj;
    		}

    		private static PlantDao dao = new PlantNurseryDaoImpl();

    		private static void addNewplant() throws InvalidCustomerDataException {
    			Plant createPlant;
    			try {
    				createPlant = createPlant();
    				dao.addNewPlant(createPlant);
    			} catch (SQLException e) {
    				System.out.println(e);
    			}catch (SystemException e) {
    				System.out.println(e);
    			}

    		}    	
    		

    		private static void modifyCost() throws InvalidCustomerDataException {
    			//Plant updateCost;
    			try {
    				System.out.println("Enter the Plant ID: ");
    				int ID = scanner.nextInt();
    				//obj.getPlantid(ID);
    				scanner.nextLine();
    				
    				System.out.println("Enter the New Cost: ");
    				double cost = scanner.nextInt();
    				 
    				scanner.nextLine();
    				//updateCost = updateCost();
    				dao.updatePlantCost(ID,cost);
    			} catch (SQLException e) {
    				System.out.println(e);
    			}catch (SystemException e) {
    				System.out.println(e);
    			}
    			 catch (NumberFormatException e) {
    					throw new SystemException("Please Provide a number value\n " + e.getMessage());
    				}


    		}    
    		
    		
    		private static void deletePlant() {
    			
    			try {
    				System.out.println("Enter your Customer ID: ");
    				int ID = scanner.nextInt();
    		       
    				dao.delete(ID);
    			} catch (SQLException e) {
    				System.out.println(e);
    			}catch (SystemException e) {
    				System.out.println(e);
    			}
    			catch (NumberFormatException e) {
    				throw new SystemException("Please Provide a number value\n " + e.getMessage());
    			}

    		}

    		private static void viewAllPlants() throws SQLException, SystemException {
    			
    			
    			dao.showAllPlants();
    		//} catch (NumberFormatException e) {
    			//throw new SystemException("Please Provide a number value\n " + e.getMessage());
    				
    				
    			}

    		private static void viewByOriginCountryName() throws SystemException, SQLException {
    			try {
    				System.out.println("Enter country name ");
    				String countryname = scanner.nextLine();

    				//scanner.nextLine();
    				dao.searchByOriginCountryName(countryname);
    			} catch (NumberFormatException e) {
    				throw new SystemException("Please Provide a number value\n " + e.getMessage());
    					
    					
    				}
    		}
    		
			
    		private static void viewOutdoorPlantsWithSunlight() throws SQLException, SystemException {
    			
    			
    			dao.searchOutdoorPlantsWithSunlight();
    		//} catch (NumberFormatException e) {
    			//throw new SystemException("Please Provide a number value\n " + e.getMessage());
    				
    				
    			}
		
    		private static void countPlantByWaterSupplyfreq() throws SystemException, SQLException {
    			try {
    				System.out.println("Enter Water Supply Frequency: ");
    				String frequency = scanner.nextLine();

    				dao.countryPlantsByWaterSupplyFrequency(frequency);
    			}catch (NumberFormatException e) {
    				throw new SystemException("Please Provide a number value\n " + e.getMessage());
    					
    					
    				}
    		}

}

