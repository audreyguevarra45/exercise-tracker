public class Friend {
    private final String name;
    private final String contact;

    public Friend(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name + " (" + contact + ")";
    }
}