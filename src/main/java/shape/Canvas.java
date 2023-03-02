package shape;

import data.CanvasData;
import java.util.List;

public class Canvas implements Shape { // consider canvas like a Shape with display size as 'inputWidth + 2' and 'inputHeight + 2'
    private static final Character CHAR_BLANK = ' ';
    private static final Character CHAR_MINUS = '-';
    private static final Character CHAR_VERTICAL = '|';

    private int width;
    private int height;

    @Override
    public void setParameters(List<String> parameters) {
        width = Integer.parseInt(parameters.get(0)) + 2;// Plus 2 for the boundary
        height = Integer.parseInt(parameters.get(1)) + 2;// Plus 2 for the boundary
    }

    @Override
    public void draw(CanvasData canvasData) {
        Character[][] data = canvasData.getData();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = CHAR_BLANK;
            }
        }

        for (int j = 0; j < width; j++) {
            data[0][j] = CHAR_MINUS;
            data[height-1][j] = CHAR_MINUS;
        }
        for (int i = 1; i < height-1; i++) {
            data[i][0] = CHAR_VERTICAL;
            data[i][width-1] = CHAR_VERTICAL;
        }
    }

}
