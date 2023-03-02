package shape;

import data.CanvasData;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bucket implements Shape {
    private CanvasData canvasData;
    private int x;
    private int y;
    private Character c;

    @Override
    public void setParameters(List<String> parameters) {
        x = Integer.parseInt(parameters.get(0));
        y = Integer.parseInt(parameters.get(1));
        c = parameters.get(2).charAt(0);
    }

    @Override
    public void draw(CanvasData canvasData) {
        this.canvasData = canvasData;

        // non-recursive
        fillColor(canvasData.getData(), x, y, c);
    }

    private void fillColor(Character[][] data, int x, int y, Character newColor)  {
        Character currentColor = data[y][x];
        boolean[][] hits = new boolean[canvasData.getHeight()][canvasData.getWidth()];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();

            if(fillColorDo(data, hits, p.x, p.y, currentColor, newColor)) {
                queue.add(new Point(p.x, p.y - 1));
                queue.add(new Point(p.x, p.y + 1));
                queue.add(new Point(p.x - 1, p.y));
                queue.add(new Point(p.x + 1, p.y));
            }
        }
    }

    private boolean fillColorDo(Character[][] data, boolean[][] hits, int x, int y, Character currentColor, Character newColor) {
        if (x < 1 || y < 1 || x > canvasData.getWidth() - 2 || y > canvasData.getHeight() - 2) {
            return false;
        }
        if (hits[y][x]) {
            return false;
        }
        if (!data[y][x].equals(currentColor)) {
            return false;
        }
        // valid, paint it
        data[y][x] = newColor;
        hits[y][x] = true;
        return true;
    }

    static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
