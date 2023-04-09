import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program calculates cos(x) using Taylor's theorem in 4 different ways.");
        System.out.println("It uses Taylor's theorem centered at x = 0 (binomial series).");

        double start = -2 * Math.PI;
        double end = 2 * Math.PI;
        int iterations = 1_000_000;

        File cosineFile = new File("./src/projectTaylor/results/cosine.txt");
        TaylorCosine taylorCosine = new TaylorCosine(20);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cosineFile))) {
            for (int i = 0, j = 0; i < iterations; i++, j++) {
                double x = start + (end - start) * i / (iterations - 1);

                long x_val = Double.doubleToLongBits(x);
                long cosJ = Double.doubleToLongBits(Math.cos(x));
                long cosV1 = Double.doubleToLongBits(taylorCosine.v1(x));
                long cosV2 = Double.doubleToLongBits(taylorCosine.v2(x));
                long cosV3 = Double.doubleToLongBits(taylorCosine.v3(x));
                long cosV4 = Double.doubleToLongBits(taylorCosine.v4(x));

                writer.write(x_val + " " + cosJ + " " + cosV1 + " " + cosV2 + " " + cosV3 + " " + cosV4 + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

