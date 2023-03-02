package validation;

import config.Configuration;
import data.CanvasData;
import data.CommandLine;
import handler.Mapper;
import message.Messages;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shape.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineValidatorTest {
	private CanvasData canvasData = new CanvasData(20, 4);
	private Mapper mapper = Configuration.getInstance().getMapper();
	private Validator validator = Configuration.getInstance().getValidatorMap().get(ShapeType.LINE);

	@Before
	public void setUp() {
		validator.setCanvasSize(canvasData.getWidth(), canvasData.getHeight());
	}

	@Test
	public final void testValidateParameters1() {
		CommandLine command = mapper.map("L 1 2 6 2");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().isEmpty());
	}

	@Test
	public final void testValidateParameters2() {
		CommandLine command = mapper.map("L 1 2 6 3");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.HORIZONTAL_VERTICAL_SUPPORT));
	}

	@Test
	public final void testValidateParameters3() {
		List<String> parameters = new ArrayList<>(Arrays.asList("1", "2", "6", "2"));
		validator.setParameters(parameters);
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().isEmpty());
	}

	@Test
	public final void testValidateParameters4() {
		List<String> parameters = new ArrayList<>(Arrays.asList("1", "2", "600", "2"));
		validator.setParameters(parameters);
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.POSITION_OUTSIDE_CANVAS));
	}

	@Test
	public final void testValidateParameters5() {
		CommandLine command = mapper.map("L ");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.PARAMETERS_EXPECTED));
	}

	@Test
	public final void testValidateParameters6() {
		CommandLine command = mapper.map("L 20 ");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.HAS_MISSING_PARAMETERS));
	}

	@Test
	public final void testValidateParameters7() {
		CommandLine command = mapper.map("L 20 4 4 5 9");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.TOO_MANY_PARAMETERS));
	}

	@Test
	public final void testValidateParameters8() {
		CommandLine command = mapper.map("L 6 3 7 4");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.HORIZONTAL_VERTICAL_SUPPORT));
	}

	@Test
	public final void testValidateParameters9() {
		CommandLine command = mapper.map("L 0 3 300 4");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.PARAMETERS_POSITIVE));
	}

	@Test
	public final void testValidateParameters10() {
		CommandLine command = mapper.map("L 1 1 20 1");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().isEmpty());
	}

	@Test
	public final void testValidateParameters11() {
		CommandLine command = mapper.map("L 1 1 21 1");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.POSITION_OUTSIDE_CANVAS));
	}

	@Test
	public final void testValidateParameters12() {
		CommandLine command = mapper.map("L 1 1 1 4");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().isEmpty());
	}

	@Test
	public final void testValidateParameters13() {
		CommandLine command = mapper.map("L 1 1 1 5");
		validator.setParameters(command.getParameters());
		ValidationError result = validator.validate();
		Assert.assertTrue(result.getErrorMessages().contains(Messages.POSITION_OUTSIDE_CANVAS));
	}

}
