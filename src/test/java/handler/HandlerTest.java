package handler;

import config.Configuration;
import data.CanvasData;
import data.CommandLine;
import exception.InvalidCommandException;
import org.junit.Assert;
import org.junit.Test;
import shape.Shape;
import shape.ShapeType;

import java.util.Map;

public class HandlerTest {
	private Mapper mapper = Configuration.getInstance().getMapper();
	private Handler handler = Configuration.getInstance().getHandler();
	private Map<ShapeType, Shape> shapeMap = Configuration.getInstance().getShapeMap();

	@Test
	public final void testValidate1() {
		boolean hasError = false;
		try {
			handler.validate(mapper.map(" C 20 4 "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertFalse(hasError);
	}

	@Test
	public final void testValidate2() {
		boolean hasError = false;
		try {
			handler.validate(mapper.map(" C "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

	@Test
	public final void testValidate3() {
		boolean hasError = false;
		try {
			handler.validate(mapper.map(" C 0 4 "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

	@Test
	public final void testHandle1() {
		boolean hasError = false;
		try {
			handler.handle(mapper.map(" C 20 4 "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertFalse(hasError);
	}

	@Test
	public final void testHandle2() {
		boolean hasError = false;
		try {
			handler.handle(mapper.map(" C 0 4 "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

	@Test
	public final void testHandle3() {
		boolean hasError = false;
		try {
			handler.handle(mapper.map(" Z 0 4 "));
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

	@Test
	public final void testDrawAndDisplay() {
		CommandLine commandLine = mapper.map("C 20 4");
		CanvasData canvasData = new CanvasData(20, 4);
		Shape shape = shapeMap.get(ShapeType.CANVAS);

		handler.drawAndDisplay(shape, canvasData, commandLine.getParameters());

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

	@Test
	public final void testExecuteCmd1() {
		CanvasData canvasData = new CanvasData(20, 4);

		handler.executeCmd(mapper.map("C 20 4"), canvasData);

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

	@Test
	public final void testExecuteCmd2() {
		CanvasData canvasData = new CanvasData(20, 4);

		handler.executeCmd(mapper.map(" C  20  4"), canvasData);
		String actual = canvasData.toDisplayString();
		String expected =
						"----------------------\n"+
						"|                    |\n"+
						"|                    |\n"+
						"|                    |\n"+
						"|                    |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);

		handler.executeCmd(mapper.map("  L 1 2 6 2      "), canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n"+
						"|                    |\n"+
						"|xxxxxx              |\n"+
						"|                    |\n"+
						"|                    |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);

		handler.executeCmd(mapper.map("  L    6  3  6    4  "), canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n"+
						"|                    |\n"+
						"|xxxxxx              |\n"+
						"|     x              |\n"+
						"|     x              |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);

		handler.executeCmd(mapper.map("  R  14  1  18  3  "), canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n"+
						"|             xxxxx  |\n"+
						"|xxxxxx       x   x  |\n"+
						"|     x       xxxxx  |\n"+
						"|     x              |\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);


		handler.executeCmd(mapper.map("  B  10  3 o  "), canvasData);
		actual = canvasData.toDisplayString();
		expected =
						"----------------------\n"+
						"|oooooooooooooxxxxxoo|\n"+
						"|xxxxxxooooooox   xoo|\n"+
						"|     xoooooooxxxxxoo|\n"+
						"|     xoooooooooooooo|\n"+
						"----------------------";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public final void testExecuteCmd3() {
		boolean hasError = false;
		try {
			CanvasData canvasData = new CanvasData(20, 4);
			handler.executeCmd(mapper.map("D 20 4"), canvasData);
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

	@Test
	public final void testExecuteCmd4() {
		boolean hasError = false;
		try {
			handler.executeCmd(mapper.map(" L 1 2 6 2"), null);
		} catch (InvalidCommandException e) {
			hasError = true;
		}
		Assert.assertTrue(hasError);
	}

}
