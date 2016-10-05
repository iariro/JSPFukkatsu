package kumagai.Fukkatsu.logic;

/**
 * 文字とコードの対。
 * @author kumagai
 */
public class CharAndCode
{
	public final char character;
	public final byte code;

	/**
	 * メンバーに値を割り当てる。
	 * @param character 文字
	 * @param code コード値
	 */
	public CharAndCode(char character, int code)
	{
		this.character = character;
		this.code = (byte)code;
	}
}
