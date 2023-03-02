package shape;

import config.Configuration;
import data.CanvasData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LineTest {

	@Test
	public final void testDraw() {
		CanvasData canvasData = new CanvasData(20, 4);
		Shape canvas = Configuration.getInstance().getShapeMap().get(ShapeType.CANVAS);
		canvas.setParameters(Arrays.asList("20", "4"));
		canvas.draw(canvasData);

		Shape line = Configuration.getInstance().getShapeMap().get(ShapeType.LINE);
		line.setParameters(Arrays.asList("1", "2", "6", "2"));
		line.draw(canvasData);

		String actual = canvasData.toDisplayString();
		String expected =
						"----------------------\n"+
						"|                    |\n"+
						"|xxxxxx              |\n"+
						"|                    |\n"+
						"|                    |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);

		line.setParameters(Arrays.asList("6", "3", "6", "4"));
		line.draw(canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n"+
						"|                    |\n"+
						"|xxxxxx              |\n"+
						"|     x              |\n"+
						"|     x              |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);
	}

}
