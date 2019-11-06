package serf;

import vectorsAndMatrix.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Polyline3D {
    private List<Vector3> points;
    public  Polyline3D(List<Vector3> p, boolean closed){
        points = new ArrayList<>(p);
        if (closed) points.add(points.get(0));// сделать проверку на пустой лист

    }
    public List<Vector3> getPoints(){
        return points;
    }
    public double avgZ(){
        double sum = 0;
        for(int i = 0; i<points.size();i++){//точки могуьт быть одинак по знач но разные по экз класса
            sum +=points.get(i).getZ();

        }
        return sum/points.size();
    }
}
