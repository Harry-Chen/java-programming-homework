import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BigInteger {
    final private int DIGIT_IN_ONE_NUMBER = 18;
    final private long MAX_ONE_NUMBER = (long) Math.pow(10, DIGIT_IN_ONE_NUMBER);

    private List<Long> num;

    BigInteger(String s) {
        num = new ArrayList<>();
        var paddingNum = (s.length() % DIGIT_IN_ONE_NUMBER == 0) ? 0 : DIGIT_IN_ONE_NUMBER - s.length() % DIGIT_IN_ONE_NUMBER;
        var paddedString = String.join("", Collections.nCopies(paddingNum, "0")) + s;
        for (int i = paddedString.length() / DIGIT_IN_ONE_NUMBER; i > 0 ; i--) {
            num.add(Long.parseUnsignedLong(paddedString, DIGIT_IN_ONE_NUMBER * (i - 1), DIGIT_IN_ONE_NUMBER * i, 10));
        }
    }

    private BigInteger(List<Long> num) {
        this.num = num;
    }

    BigInteger add(BigInteger rhs) {
        var newSize = Math.max(this.num.size(), rhs.num.size());
        var result = new ArrayList<Long>();

        for (int i = 0; i < newSize; i++) {
            if (i < this.num.size() && i < rhs.num.size()){
                result.add(this.num.get(i) + rhs.num.get(i));
            } else if (i < this.num.size()) {
                result.add(this.num.get(i));
            } else {
                result.add(rhs.num.get(i));
            }
        }

        for (int i = 0; i < newSize; i++) {
            var now = result.get(i);
            if (now >= MAX_ONE_NUMBER){
                result.set(i, now - MAX_ONE_NUMBER);
                if (i == newSize - 1) {
                    result.add(1L);
                } else {
                    result.set(i + 1, result.get(i + 1) + 1);
                }
            }
        }

        return new BigInteger(result);
    }

    public String toString() {
        var sb = new StringBuilder();
        for(int i = num.size() - 1; i >= 0; i--) {
            var now = num.get(i);
            if (i == num.size() - 1){
                sb.append(now.toString());
            } else {
                sb.append(String.format("%0" + DIGIT_IN_ONE_NUMBER + "d", now));
            }
        }
        return sb.toString();
    }
}

public class BigIntegerAdder {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        while (in.hasNext()) {
            var aString = in.next();
            var bString = in.next();
            var a = new BigInteger(aString);
            var b = new BigInteger(bString);
            var c = a.add(b);
            System.out.println(c);
        }
    }
}
