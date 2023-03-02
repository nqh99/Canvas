package util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UtilsTest {

	@Test
	public final void testIsPositiveNumber() {
		Assert.assertTrue(Utils.isPositiveNumber("15"));
		Assert.assertFalse(Utils.isPositiveNumber("0"));
		Assert.assertFalse(Utils.isPositiveNumber("-5"));
		Assert.assertFalse(Utils.isPositiveNumber("abc"));
	}

	@Test
	public final void testIsPositiveNumberList() {
		Assert.assertTrue(Utils.isPositiveNumberList("15", "1", "500"));
		Assert.assertFalse(Utils.isPositiveNumberList("0", "522"));
		Assert.assertFalse(Utils.isPositiveNumberList("123","-5"));
		Assert.assertFalse(Utils.isPositiveNumberList("1","abc"));
	}

	@Test
	public final void testIsNotBlank() {
		Assert.assertTrue(Utils.isNotBlank("abcde"));
		Assert.assertTrue(Utils.isNotBlank("e"));
		Assert.assertFalse(Utils.isNotBlank(""));
		Assert.assertFalse(Utils.isNotBlank("   "));
	}

	@Test
	public final void testIsNotEmpty() {
		Assert.assertTrue(Utils.isNotEmpty(new ArrayList<>(Collections.singletonList("a"))));
		Assert.assertFalse(Utils.isNotEmpty(new ArrayList<>()));
	}

	@Test
	public final void testIsEmpty() {
		Assert.assertTrue(Utils.isEmpty(new ArrayList<>()));
		Assert.assertFalse(Utils.isEmpty(new ArrayList<>(Collections.singletonList("a"))));
	}

}
