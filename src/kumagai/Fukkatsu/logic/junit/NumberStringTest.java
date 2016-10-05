package kumagai.Fukkatsu.logic.junit;

import junit.framework.*;
import kumagai.Fukkatsu.logic.*;

public class NumberStringTest
	extends TestCase
{
	public void test1()
	{
		assertEquals("１２３４", new NumberString(1234).toString());
	}
}
