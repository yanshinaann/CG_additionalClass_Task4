package serf;

import vectorsAndMatrix.Vector3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    public List<IModel> models = new ArrayList<>();

    public BufferedImage drawScene(ScreenConverter sc, Camera c) {
        BufferedImage bi = new BufferedImage(sc.getWs(), sc.getHs(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();

        /**/
        ArrayList<Polyline3D> lines = new ArrayList<>();
        for (IModel m : models) {
            for (Polyline3D pi : m.getLines()) {
                List<Vector3> vv = new LinkedList<>();
                for (Vector3 v : pi.getPoints()) {
                    vv.add(c.w2c(v));
                }
                lines.add(new Polyline3D(vv, false));
            }
        }

        lines.sort(new Comparator<Polyline3D>() {
            @Override
            public int compare(Polyline3D o1, Polyline3D o2) {
                return (int) Math.signum(o1.avgZ() - o2.avgZ());
            }
        });
        /**/

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g.setColor(Color.BLACK);
        for (Polyline3D p1 : lines) {
            ScreenPoint last = sc.r2s(p1.getPoints().get(0));
            for (int i = 1; i<p1.getPoints().size();i++){
                ScreenPoint newPoint = sc.r2s(p1.getPoints().get(i));
                g.drawLine(last.getI(), last.getJ(), newPoint.getI(), newPoint.getJ());
                last = newPoint;
            }
        }

        g.dispose();
        return bi;
    }
}
