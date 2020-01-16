
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pi {
    private static final BigDecimal TWO = new BigDecimal("2");
    private static final BigDecimal FOUR = new BigDecimal("4");
    private static final BigDecimal FIVE = new BigDecimal("5");
    private static final BigDecimal TWO_THIRTY_NINE = new BigDecimal("239");

    Pi() {
    }

    public long pi(int numDigits) {
        long start = System.currentTimeMillis();
        long elapsed;
        int calcDigits = numDigits + 10;
        FOUR.multiply((FOUR.multiply(arccot(FIVE, calcDigits))).subtract(arccot(TWO_THIRTY_NINE, calcDigits)))
                .setScale(numDigits, RoundingMode.DOWN);
        elapsed = System.currentTimeMillis() - start;
        System.out.print(numDigits + " Pi digits computation lasted for about " + elapsed + "ms\n");
        return elapsed;
    }

    private BigDecimal arccot(BigDecimal x, int numDigits) {

        BigDecimal unity = BigDecimal.ONE.setScale(numDigits, RoundingMode.DOWN);
        BigDecimal sum = unity.divide(x, RoundingMode.DOWN);
        BigDecimal xpower = new BigDecimal(sum.toString());
        BigDecimal term = null;

        boolean add = false;

        for (BigDecimal n = new BigDecimal("3"); term == null || term.compareTo(BigDecimal.ZERO) != 0; n = n.add(TWO)) {

            xpower = xpower.divide(x.pow(2), RoundingMode.DOWN);
            term = xpower.divide(n, RoundingMode.DOWN);
            sum = add ? sum.add(term) : sum.subtract(term);
            add = !add;
        }
        return sum;
    }
}
