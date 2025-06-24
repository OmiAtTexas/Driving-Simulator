import java.util.Scanner;

// DrivingSimulation class implements the Driving Simulation which includes various actions like turn the engine on/off, accelerate (i.e. increase the speed) and apply the brakes.
public class DrivingSimulationLab {

    // Initial position of the gear is P (i.e. Park)
    public static String gear = "P";
    // Initial speed is set to 0
    public static int speed = 0;
    // Engine is initially off
    public static boolean isEngineOn = false;
    // Scanner object for user input
    public static Scanner keyBoard = new Scanner(System.in);

    // Starts the car simulation
    public static void startSimulation() {
        boolean displayMenu = true;

        while (displayMenu) {
            displayDashboard();                  // Show current car status
            int choice = getUserChoice();        // Get user input
            processChoice(choice);               // Handle the user action
            System.out.println();
        }
    }

    // Display the car dashboard
    public static void displayDashboard() {
        System.out.println("------ Car Dashboard ------");
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Engine: " + (isEngineOn ? "On" : "Off"));
        System.out.println("Gear: " + gear);
        System.out.println("Menu:");
        System.out.println("1. Turn on/off the engine");
        System.out.println("2. Change gear (P, D, R)");
        System.out.println("3. Accelerate");
        System.out.println("4. Brake");
        System.out.println("5. Exit");
    }

    // Get user input
    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return keyBoard.nextInt();
    }

    // Handle user choice
    public static void processChoice(int choice) {
        switch (choice) {
            case 1:
                toggleEngine();
                break;
            case 2:
                changeGear();
                break;
            case 3:
                accelerate();
                break;
            case 4:
                brake();
                break;
            case 5:
                exitSimulation();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    // Toggle engine on/off
    public static void toggleEngine() {
        isEngineOn = !isEngineOn;
        System.out.println("Engine turned " + (isEngineOn ? "On" : "Off"));
    }

    // Change gear
    public static void changeGear() {
        System.out.print("Enter gear (P, D, R): ");
        String newGear = keyBoard.next().toUpperCase();

        if (newGear.equals("P") || newGear.equals("D") || newGear.equals("R")) {
            gear = newGear;
            System.out.println("Gear changed to " + gear);
        } else {
            System.out.println("Invalid gear! Please enter P, D, or R.");
        }
    }

    // Accelerate the car
    public static void accelerate() {
        if (isEngineOn && !gear.equals("P")) {
            speed += 10;
            System.out.println("Accelerated. Current speed: " + speed + " km/h");
        } else {
            System.out.println("Cannot accelerate. Make sure engine is ON and gear is not in Park (P).");
        }
    }

    // Apply brake
    public static void brake() {
        if (isEngineOn && speed > 0) {
            speed = Math.max(speed - 5, 0); // Avoid negative speed
            System.out.println("Braked. Current speed: " + speed + " km/h");
        } else {
            System.out.println("Cannot brake. Car is either OFF or already stationary.");
        }
    }

    // Exit the simulation
    public static void exitSimulation() {
        System.out.println("Exiting simulation... Thank you for driving!");
        System.exit(0);
    }

    // Main method
    public static void main(String[] args) {
        startSimulation();
    }
}
