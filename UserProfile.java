import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private final String name;
    private final Character character;
    private final List<ExerciseLog> exerciseLogs = new ArrayList<>();
    private final List<Friend> friends = new ArrayList<>();

    public UserProfile(String name, Character character) {
        this.name = name;
        this.character = character;
    }

    public void addExercise(ExerciseLog exerciseLog) {
        exerciseLogs.add(exerciseLog);
    }

    public void addFriend(Friend friend) {
        friends.add(friend);
    }

    public int getCurrentStreak() {
        return StreakCalculator.currentStreak(exerciseLogs);
    }

    public String getName() {
        return name;
    }

    public Character getCharacter() {
        return character;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public List<Friend> getFriends() {
        return friends;
    }
}