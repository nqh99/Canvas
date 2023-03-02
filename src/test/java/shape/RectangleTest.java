package shape;

import config.Configuration;
import data.CanvasData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RectangleTest {

	@Test
	public final void testDraw() {
		CanvasData canvasData = new CanvasData(20, 4);
		Shape canvas = Configuration.getInstance().getShapeMap().get(ShapeType.CANVAS);
		canvas.setParameters(Arrays.asList("20", "4"));
		canvas.draw(canvasData);

		Shape rectangle = Configuration.getInstance().getShapeMap().get(ShapeType.RECTANGLE);
		rectangle.setParameters(Arrays.asList("14", "1", "18", "3"));
		rectangle.draw(canvasData);

		String actual = canvasData.toDisplayString();
		String expected =
						"----------------------\n"+
						"|             xxxxx  |\n"+
						"|             x   x  |\n"+
						"|             xxxxx  |\n"+
						"|                    |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);

		rectangle.setParameters(Arrays.asList("1", "1", "4", "4"));
		rectangle.draw(canvasData);

		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n" +
						"|xxxx         xxxxx  |\n" +
						"|x  x         x   x  |\n" +
						"|x  x         xxxxx  |\n" +
						"|xxxx                |\n" +
						"----------------------";
		Assert.assertEquals(actual, expected);
	}

}
