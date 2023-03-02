package data;

import config.Configuration;
import org.junit.Assert;
import org.junit.Test;
import shape.Shape;
import shape.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CanvasDataTest {
	private Map<ShapeType, Shape> shapeMap = Configuration.getInstance().getShapeMap();

	@Test
	public final void testGetStringToDisplay() {
		CanvasData canvasData = new CanvasData(20, 4);
		Shape shape = shapeMap.get(ShapeType.CANVAS);

		shape.setParameters(new ArrayList<>(Arrays.asList("20", "4")));
		shape.draw(canvasData);

		String actual = canvasData.toDisplayString();
		String expected =
				"----------------------\n"+
				"|                    |\n"+
				"|                    |\n"+
				"|                    |\n"+
				"|                    |\n"+
				"----------------------";
		Assert.assertEquals(actual, expected);
	}

}
