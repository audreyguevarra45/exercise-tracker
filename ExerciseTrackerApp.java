import java.time.LocalDate;
import java.util.Scanner;

/** Starting point for the exercise tracker. */
public class ExerciseTrackerApp {
    public static void main(String[] args) {
        Character character = new Character("Move Buddy", "blue", "cap");
        UserProfile user = new UserProfile("Alex", character);
        user.addFriend(new Friend("Sam", "sam@example.com"));

        System.out.println("Welcome, " + user.getName() + "!");
        System.out.println("Log an exercise below. You can review it before saving.");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean keepLogging = true;

            while (keepLogging) {
                String activity = chooseActivity(scanner);
                int minutes = askForMinutes(scanner);

                System.out.print("Add a description (optional): ");
                String description = scanner.nextLine().trim();

                System.out.print("Proof photo file path (optional): ");
                String proofPhoto = scanner.nextLine().trim();

                System.out.println("\nReady to submit:");
                System.out.println("Exercise: " + activity);
                System.out.println("Minutes: " + minutes);
                System.out.println("Description: "
                        + (description.isBlank() ? "None" : description));
                System.out.print("Save this exercise? (yes/no): ");

                if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                    user.addExercise(new ExerciseLog(activity, minutes, LocalDate.now(),
                            proofPhoto.isBlank() ? null : proofPhoto, description));
                    System.out.println("Saved! Current streak: " + user.getCurrentStreak()
                            + " day(s).\n");
                } else {
                    System.out.println("Not saved.\n");
                }

                System.out.print("Log another exercise? (yes/no): ");
                keepLogging = scanner.nextLine().trim().equalsIgnoreCase("yes");
            }
        }

        System.out.println("\nYour exercise log:");
        if (user.getExerciseLogs().isEmpty()) {
            System.out.println("No exercises saved this time.");
        } else {
            user.getExerciseLogs().forEach(System.out::println);
        }
    }

    private static String chooseActivity(Scanner scanner) {
        System.out.println("\nChoose an exercise:");
        System.out.println("1. Walk\n2. Run\n3. Gym workout\n4. Yoga\n5. Other");
        System.out.print("Enter a number: ");

        return switch (scanner.nextLine().trim()) {
            case "1" -> "Walk";
            case "2" -> "Run";
            case "3" -> "Gym workout";
            case "4" -> "Yoga";
            case "5" -> {
                System.out.print("Type your exercise: ");
                yield scanner.nextLine().trim();
            }
            default -> "Exercise";
        };
    }

    private static int askForMinutes(Scanner scanner) {
        while (true) {
            System.out.print("How many minutes? ");
            try {
                int minutes = Integer.parseInt(scanner.nextLine().trim());
                if (minutes > 0) {
                    return minutes;
                }
            } catch (NumberFormatException ignored) {
                // Ask again below.
            }
            System.out.println("Please enter a number greater than 0.");
        }
    }
}
