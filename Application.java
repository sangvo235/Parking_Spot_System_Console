import java.util.Scanner;

/**
 * Application - Utilises the Car, Parking and CarPark class
 * @author         Sang Vo (104020390)
 * @version        JDK 18
 * @date           01 September 2022
 */

public class Application {
    public static void main(String[] args) {
        // Instantiate Objects
        CarPark carParkObj = new CarPark();
        String repeat;

    // Creation of do while loop for multiple entries
    do {
        // Prompt user for request
        System.out.println("Please select one of the following options: \n 1: Add a parking slot \n 2: Delete a parking slot \n 3: List all slots \n 4: Park car into slot \n 5: Find a car by registration number \n 6: Remove a car by registration number \n 7: Exit");
        // Create scanner for user input
        Scanner sc = new Scanner(System.in);
        // Storing user input
        int choice = sc.nextInt();
        // Required as nextInt skips a line
        sc.nextLine();

        // Switch case logic for function selection
        switch(choice) {  
            case 1: // Add a parking slot
                // Prompt user to enter in slot ID
                System.out.println("Please enter a slot ID which starts with a capital letter, followed by a two-digit number eg. D01");
                // Storing user input
                String slotEntry = sc.nextLine();

                // Matching user entry with slot ID requirements
                if(slotEntry.matches("[A-Z][0-9]{2}")) {    
                    // Checking that the parking slot does not exist  
                    if (carParkObj.hasParkingSlot(slotEntry) == false) {
                        // Ask user for type of parking slot
                        System.out.println("Is this slot for Vistor or Staff? ENTER 1 for Vistor and 2 for Staff!");
                        // Storing user input
                        int typeEntry = sc.nextInt();
                        sc.nextLine();

                        // For Vistor
                        if (typeEntry == 1) {
                            carParkObj.addParkingSlot(slotEntry, false);
                        }
                        // For Staff
                        else if (typeEntry == 2) {
                            carParkObj.addParkingSlot(slotEntry, true);
                        }
                        // Invalid Result
                        else {
                            System.out.println("Invalid, please enter either 1 or 2 next time!");
                        }
                    }
                    else {
                        System.out.println("Invalid, this parking slot already exist!");
                    }
                }
                // If user does not entry the correct slot ID format
                else {
                System.out.println("Invalid, check that the entry for parking slot ID starts with a capital letter, followed by a two-digit number eg. D01");
                }
                break;

            case 2: // Delete a parking slot
                // Prompt user to enter in slot ID
                System.out.println("Please enter a slot ID which starts with a capital letter, followed by a two-digit number eg. D01");
                // Storing user input
                String dslotEntry = sc.nextLine();

                // Matching user entry with slot ID requirements
                if(dslotEntry.matches("[A-Z][0-9]{2}")) {   
                    // Checking that the parking slot does exist and is not occupied     
                    if (carParkObj.hasParkingSlot(dslotEntry) == true) {
                        // Deleting parking slot   
                        carParkObj.deleteParkingSlot(dslotEntry);
                    }
                    else {
                        System.out.println("This car parking slot does not exist!");
                    }
                }
                break;

            case 3: // List all slots
                carParkObj.listSlots();
                break;

            case 4: // Park car into slot
                // Creating Registration
                System.out.println("Please enter a registration number starting with a capital letter, followed by a four-digit number e.g A1234");
                // Store rego input
                String newRegistration = sc.nextLine();
                // Matching user entry with registration requirements
                if(newRegistration.matches("[A-Z][0-9]{4}")) {
                    // Ask user to enter parking slot ID
                    System.out.println("Enter an slot ID eg. D01");
                    // Store parking slot input
                    String check = sc.nextLine();

                    // Matching user entry with slot ID requirements & we check for valid slot in the addCar function
                    if(check.matches("[A-Z][0-9]{2}")) {   
                        // Ask user to enter in owner's name
                        System.out.print("Enter the owner's name: ");
                        // Store input
                        String newOwner = sc.nextLine();

                        // Ask user to enter in owner type
                        System.out.println("Is this car for Vistor or Staff? ENTER 1 for Vistor and 2 for Staff!");
                        // Store input
                        int entry = sc.nextInt();
                        sc.nextLine();

                        // Type = if user is Staff Member or not 
                        boolean type;

                        // For Vistor
                        if (entry == 1) {
                            type = false;
                            carParkObj.addCar(new Car(newRegistration, newOwner, type), check);
                        }
                        // For Staff
                        else if (entry == 2) {
                            type = true;
                            carParkObj.addCar(new Car(newRegistration, newOwner, type), check);
                        }
                        else {
                            System.out.println("Invalid, please enter either 1 or 2 next time!");
                        }                               
                    }
                    else {
                        System.out.println("Invalid, check that the entry for parking slot ID starts with a capital letter, followed by a two-digit number eg. D01");
                    }
                }
                else {
                    System.out.println("Invalid, make sure you enter a car registration number starting with a capital letter, followed by a four-digit number e.g T2345");
                } 
                break;

            case 5: // Find a car by registration number 
                // Prompt user to enter car rego number
                System.out.println("Please enter a car registration number starting with a capital letter, followed by a four-digit number e.g A1234");
                String reginput = sc.nextLine();

                // Matching user entry with registration requirements
                if(reginput.matches("[A-Z][0-9]{4}")) {
                    carParkObj.findCar(reginput);
                }
                else {
                    System.out.println("Invalid Car Registration Number");
                }
                break;

            case 6: // Remove a car by registration number
                // Prompt user to enter car rego number
                System.out.println("Please enter a car registration number starting with a capital letter, followed by a four-digit number e.g A1234");
                String rinput = sc.nextLine();

                    // Matching user entry with registration requirements
                    if(rinput.matches("[A-Z][0-9]{4}")) {
                        carParkObj.deleteCar(rinput);
                    }
                    else {
                        System.out.println("Invalid Car Registration Number");
                    }
                break;

            case 7: // Exit
                break;

            default: // If user does not enter a value between 1 - 7
                System.out.println("Invalid entry ~ Please entry a value between 1 - 7!");
                break;
        }

        // Prompt user for repeat if necessary
        System.out.println("Press 'Y' to exit or any key to continue with another request.");
        // Create scanner for user input
        repeat = sc.nextLine();

        } while (!repeat.equalsIgnoreCase("Y"));
    }
}