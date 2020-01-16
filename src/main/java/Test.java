
import java.util.function.BinaryOperator;

public class Test {

    public long test(String desc, BinaryOperator<Double> op, double a, double b, long startIter) {
        long maxIter = startIter;
        long elapsed;
        do {
            maxIter *= 2;
            long start = System.currentTimeMillis();
            for (long niter = 0; niter < maxIter; ++niter) {
                double res = op.apply(a, b);
            }
            elapsed = System.currentTimeMillis() - start;
        } while (elapsed <= 500);
        long seconds1 = elapsed * 2;
        System.out.print(desc + " lasted for about " + seconds1 + "ms\n");
        return seconds1;
    }

}
