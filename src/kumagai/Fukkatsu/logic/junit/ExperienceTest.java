package kumagai.Fukkatsu.logic.junit;

import junit.framework.*;
import kumagai.Fukkatsu.logic.Experience;

public class ExperienceTest
	extends TestCase
{
	public void test1()
	{
		Experience experience = new Experience(1);

		assertEquals(1, experience.getLevel());
		assertEquals(6, experience.getForNextLevel());
	}
}
