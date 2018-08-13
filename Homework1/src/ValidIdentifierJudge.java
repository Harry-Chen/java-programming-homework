import java.util.Scanner;

public class ValidIdentifierJudge {

    private static boolean validIdentifier(String s){
        if (Character.isJavaIdentifierStart(s.charAt(0))){
            return s.chars().skip(1).allMatch(Character::isJavaIdentifierPart);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println(validIdentifier(in.next()) ? 0 : -1);
    }
}
