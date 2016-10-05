package kumagai.Fukkatsu.logic;

/**
 * 配列ユーティリティ。
 * @author kumagai
 */
public class ArrayUtility
{
	/**
	 * 内容を逆順にして返却。
	 * @param value 対象の配列
	 * @return 逆順にした配列
	 */
	static byte [] reverse(byte [] value)
	{
		byte [] ret = new byte [value.length];

		for (int i=0 ;i<value.length ; i++)
		{
			ret[i] = value[value.length - i - 1];
		}

		return ret;
	}
}
