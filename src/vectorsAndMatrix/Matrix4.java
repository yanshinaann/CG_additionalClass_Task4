package vectorsAndMatrix;

public class Matrix4 {
    private double[] matrix;

    public Matrix4(double[][] m) {
        matrix = new double[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i * 4 + j] = m[i][j];
            }
        }

    }

    private Matrix4(double[] arr) {
        matrix = arr;
    }

    public double getAt(int i, int j) {
        return matrix[i * 4 + j];
    }

    public double setAt(int i, int j, double v) {
        return matrix[i * 4 + j] = v;
    }

    public Matrix4 nul(double num) {
        double[] arr = new double[16];
        for (int i = 0; i < 4; i++) {
            arr[i] = matrix[i] * num;
        }
        return new Matrix4(arr);
    }

    public static Matrix4 zero() {
        return new Matrix4((new double[16]));
    }

    public static Matrix4 one() {
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++) {
            m.setAt(i, i, 1);
        }
        return m;
    }

    public Vector4 mul(Vector4 v) {
        double[] r = new double[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                r[i] += r[j] * getAt(i, j);

            }
        }
        return new Vector4(r[0], r[1], r[2], r[3]);

    }

    public Matrix4 mul(Matrix4 m) {
        Matrix4 r = Matrix4.zero();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    r.setAt(i, j, r.getAt(i, j) + this.getAt(i, k) * m.getAt(k, j));
                }
            }

        }
        return r;
    }
}
