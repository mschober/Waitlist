package utils;

import static org.junit.Assert.*;

public class WaitlistTestHelper {

	public static void assertOnlyOne(long count) {
		assertEquals(1, count);
	}

	public static void assertNone(long count) {
		assertEquals(0, count);
	}

}
