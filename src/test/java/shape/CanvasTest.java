package shape;

import config.Configuration;
import data.CanvasData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CanvasTest {

	@Test
	public final void testDraw() {
		CanvasData canvasData = new CanvasData(20, 4);
		Shape shape = Configuration.getInstance().getShapeMap().get(ShapeType.CANVAS);
		shape.setParameters(Arrays.asList("20", "4"));
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
