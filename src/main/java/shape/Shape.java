package shape;

import data.CanvasData;

import java.util.List;

public interface Shape {
    void setParameters(List<String> parameters);
    void draw(CanvasData canvasData);
}
