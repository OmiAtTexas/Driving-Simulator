import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        boolean isEngineOn = false;
        String gear = "P";
        int speed = 0;
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);

        while (choice != 5) {
            // Display the dashboard
            System.out.println("\n--------------- CAR DASHBOARD ---------------");
            System.out.println("Engine Status: " + (isEngineOn ? "ON" : "OFF"));
            System.out.println("Gear Status: " + gear);
            System.out.println("Speed: " + speed + " km/h");

            // Show menu
            System.out.println("\nMenu: ");
            System.out.println("1. Turn on/off the engine");
            System.out.println("2. Change gear (P, D, R)");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Exit");

            // Ask for user choice
            System.out.print("Enter your choice: ");
            choice = keyboard.nextInt();

            // Process the choice
            switch (choice) {
                case 1:
                    isEngineOn = !isEngineOn;
                    System.out.println("Engine turned " + (isEngineOn ? "ON" : "OFF"));
                    break;

                case 2:
                    System.out.print("Enter gear (P, D, R): ");
                    String inputGear = keyboard.next().toUpperCase();
                    if (inputGear.equals("P") || inputGear.equals("D") || inputGear.equals("R")) {
                        gear = inputGear;
                    } else {
                        System.out.println("Invalid gear. Please enter P, D, or R.");
                    }
                    break;

                case 3:
                    if (isEngineOn && !gear.equals("P")) {
                        speed += 10;
                        System.out.println("Accelerated. Current speed: " + speed + " km/h");
                    } else {
                        System.out.println("Cannot accelerate while engine is OFF or gear is in Park (P).");
                    }
                    break;

                case 4:
                    if (isEngineOn && !gear.equals("P")) {
                        speed = Math.max(speed - 10, 0);
                        System.out.println("Braked. Current speed: " + speed + " km/h");
                    } else {
                        System.out.println("Cannot brake while engine is OFF or gear is in Park (P).");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the car simulator. Thanks for driving. Have a good day!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }
        }

        keyboard.close();
    }
}
