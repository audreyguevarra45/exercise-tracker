import java.time.LocalDate;

public class ExerciseLog {
    private final String activity;
    private final int minutes;
    private final LocalDate date;
    private final String proofPhotoPath;

    public ExerciseLog(String activity, int minutes, LocalDate date, String proofPhotoPath) {
        this.activity = activity;
        this.minutes = minutes;
        this.date = date;
        this.proofPhotoPath = proofPhotoPath;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        String proof = proofPhotoPath == null ? "no proof photo" : "proof: " + proofPhotoPath;
        return date + " — " + activity + " (" + minutes + " min, " + proof + ")";
    }
}