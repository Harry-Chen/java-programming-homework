package attendance;

public class Teacher extends People {

    private String major;

    Teacher(int number, String gender, int age, String major) {
        super(number, gender, age);
        this.type = PeopleType.Teacher;
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %d %s", getTypeString(), this.number, this.gender, this.age, this.major);
    }
}
