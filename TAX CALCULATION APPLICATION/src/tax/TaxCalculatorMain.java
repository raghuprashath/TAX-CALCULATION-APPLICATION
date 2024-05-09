package tax;

import java.util.*;

public class TaxCalculatorMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("+----------------------------------------+");
		System.out.println("| WELCOME TO TAX CALCULATION APPLICATION |");
		System.out.println("+----------------------------------------+");
		//task1 user-name and password
		while(true) {
			System.out.println("PLEASE LOGIN TO CONTINUE");
			System.out.print("Enter the USername: ");
			String username=sc.next();
			System.out.print("Enter the Password: ");
			String password=sc.next();
			AuthenticationValidator a=new AuthenticationValidator(username,password);
			if(!a.validator()) {
				System.out.println("Incorrect UserName or Password..Try again");
			}
			else {
				break;
			}
		}
		
		List<Property> lp=new ArrayList<>();
		List<Vehicle> lv=new ArrayList<>();
		while(true) {
			System.out.println("1.PROPERTY TAX\n2.VEHICLE TAX\n3.TOTAL\n4.EXIT");
			int option=sc.nextInt();
			switch(option) {
			case 1:
				//task 2 to create options under the property tax to perform different operations.
				property(lp);
				break;
				
			case 2:
				//task 6 to create options under the vehicle tax to perform different operations.
				vehicle(lv);
				break;
			case 3:
				//task 10 to display total taxes
				display(lp,lv);
				break;
			case 4:
				//task 11 if user chooses exit option the program stops by displaying below message
				System.out.println("THANKS VISIT AGAIN");
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter the valid operation");
			}
		}
	}
	public static void property(List<Property> lp) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.ADD PROPERTY DETAILS\n2.CALCULATE PROPERTY TAX\n3.DISPLAY ALL PROPERTIES\n4.BACK TO MAIN MENU");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				//task 3 to add the property details
				System.out.println("ENTER THE PROPERTY DETAILS");
                double baseValue;
                while(true) {
    				System.out.print("ENTER THE BASE VALUE OF LAND - ");
                	baseValue=sc.nextDouble();
                	if(baseValue>0) {
                		break;
                	}
    				System.out.print("BASE VALUE MUST BE NON ZERO POSITIVE FORMAT");
                }
                System.out.print("ENTER THE BUILD-UP AREA OF LAND - ");
                int buildupArea = sc.nextInt();
                System.out.print("ENTER THE AGE OF LAND IN YEARS - ");
                int age = sc.nextInt();
                char isCity;
                while(true) {
                    System.out.print("Is land located in city? (y:YES ,N:NO): ");
                    isCity=sc.next().charAt(0);
                	if(isCity=='y'||isCity=='Y'||isCity=='N'||isCity=='n'){
                		break;
                	}
    				System.out.print("THE CHOICE MUST BE SINGLE CHARACTER Y/N");
                }
                Property property = new Property(baseValue,buildupArea,age,isCity);
                lp.add(property);
				break;
			case 2:
				//task 4 to calculate tax
				if(lp.size()==0) {
					System.out.println("NO DATA PRESENT AT THIS MOMENT");
					return;
				}
				System.out.println("====================================================================================");
                System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%n", "ID", "BUILD-UP AREA", "BASE PRICE", "AGE(YEARS)", "IN CITY", "PROPERTY TAX");
                System.out.println("====================================================================================");
                for (Property p : lp) {
                	System.out.printf("%-5d%-15d%-15.2f%-15d%-15c%-15.2f%n", p.getId(), p.getBuildupArea(), p.getBaseValue(), p.getAge(), p.getIsCity(),p.getTax());
                }
                System.out.println("====================================================================================");
				System.out.print("ENTER THE PROPERTY ID TO CALCULATE THE TAX - ");
				int idtocalc=sc.nextInt();
				double propertytax=0;
				boolean found=false;
				for(Property p:lp){
			        if(p.getId()==idtocalc){
			            propertytax=p.calculatetax();
			            found=true;
			            break;
			        }
			    }
			    if(found){
			        System.out.println("PROPERTY TAX FOR PROPERTY "+idtocalc+" IS "+propertytax);
			        System.out.print("Do you want to store this tax for display? (y/n): ");
                    char  storeDecision = sc.next().charAt(0);
                    // Asking the userStore the tax  for display later
                    boolean storeTax = (storeDecision=='y'||storeDecision=='Y');
                    if (storeTax) {
                        for (Property p : lp) {
                            if (p.getId()==idtocalc) {
                                p.settax(propertytax);
                                break;
                            }
                        }
                    }
			    }else{
			        System.out.println("Property with ID "+idtocalc+" not found.");
			    }
				break;
			case 3:
				//task 5 to display all the property
				if(lp.size()==0) {
					System.out.println("NO DATA PRESENT AT THIS MOMENT");
					return;
				}
				System.out.println("====================================================================================");
                System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%n", "ID", "BUILD-UP AREA", "BASE PRICE", "AGE(YEARS)", "IN CITY", "PROPERTY TAX");
                System.out.println("====================================================================================");
                for (Property p : lp) {
                	System.out.printf("%-5d%-15d%-15.2f%-15d%-15c%-15.2f%n", p.getId(), p.getBuildupArea(), p.getBaseValue(), p.getAge(), p.getIsCity(),p.getTax());
                }
                System.out.println("====================================================================================");
				break;
			case 4:
				return;
			}
		}		
	}
	private static void vehicle(List<Vehicle> lv) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1.ADD VEHICLE DETAILS\n2.CALCULATE VEHICLE TAX\n3.DISPLAY ALL VEHICLES\n4.BACK TO MAIN MENU");
			int opt=sc.nextInt();
			switch(opt){
			case 1:
				//task 7 to add Vehicle details
                int regNo;
                while (true) {
                    // The registration number must be 4 digits and contain at least one non-zero digit.
                    System.out.print("ENTER THE VEHICLE REGISTRATION NUMBER - ");
                    String regNoStr = sc.next();
                    if (regNoStr.length() == 4 && !regNoStr.equals("0000")) {
                        regNo = Integer.parseInt(regNoStr);
                        break;
                    } else {
                        System.out.println("REGISTRATION NUMBER MUST BE A POSITIVE INTEGER OF SIZE 4 AND 0000 IS AN INVALID REGISTRATION NUMBER");
                    }
                }
                System.out.print("ENTER THE BRAND OF VEHICLE - ");
                String brand=sc.next();
                int velocity;
                while(true) {
                    System.out.print("ENTER THE MAXIMUM VELOCITY OF THE VEHICLE(KMPH) - ");
                    //velocity must be in range 120 to 300
                    velocity=sc.nextInt();
                    if(velocity>=120 && velocity<=300) {
                    	break;
                    }
                    System.out.println("VELOCITY MUST BE IN THE RANGE OF 12O TO 300 KMPH - ");
                }
                int capacity;
                while(true) {
                    System.out.print("ENTER CAPACITY (NUMBER OF SEATS) OF THE VEHICLE - ");
                    capacity=sc.nextInt();
                    if(capacity>=2 && capacity<=50) {
                    	break;
                    }
                    System.out.println("THE CAPACITY (NUMBER OF SEATS) MUST BE IN  THE RANGE OF T TO 50 - ");
                }
                int type;
                while(true) {
                    System.out.println("CHOOSE THE TYPE OF  THE VEHICLE\n1. PETROL DRIVEN\n2. DIESEL DRIVEN\n3. CNG/LPG DRIVEN");
                    type=sc.nextInt();
                    if(type>0 && type<4) {
                    	break;
                    }
                    System.out.println("YOU MUST CHOOSE THE OPTION IN BETWEEN 1-3 ");
                }
                double cost;
                while(true) {
                    System.out.print("ENTER THE PURCHASE COST OF THE VEHICLE - ");
                    cost=sc.nextDouble();
                    if(cost>=50000&&cost<=1000000) {
                    	break;
                    }
                    System.out.println("THE PURCHASE COST MUST BE BETWEEN 50000 TO 1000000");
                }
                Vehicle vehicle=new Vehicle(regNo,brand,velocity,capacity,type,cost);
                lv.add(vehicle);
				break;
			case 2:
				//task 8 to calculate vehicle tax based on Registration number
				if (lv.size() == 0) {
				    System.out.println("NO DATA PRESENT AT THIS MOMENT");
				    return;
				}
				System.out.println("========================================================================================================================================");
				System.out.printf("%-20s%-15s%-15s%-15s%-15s%-15s%-15s%n", "REGISTRATION NO", "BRAND", "MAX.VELOCITY", "NO.OF SEATS", "VEHICLE TYPE", "PURCHASE COST", "VEHICLE TAX");
				System.out.println("========================================================================================================================================");
				for (Vehicle v : lv) {
				    double vehicleTax = v.getTax(); // Retrieve the actual vehicle tax
				    String vehicleTaxFormatted = (vehicleTax == 0.0) ? "0.00" : String.format("%.2f", vehicleTax); // Format vehicle tax with 2 decimal places or display "0.00" if tax is 0
				    String regNoFormatted = String.format("%04d", v.getRegNo()); // Format registration number with leading zeros
				    System.out.printf("%-20s%-15s%-15d%-15d%-15s%-15.2f%-15s%n", regNoFormatted, v.getBrand(), v.getVelocity(), v.getCapacity(), v.getType(), v.getCost(), vehicleTaxFormatted);
				}
				System.out.println("=========================================================================================================================================");
                System.out.print("ENTER THE RESISTRATION NUMBER OF THE VEHICLE TO CLACULATE TAX - ");
				int regNotocalc=sc.nextInt();
				double vehicletax=0;
				boolean found=false;
				for(Vehicle v:lv){
			        if(v.getRegNo()==regNotocalc){
			            vehicletax=v.calculatetax();
			            found=true;
			            break;
			        }
			    }
			    if(found){
			        System.out.println("VEHICLE TAX FOR  REGISTRATION NO - "+regNotocalc+" IS "+vehicletax);
			        System.out.print("Do you want to store this tax for display? (y/n): ");
                    char  storeDecision = sc.next().charAt(0);
                    // Asking the userStore the tax  for display later
                    boolean storeTax = (storeDecision=='y'||storeDecision=='Y');
                    if (storeTax) {
                        for (Vehicle v : lv) {
                            if (v.getRegNo()==regNotocalc) {
                                v.setTax(vehicletax);
                                break;
                            }
                        }
                    }
			    }else{
			        System.out.println("VEHICLE WITH REGISTRATION NO  "+regNotocalc+" NOT FOUND.");
			    }
				break;
			case 3:
				//task 9 to display all the vehicles
				System.out.println("========================================================================================================================================");
				System.out.printf("%-20s%-15s%-15s%-15s%-15s%-15s%-15s%n", "REGISTRATION NO", "BRAND", "MAX.VELOCITY", "NO.OF SEATS", "VEHICLE TYPE", "PURCHASE COST", "VEHICLE TAX");
				System.out.println("========================================================================================================================================");
				for (Vehicle v : lv) {
				    double vehicleTax = v.getTax(); // Retrieve the actual vehicle tax
				    String vehicleTaxFormatted = (vehicleTax == 0.0) ? "0.00" : String.format("%.2f", vehicleTax); // Format vehicle tax with 2 decimal places or display "0.00" if tax is 0
				    String regNoFormatted = String.format("%04d", v.getRegNo()); // Format registration number with leading zeros
				    System.out.printf("%-20s%-15s%-15d%-15d%-15s%-15.2f%-15s%n", regNoFormatted, v.getBrand(), v.getVelocity(), v.getCapacity(), v.getType(), v.getCost(), vehicleTaxFormatted);
				}
				System.out.println("=========================================================================================================================================");
				break;
			case 4:
				return;
			}
		}
	}
	private static void display(List<Property> lp, List<Vehicle> lv){
		//task 10 to display total taxes
		double totalVehicletax=0,totaPropertytax=0;
		for(Property p:lp) {
			totaPropertytax+=p.calculatetax();
		}
		for(Vehicle v:lv){
			totalVehicletax+=v.calculatetax();
		}
		int totalSize=lp.size()+lv.size();
		if(totalSize==0) {
			System.out.println("NO DATA PRESENT AT THIS MOMENT");
			return;
		}
		double totalTax=totalVehicletax+totaPropertytax;
		System.out.println("+----------------------------------------------------------------+");
		//this is formatted string s-String left aligned with different width of 6,25,21,4
		System.out.printf("| %-6s%-25s%-21s%-4s |\n", "SR.NO", "PARTICULAR", "QUANTITY", "TAX");
		System.out.println("+----------------------------------------------------------------+");
		//this is formatted string d-Integer,s-String,f-floating point number left aligned with different width of 6,25,21,4 same as above
		System.out.printf("| %-6d%-25s%-21d%-4.2f |\n", 1, "PROPERTIES", lp.size(), totaPropertytax);
		System.out.printf("| %-6d%-25s%-21d%-4.2f |\n", 2, "vehicles", lv.size(), totalVehicletax);
		System.out.println("+----------------------------------------------------------------+");
		System.out.printf("| %-29s%-21d%-4.2f |\n", "TOTAL", totalSize, totalTax);
		System.out.println("+----------------------------------------------------------------+");
	}
}
  
