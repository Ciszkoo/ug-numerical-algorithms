package sparse_matrix;

import java.util.ArrayList;

public class SparseMatrixArrayList implements SparseMatrix {
    private ArrayList<ArrayList<Pair<Integer, Double>>> matrix;

    public ArrayList<ArrayList<Pair<Integer, Double>>> getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrixInput) {
        var tempMatrix = new ArrayList<ArrayList<Pair<Integer, Double>>>();
        for (int i = 0; i < matrixInput.length; i++) {
            tempMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrixInput[i].length; j++) {
                if (matrixInput[i][j] != 0) tempMatrix.get(i).add(new Pair<>(j, matrixInput[i][j]));
            }
        }
        matrix = tempMatrix;
    }

    public SparseMatrixArrayList() {
    }

    public SparseMatrixArrayList(double[][] matrixInput) {
        var tempMatrix = new ArrayList<ArrayList<Pair<Integer, Double>>>();
        for (int i = 0; i < matrixInput.length; i++) {
            tempMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrixInput[i].length; j++) {
                if (matrixInput[i][j] != 0) tempMatrix.get(i).add(new Pair<>(j, matrixInput[i][j]));
            }
        }
        matrix = tempMatrix;
    }

    @Override
    public String toString() {
        return "SparseMatrixArrayList{" +
                "matrix=" + matrix +
                '}';
    }
}
