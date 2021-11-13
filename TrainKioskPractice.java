import java.util.Scanner;//import java class Scanner from library
import java.text.DecimalFormat;//import Decimal Format from library

public class TrainKioskPractice {//start TrainKioskPractice
	
	//Declare objects
	static Scanner input = new Scanner(System.in);
	static DecimalFormat currency = new DecimalFormat("€0.00");
	
	public static void main (String[] args) {//start main
		menu();
	}//end main
	
	private static void payment(String ageGroup, String ticketType) {//start payment
		double transactionPrice = 0;
		if (ageGroup == "Adult" && ticketType == "Single") {//start if
			transactionPrice = 30;
		}//end if
		
		else if (ageGroup == "Adult" && ticketType == "Return") {//start else if
			transactionPrice = 35;
		}//end else if
		
		else if (ageGroup == "Child" && ticketType == "Single") {//start else if
			transactionPrice = 20;
		}//end else if
		
		else if (ageGroup == "Child" && ticketType == "Return") {//start else if
			transactionPrice = 25;
		}//end else if
		
		System.out.println("You chose " + ageGroup + " " + ticketType + " ticket.");
		System.out.println("The price is: " + currency.format(transactionPrice));
		System.out.println("Please insert cash: ");
		
		//Request user to input cash
		double moneyEntered = input.nextDouble();
		while (moneyEntered < transactionPrice) {//start while
			System.out.println("Remaining Balance: " + currency.format(transactionPrice - moneyEntered));
			System.out.println("Please insert cash: ");
			moneyEntered = moneyEntered + input.nextDouble();
		}//end while
		
		//Dispense tickets
		System.out.println("\n1 " + ageGroup + " " + ticketType + " ticket dispensed.");
	}//end payment
	
	private static void chooseTicketType(String ageGroup) {//start chooseTicketType
		System.out.println("Press 1 for Single ticket");
		System.out.println("Press 2 for Return ticket");
		String choice = input.next();
		switch (choice) {//start switch
			case "1":
				payment(ageGroup, "Single");
				break;
			case "2":
				payment(ageGroup, "Return");
				break;
			default:
				System.out.println("You did not choose a valid option.");
				chooseTicketType(ageGroup);
				break;
		}//end switch
	}//end ticketType
	
	private static void chooseAgeGroup() {//start chooseAgeGroup
		String choice = input.next();
		switch (choice) {//start switch
			case "1":
				chooseTicketType("Adult");
				break;
			case "2":
				chooseTicketType("Child");
				break;
			default:
				System.out.println("You did not choose a valid option.");
				menu();
				break;
		}//end switch
	}//end chooseAgeGroup
	
	public static void menu() {//start menu
		System.out.println("\nWelcome to Enterprise");
		System.out.println("Press 1 for adult ticket");
		System.out.println("Press 2 for child ticket");
		chooseAgeGroup();
		menu();
	}//end menu
}//end TrainKioskPractice
