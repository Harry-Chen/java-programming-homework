import java.util.List;
import java.util.Scanner;

public class ValidIdentifierJudge {

    private static final String[] RESERVED = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "false", "null", "true", "goto"};
    private static final List<String> RESERVED_LIST = List.of(RESERVED);

    private static boolean validIdentifier(String s) {
        if (RESERVED_LIST.contains(s)) {
            return false;
        }
        if (!Character.isJavaIdentifierStart(s.charAt(0))) {
            return false;
        }
        return s.chars().allMatch(Character::isJavaIdentifierPart);
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println(validIdentifier(in.nextLine().trim()) ? 0 : -1);
    }
}
