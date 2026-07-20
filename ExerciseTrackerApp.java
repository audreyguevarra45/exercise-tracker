import java.time.LocalDate;

/** Starting point for the exercise tracker. */
public class ExerciseTrackerApp {
    public static void main(String[] args) {
        Character character = new Character("Move Buddy", "blue", "cap");
        UserProfile user = new UserProfile("Alex", character);

        user.addExercise(new ExerciseLog("Walk", 30, LocalDate.now(), "photos/walk.jpg"));
        user.addExercise(new ExerciseLog("Yoga", 20, LocalDate.now().minusDays(1), null));
        user.addFriend(new Friend("Sam", "sam@example.com"));

        System.out.println("Welcome, " + user.getName() + "!");
        System.out.println("Character: " + user.getCharacter());
        System.out.println("Current streak: " + user.getCurrentStreak() + " days");
        System.out.println("\nExercise log:");
        user.getExerciseLogs().forEach(System.out::println);
        System.out.println("\nAccountability friends:");
        user.getFriends().forEach(System.out::println);
    }
}
