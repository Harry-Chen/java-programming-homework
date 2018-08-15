import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

enum PeopleType {
    Teacher, Student
}

class People {

    PeopleType type;
    int number;
    String gender;
    int age;

    People(int number, String gender, int age) {
        this.number = number;
        this.gender = gender;
        this.age = age;
    }

    People(PeopleType type, int number) {
        this.number = number;
        this.type = type;
    }

    String getTypeString() {
        return this.type.name();
    }

    @Override
    public int hashCode() {
        return type == PeopleType.Teacher ? -number : number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof People)) return false;
        var rhs = (People) o;
        return this.type == rhs.type && this.number == rhs.number;
    }

}

class Teacher extends People {

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

class Student extends People {

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

public class AttendanceChecker {
    public static void main(String args[]) {

        try (
                var in = new Scanner(new File("./test.in"));
                var out = new PrintWriter(new File("./test.out"))
        ) {

            var n = in.nextInt();
            var m = in.nextInt();

            var record = new HashMap<People, Integer>();
            for (int i = 0; i < n; i++) {
                People people;
                if (in.next().trim().equals("Student")) {
                    var number = in.nextInt();
                    var name = in.next().trim();
                    var gender = in.next().trim();
                    var age = in.nextInt();
                    var year = in.nextInt();
                    people = new Student(number, name, gender, age, year);
                } else {
                    var number = in.nextInt();
                    var gender = in.next().trim();
                    var age = in.nextInt();
                    var major = in.next().trim();
                    people = new Teacher(number, gender, age, major);
                }
                record.put(people, 0);
            }

            for (int i = 0; i < m; i++) {
                People people = new People(in.next().equals("S") ? PeopleType.Student : PeopleType.Teacher, in.nextInt());
                record.put(people, record.get(people) + 1);
            }

            var maxCount = record.values().stream().max(Comparator.comparingInt(o -> o)).get();
            record.entrySet().stream()
                    .filter(s -> s.getValue().equals(maxCount))
                    .map(Map.Entry::getKey)
                    .forEach(out::println);

        } catch (FileNotFoundException e) {
            // do nothing
        }

    }
}