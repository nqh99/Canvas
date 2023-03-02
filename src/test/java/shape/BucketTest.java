package shape;

import config.Configuration;
import data.CanvasData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BucketTest {

	@Test
	public final void testDraw() {
		CanvasData canvasData = new CanvasData(20, 4);
		Shape canvas = Configuration.getInstance().getShapeMap().get(ShapeType.CANVAS);
		canvas.setParameters(Arrays.asList("20", "4"));
		canvas.draw(canvasData);

		Shape rectangle = Configuration.getInstance().getShapeMap().get(ShapeType.RECTANGLE);
		rectangle.setParameters(Arrays.asList("14", "1", "18", "3"));
		rectangle.draw(canvasData);

		rectangle.setParameters(Arrays.asList("1", "1", "4", "4"));
		rectangle.draw(canvasData);

		Shape bucket = Configuration.getInstance().getShapeMap().get(ShapeType.BUCKET);
		bucket.setParameters(Arrays.asList("2", "2", "o"));
		bucket.draw(canvasData);

		String actual = canvasData.toDisplayString();
		String expected =
						"----------------------\n" +
						"|xxxx         xxxxx  |\n" +
						"|xoox         x   x  |\n" +
						"|xoox         xxxxx  |\n" +
						"|xxxx                |\n" +
						"----------------------";
		Assert.assertEquals(actual, expected);


		bucket = Configuration.getInstance().getShapeMap().get(ShapeType.BUCKET);
		bucket.setParameters(Arrays.asList("5", "3" ,"e"));
		bucket.draw(canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n" +
						"|xxxxeeeeeeeeexxxxxee|\n" +
						"|xooxeeeeeeeeex   xee|\n" +
						"|xooxeeeeeeeeexxxxxee|\n" +
						"|xxxxeeeeeeeeeeeeeeee|\n" +
						"----------------------";
		Assert.assertEquals(actual, expected);
	}

}
