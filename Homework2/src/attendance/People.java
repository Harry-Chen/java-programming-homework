package attendance;

public class People {

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
