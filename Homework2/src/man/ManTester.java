package man;

public class ManTester {
    public static void main(String args[]) {
        Man man=new Man("man","nothing");
        SuperMan superman=new SuperMan("superman","nothing");
        Person pman=new Man("pman","nothing");
        Person psman=new SuperMan("psman","nothing");
        Man msMan=new SuperMan("msMan","nothing");

        // code_1();
        code_2();
        // code_3();
    }

    static void code_1() {
        Man man=new Man("man","nothing");
        SuperMan sman=(SuperMan)man;
    }

    static void code_2() {
        Man man=new SuperMan("superman","nothing");
        SuperMan sman=(SuperMan)man;
        Man man2=(Man)sman;
    }

    static void code_3() {
        Person man=new Man("man","nothing");
        SuperMan sman=(SuperMan)man;
    }
}
