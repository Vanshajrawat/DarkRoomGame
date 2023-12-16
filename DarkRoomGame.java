import java.util.Scanner;

public class DarkRoomGame {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isLit = false;
    private static boolean hasWood = false;
    private static boolean metGirl = false;

    private static boolean hasCart = false;

    private static int wood = 0;

    public static void main(String[] args) {
        System.out.println("You are inside a dark room. It is very cold.");
        System.out.println("There is a forest outside the dark room.");
        System.out.println("A girl is lying across one of the walls of the dark room and is shivering.");

        while (true) {
            displayOptions();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (!isLit && hasWood) {
                        lightFire();
                        wood = wood - 1;
                    } else {
                        System.out.println("You don't have wood to light a fire.");
                    }
                    break;
                case 2:
                    if (hasCart) {
                        wood = wood + 10;
                        System.out.println("You gathered wood using a cart.");
                    } else {
                        exploreForest(wood);
                        wood = wood + 1;
                    }
                    break;
                case 3:
                    if (metGirl) {
                        interactWithGirl();
                    } else {
                        System.out.println("You asked her who she was, but she is not willing to talk.");
                    }
                    break;
                case 4:
                    System.out.println("Units of wood left = " + wood);
                    break;
                case 5:
                    System.out.println("Game Over");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }

    private static void displayOptions() {
        System.out.println("\nWhat do you want to do?:");
        System.out.println("1. Light a fire");
        System.out.println("2. Explore the forest");
        System.out.println("3. Interact with the girl");
        System.out.println("4. Check the stock of wood");
        System.out.println("5. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void lightFire() {
        System.out.println("You light a fire in the dark room. The room is now lit!");
        isLit = true;

        System.out.println("The girl is feeling warm now.");
        System.out.println("She says that she can help, she is a builder.");
        metGirl = true;
    }

    private static void exploreForest(int wood) {
        System.out.println("You step outside the dark room and find a forest.");
        System.out.println("You gathered wood from the forest.");

        hasWood = true;
    }

    private static void interactWithGirl() {
        if(metGirl) {
            System.out.println("What do you want her to build?:");
            System.out.println("1. A hut");
            System.out.println("2. A cart");

            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    if (wood >= 20) {
                        System.out.println("You asked the builder to build a hut. She built a hut.");
                        System.out.println("Hut is much more comfortable and warmer than the dark room.");
                        wood = wood - 20;
                        hasWood = false;
                    } else {
                        System.out.println("You don't have wood to build a hut.");
                    }
                    break;
                case 2:
                    if (wood == 1) {
                        System.out.println("You asked the builder to build a cart. She built a cart.");
                        System.out.println("Now you can carry more wood.");

                        wood = wood - 1;

                        hasCart = true;
                        hasWood = false;
                    } else {
                        System.out.println("You don't have wood to build a cart.");
                    }
                    break;
                default:
                    System.out.println("Choose a valid option.");
                    break;
            }
        }
        else{
                System.out.println("You asked her who she was, but she is not willing to talk.");
            }

        }

}
