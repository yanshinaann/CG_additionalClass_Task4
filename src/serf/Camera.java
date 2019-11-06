package serf;

import vectorsAndMatrix.Matrix4;
import vectorsAndMatrix.Vector3;
import vectorsAndMatrix.Vector4;

public class Camera {
    public Matrix4 translate, rotate, scale, projection;

    public Camera() {
        translate = Matrix4.one();
        scale = Matrix4.one();
        rotate = Matrix4.one();
        projection = Matrix4.one();
    }

    public Vector3 w2c(Vector3 v) {
        return new Vector3(projection.mul(translate.mul(rotate.mul(scale.mul(new Vector4(v))))));
    }

}

