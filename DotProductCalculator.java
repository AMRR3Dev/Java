
public class DotProductCalculator {

    public static void main(String[] args) {
        int[] a = {2, 0, 4};
        int[] b = {1, 4, 3};

        int result = dotProduct(a, b);
        System.out.println("Dot Product: " + result);
    }

    public static int dotProduct(int[] a, int[] b) {

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}
