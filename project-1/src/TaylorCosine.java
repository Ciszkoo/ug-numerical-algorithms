public class TaylorCosine {
    private int n;

    public int getN() { return n; }
    public void setN(int n) { this.n = n; }

    public TaylorCosine() {}

    public TaylorCosine(int n) {
        this.n = n;
    }

    private double pow(double x, int y) {
        if (x == 0) return 0;
        if (y == 0) return 1;

        double res = 1;
        for (int i = 0; i < y; i++) res *= x;

        return res;
    }

    private double factorial(double x) {
        if (x == 0) return 1;

        double result = x;
        for (int i = 0; i < x - 1; i++) result *= i + 1;

        return result;
    }

    public double v1(double x) {
        double cos = 0;

        for (int i = 0; i <= n; i += 2) {
            cos += pow(x, i) / factorial(i) * pow(-1, i / 2);
        }

        return cos;
    }

    public double v2(double x) {
        double cos = 0;

        for (int i = n; i >= 0; i -= 2) {
            cos += pow(x, i) / factorial(i) * pow(-1, i / 2);
        }

        return cos;
    }

    public double v3(double x) {
        double cos = 1;
        double prevNum = cos;

        for (int i = 2; i <= n; i += 2) {
            double y = prevNum * pow(x, 2) / (i - 1) / i * -1;
            cos += y;
            prevNum = y;
        }

        return cos;
    }

    public double v4(double x) {
        double prevNum = pow(x, n) / factorial(n) * pow(-1, n / 2);
        double cos = prevNum;

        for (double i = n - 2; i >= 0; i -= 2) {
            double y = prevNum * (i + 1) * (i + 2) / pow(x, 2) * -1;
            cos += y;
            prevNum = y;
        }

        return cos;
    }
}
