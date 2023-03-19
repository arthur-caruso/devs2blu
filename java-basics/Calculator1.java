import java.util.Scanner;

public class Calculator1 {

	public static Scanner kbd = new Scanner(System.in);
	public static double velocity, time, distance;
	public static int option;

	public static void showOptions() {
		System.out.println("Options:");
		System.out.println("\t0 - Exit program");
		System.out.println("\t1 - Calculate velocity");
		System.out.println("\t2 - Calculate time");
		System.out.println("\t3 - Calculate distance");
	}

	public static void setOption() {
		System.out.print("Option: ");
		option = new Integer(kbd.next());
	}

	public static void calculateVelocity() {
		System.out.print("\tDistance, time [m s]: ");
		distance = new Double(kbd.next());
		time = new Double(kbd.next());

		velocity = distance / time;
		System.out.printf("\tVelocity [m/s]: %.2f\n", velocity);
	}

	public static void calculateTime() {
		System.out.print("\tDistance, velocity [m m/s]: ");
		distance = new Double(kbd.next());
		velocity = new Double(kbd.next());

		time = distance / velocity;
		System.out.printf("\tTime [s]: %.2f\n", time);
	}

	public static void calculateDistance() {
		System.out.print("\tTime, velocity [s m/s]: ");
		time = new Double(kbd.next());
		velocity = new Double(kbd.next());

		distance = time * velocity;
		System.out.printf("\tDistance [m]: %.2f\n", distance);
	}

	public static void main(String[] args) {
		do {
			showOptions();
			setOption();

			switch (option) {
				case 0:
					System.out.println("Exiting...");
					break;

				case 1:
					calculateVelocity();
					break;

				case 2:
					calculateTime();
					break;

				case 3:
					calculateDistance();
					break;

				default:
					System.out.println("Invalid option!");
					break;
			}

		} while (option != 0);

		kbd.close();
	}
}
