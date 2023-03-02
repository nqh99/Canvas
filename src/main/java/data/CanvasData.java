package data;

import java.util.List;

public class CanvasData {
    private final Character[][] data;
    private int width;
    private int height;

    public CanvasData(int width, int height) {
        this.width = width + 2;
        this.height = height + 2;
        data = new Character[height + 2][width + 2];
    }

    public CanvasData(List<String> parameters) {
        this(Integer.parseInt(parameters.get(0)),
                Integer.parseInt(parameters.get(1)));
    }

    public Character[][] getData() {
        return data;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String toDisplayString() {
        StringBuilder result = new StringBuilder();
        if (data != null) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    result.append(data[i][j]);
                }
                if (i < height - 1) {
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
}
