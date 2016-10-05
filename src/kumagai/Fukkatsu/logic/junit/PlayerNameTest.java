package kumagai.Fukkatsu.logic.junit;

import junit.framework.*;
import kumagai.Fukkatsu.logic.*;

/**
 *
 * @author kumagai
 */
public class PlayerNameTest
	extends TestCase
{
	public void test1()
	{
		PlayerName playerName = new PlayerName("あいうえ");

		assertEquals(10, playerName.get(0));
		assertEquals("あいうえ", playerName.getText());
	}
}
