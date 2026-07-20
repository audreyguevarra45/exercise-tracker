import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreakCalculator {
    public static int currentStreak(List<ExerciseLog> logs) {
        Set<LocalDate> completedDays = new HashSet<>();

        for (ExerciseLog log : logs) {
            completedDays.add(log.getDate());
        }

        LocalDate day = LocalDate.now();
        int streak = 0;

        while (completedDays.contains(day)) {
            streak++;
            day = day.minusDays(1);
        }

        return streak;
    }
}