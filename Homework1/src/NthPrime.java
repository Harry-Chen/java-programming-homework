import java.util.ArrayList;
import java.util.Scanner;

public class NthPrime {
    private static boolean isPrime(int n){
        if (n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        var in = new Scanner(System.in);
        while (in.hasNextInt()){
            var m = in.nextInt();
            var n = in.nextInt();
            var nums = new ArrayList<Integer>();
            for (int i = 0; i < m; i++){
                nums.add(in.nextInt());
            }
            var result = nums.stream().filter(NthPrime::isPrime).sorted().skip(n - 1).findFirst().orElse(-1);
            System.out.println(result);
        }
    }

}
