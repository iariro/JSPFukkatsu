package kumagai.Fukkatsu.logic.junit;

import junit.framework.*;
import kumagai.Fukkatsu.logic.*;

public class JumonTest
	extends TestCase
{
	public void test1()
	{
		GameDataBitArray gameDataBitArray = new YonhietaGameData();
		Jumon jumon = new Jumon(gameDataBitArray);

		assertEquals(
			"ふるいけや かわずとびこむ みずのおと ばしや",
			jumon.getString());
	}

	public void test2()
	{
		GameDataBitArray gameDataBitArray = new YonhietaGameData();
		Jumon jumon = new Jumon(gameDataBitArray);

		System.out.println(jumon.getJumonAsKingSerifu());
	}
}
