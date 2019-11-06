package vectorsAndMatrix;

public class Vector4 {
    private double[] crd;

    public Vector4(double x, double y, double z, double w) {
        crd = new double[]{x, y, z, w};
    }

    public Vector4(double x, double y, double z) {
        this(x, y, z, 0);
    }

    public Vector4(Vector3 v3, double w) {
        this(v3.getX(), v3.getY(), v3.getZ(), w);
    }

    public Vector4(Vector3 v3) {
        this(v3, 0);
    }

    public Vector4 normalized() {
        if (Math.abs(getW()) < 1e-12) {
            return new Vector4(getX(), getY(), getZ(), 0);
        }
        return new Vector4(
                getX() / getW(),
                getY() / getW(),
                getZ() / getW());

    }

    public static Vector4 zero() {
        return new Vector4(0, 0, 0, 0);
    }

    public Vector4 mul(double num) {
        return new Vector4(getX() * num, getY() * num, getZ() * num, getW() * num);

    }

    public double getX() {
        return crd[0];
    }

    public double getY() {
        return crd[1];
    }

    public double getZ() {
        return crd[2];
    }

    public double getW() {
        return crd[3];
    }

    public double at(int idx) {
        return crd[idx];
    }
}
