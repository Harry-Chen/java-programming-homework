package man;

public class SuperMan extends Man {

    SuperMan(String name, String description) {
        super(name, description);
    }

    SuperMan() {
        super("man.SuperMan", "I can fly");
    }

    @Override
    public int changeSomething() {
        return ++count;
    }

    @Override
    public void move() {
        System.out.println("I am flying...");
    }

    public void fly() {
        System.out.println("fly, I am a SuperMan");
    }
}
