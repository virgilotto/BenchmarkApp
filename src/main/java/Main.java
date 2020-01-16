
import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

public class Main {

    public static void main(String[] args) {
        System.out.println(Advapi32Util.registryGetStringValue(HKEY_LOCAL_MACHINE,
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0\\", "ProcessorNameString"));
        System.out.println(Advapi32Util.registryGetStringValue(HKEY_LOCAL_MACHINE,
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0\\", "Identifier"));

        Test test = new Test();
        Pi pi = new Pi();
        System.out.println("Computing...");

        ///// ARITHMETIC OPERATIONS TEST/////
        test.test("Addition (double)", (Double a, Double b) -> {
            return a + b;
        }, 483902.7743, 42347.775, 10_000_000);
        test.test("Subtraction (double)", (Double a, Double b) -> {
            return a - b;
        }, 483902.7743, 42347.775, 10_000_000);
        test.test("Multiplication (double)", (Double a, Double b) -> {
            return a * b;
        }, 483902.7743, 42347.775, 1_000_000);
        test.test("Division (double)", (Double a, Double b) -> {
            return a / b;
        }, 483902.7743, 42347.775, 1_000_000);
        test.test("Log10", (Double a, Double b) -> {
            return Math.log10(a);
        }, 483902.7743, 42347.775, 1_000_000);
        test.test("LogE", (Double a, Double b) -> {
            return Math.log(a);
        }, 483902.7743, 42347.775, 1_000_000);
        test.test("Power", (Double a, Double b) -> {
            return Math.pow(a, b);
        }, 483902.7743, 12, 100_000);

        ///// PI DIGITS COMPUTING TEST/////
        pi.pi(50_000);

        System.out.println("Done!");
    }

}
