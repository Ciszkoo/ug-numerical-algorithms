package sparse_matrix;

import java.util.HashMap;

public class SparseMatrixMap implements SparseMatrix {

    private HashMap<Pair<Integer, Integer>, Double> matrix;

    public HashMap<Pair<Integer, Integer>, Double> getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrixInput) {
        matrix = new HashMap<>();
        for (int i = 0; i < matrixInput.length; i++) {
            for (int j = 0; j < matrixInput[i].length; j++) {
                if (matrixInput[i][j] != 0) {
                    matrix.put(new Pair<>(i, j), matrixInput[i][j]);
                }
            }
        }
    }

    public SparseMatrixMap() {
    }

    public SparseMatrixMap(double[][] matrixInput) {
        matrix = new HashMap<>();
        for (int i = 0; i < matrixInput.length; i++) {
            for (int j = 0; j < matrixInput[i].length; j++) {
                if (matrixInput[i][j] != 0) {
                    matrix.put(new Pair<>(i, j), matrixInput[i][j]);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "SparseMatrixMap{" +
                "matrix=" + matrix +
                '}';
    }
}
