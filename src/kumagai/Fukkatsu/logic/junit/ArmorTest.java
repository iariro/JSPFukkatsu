package kumagai.Fukkatsu.logic.junit;

import junit.framework.*;
import kumagai.Fukkatsu.logic.*;

public class ArmorTest
	extends TestCase
{
	public void test1()
	{
		Armor armor = new Armor();

		armor.setName(ArmorName.くさりかたびら);

		assertEquals(3, armor.getValue());
	}

	public void test2()
	{
		Armor armor = new Armor();

		armor.setValue((byte)3);

		assertEquals(ArmorName.くさりかたびら, armor.getName());
	}
}
