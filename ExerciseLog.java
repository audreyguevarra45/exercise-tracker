import java.time.LocalDate;

public class ExerciseLog {
    private final String activity;
    private final int minutes;
    private final LocalDate date;
    private final String proofPhotoPath;
    private final String description;

    public ExerciseLog(String activity, int minutes, LocalDate date, String proofPhotoPath) {
        this(activity, minutes, date, proofPhotoPath, "");
    }

    public ExerciseLog(String activity, int minutes, LocalDate date, String proofPhotoPath,
                       String description) {
        this.activity = activity;
        this.minutes = minutes;
        this.date = date;
        this.proofPhotoPath = proofPhotoPath;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        String proof = proofPhotoPath == null ? "no proof photo" : "proof: " + proofPhotoPath;
        String notes = description == null || description.isBlank()
                ? "" : " — " + description;
        return date + " — " + activity + " (" + minutes + " min, " + proof + ")" + notes;
    }
}
