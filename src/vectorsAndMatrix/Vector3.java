package vectorsAndMatrix;

public class Vector3 {
    private double[] crd;

    public Vector3(double x, double y, double z) {
        crd = new double[]{x, y, z};
    }

    public Vector3(Vector4 v4) {
        if (Math.abs(v4.getW()) < 1e-12) {
            crd = new double[]{v4.getX(), v4.getY(), v4.getZ()};
        } else {
            crd = new double[]{
                    v4.getX() / v4.getW(),
                    v4.getY() / v4.getW(),
                    v4.getZ() / v4.getW()};
        }
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

    public double at(int idx) {
        return crd[idx];
    }
}
