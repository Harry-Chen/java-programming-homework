package attendance;

public class Student extends People {

    private String name;
    private int year;

    Student(int number, String name, String gender, int age, int year) {
        super(number, gender, age);
        this.type = PeopleType.Student;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %s %d %d", getTypeString(), this.number, this.name, this.gender, this.age, this.year);
    }
}
