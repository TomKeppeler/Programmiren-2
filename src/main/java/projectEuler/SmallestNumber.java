package projectEuler;

public class SmallestNumber {
    public static void main(String[] args) {
        long i = 1;
        int reps = 10;
        while (!isDivisible(i, reps)){
            i++;
            if(i % 10000000 == 0) {
                System.out.print(".");
            }
        }
        System.out.printf("\nThe smallest divisible Number over 1 to %d is %d", reps, i);
    }

    private static boolean isDivisible(long number, int reps) {
        for (int i = 1; i <= reps ; i++) {
            if(!(number % i == 0)){
                return false;
            }
        }
        return true;
    }

}
