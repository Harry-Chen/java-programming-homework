package man;

public class Man implements Person {

    private String name, description;
    static int count = 0;

    Man(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int changeSomething() {
        return --count;
    }

    public void move() {
        System.out.println("I am moving...");
    }
}
