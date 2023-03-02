package shape;

import data.CanvasData;

import java.util.List;

public class Rectangle implements Shape {
    private static final Character CHAR_X = 'x';

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Override
    public void setParameters(List<String> parameters) {
        x1 = Integer.parseInt(parameters.get(0));
        y1 = Integer.parseInt(parameters.get(1));
        x2 = Integer.parseInt(parameters.get(2));
        y2 = Integer.parseInt(parameters.get(3));
    }

    @Override
    public void draw(CanvasData canvasData) {
        int minx = Math.min(x1, x2);
        int maxx = Math.max(x1, x2);
        int miny = Math.min(y1, y2);
        int maxy = Math.max(y1, y2);

        for (int j = minx; j <= maxx; j++) {
            canvasData.getData()[y1][j] = CHAR_X;
            canvasData.getData()[y2][j] = CHAR_X;
        }
        for (int i = miny + 1; i <= maxy-1; i++) {
            canvasData.getData()[i][x1] = CHAR_X;
            canvasData.getData()[i][x2] = CHAR_X;
        }
    }

}
