package shape;


import data.CanvasData;

import java.util.List;

public class Line implements Shape {
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
        if (x1 == x2) {
            int min = Math.min(y1, y2);
            int max = Math.max(y1, y2);
            for (int j = min; j <= max; j++) {
                canvasData.getData()[j][x1] = CHAR_X;
            }
        }
        if (y1 == y2) {
            int min = Math.min(x1, x2);
            int max = Math.max(x1, x2);
            for (int i = min; i <= max; i++) {
                canvasData.getData()[y1][i] = CHAR_X;
            }
        }
    }
}
