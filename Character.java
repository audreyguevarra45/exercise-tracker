public class Character {
    private String name;
    private String colour;
    private String accessory;

    public Character(String name, String colour, String accessory) {
        this.name = name;
        this.colour = colour;
        this.accessory = accessory;
    }

    public void customise(String colour, String accessory) {
        this.colour = colour;
        this.accessory = accessory;
    }

    @Override
    public String toString() {
        return name + " — " + colour + ", " + accessory;
    }
}