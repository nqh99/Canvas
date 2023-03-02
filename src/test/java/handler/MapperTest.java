package handler;

import data.CommandLine;
import org.junit.Assert;
import org.junit.Test;

public class MapperTest {
	private Mapper mapper = new Mapper();

	@Test
	public final void testMapCommandLine1() {
		CommandLine command1 = mapper.map("C w h");
		CommandLine command2 = new CommandLine();
		command2.setCmd("C");
		command2.setParameters("w", "h");
		Assert.assertEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine2() {
		CommandLine command1 = mapper.map("   C   w   h   ");
		CommandLine command2 = mapper.map("C w h");
		Assert.assertEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine3() {
		CommandLine command1 = mapper.map("   C   w   h  h ");
		CommandLine command2 = mapper.map("C w h");
		Assert.assertNotEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine4() {
		CommandLine command1 = mapper.map("   Q    ");
		CommandLine command2 = mapper.map("Q");
		Assert.assertEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine5() {
		CommandLine command1 = mapper.map("   R    14   1   18   3 ");
		CommandLine command2 = new CommandLine();
		command2.setCmd("R");
		command2.setParameters("14", "1", "18", "3");
		Assert.assertEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine6() {
		CommandLine command1 = mapper.map("   R    14   1   18   3  3 ");
		CommandLine command2 = new CommandLine();
		command2.setCmd("R");
		command2.setParameters("14", "1", "18", "3");
		Assert.assertNotEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine7() {
		CommandLine command1 = mapper.map("   B  10  3   o ");
		CommandLine command2 = new CommandLine();
		command2.setCmd("B");
		command2.setParameters("10", "3", "o");
		Assert.assertEquals(command1, command2);
	}

	@Test
	public final void testMapCommandLine8() {
		CommandLine command1 = mapper.map("   B  10  3   o  o");
		CommandLine command2 = new CommandLine();
		command2.setCmd("B");
		command2.setParameters("10", "3", "o");
		Assert.assertNotEquals(command1, command2);
	}


	@Test
	public final void testMapCommandLine9() {
		CommandLine command1 = mapper.map("   B  10  3   oo  ");
		CommandLine command2 = new CommandLine();
		command2.setCmd("B");
		command2.setParameters("10", "3", "o");
		Assert.assertNotEquals(command1, command2);
	}

}
