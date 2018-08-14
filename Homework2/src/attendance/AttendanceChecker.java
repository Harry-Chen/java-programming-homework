package attendance;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceChecker {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        var n = in.nextInt();
        var m = in.nextInt();

        var record = new HashMap<People, Integer>();
        for (int i = 0; i < n; i++) {
            People people;
            if (in.next().trim().equals(PeopleType.Student.name())) {
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

        var maxPeople = record.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

        System.out.println(maxPeople);
    }
}
