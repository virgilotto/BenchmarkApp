public class MyMatrix {
    Double[][] A = { { 483902.7743, 42347.775 }, { 483902.7743, 42347.775 } };
    Double[][] B = { { 483902.7743, 42347.775 }, { 483902.7743, 42347.775 } };

    public static Double[][] multiplicar(Double[][] A, Double[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        Double[][] C = new Double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0.00000;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static long testFunct(Double[][] A, Double[][] B){
        long start = System.currentTimeMillis();
        long elapsed;
        for(int i = 0; i < 10_000_000 ; i++) {
            Double[][] result = multiplicar(A, B);
        }
        elapsed = System.currentTimeMillis() - start;
        System.out.print("Matrix computation lasted for about " + elapsed + "ms\n");
        return elapsed;
    }

}
