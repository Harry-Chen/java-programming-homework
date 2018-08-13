import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Matrix {

    private int data[];
    private int m, n;

    Matrix(int m, int n, int[] data) {
        this.m = m;
        this.n = n;
        this.data = data;
    }


    Matrix multiply(Matrix rhs) {
        if (this.n != rhs.m) {
            throw new IllegalArgumentException("Two matrices cannot multiply");
        }
        var newData = new int[this.m * rhs.n];
        var result = new Matrix(this.m, rhs.n, newData);

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < rhs.n; j++) {
                for (int k = 0; k < this.n; k++) {
                    newData[i * result.n + j] += this.data[i * this.n + k] * rhs.data[k * rhs.n + j];
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        var list = IntStream.of(this.data).mapToObj(Integer::toString).collect(Collectors.toList());
        var sb = new StringBuilder();
        for (int i = 0; i < this.m; i++) {
            sb.append(String.join(" ", list.subList(i * this.n, (i + 1) * this.n)));
            sb.append('\n');
        }
        return sb.toString();
    }

}

public class MatrixMultiplier {

    private static Matrix readMatrix(Scanner in){
        var m = in.nextInt();
        var n = in.nextInt();
        var data = new int[m * n];
        var matrix = new Matrix(m, n, data);
        for (int i = 0; i < m * n; i++) {
            data[i] = in.nextInt();
        }
        return matrix;
    }

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var a = readMatrix(in);
        var b = readMatrix(in);
        System.out.println(a.multiply(b));
    }
}
