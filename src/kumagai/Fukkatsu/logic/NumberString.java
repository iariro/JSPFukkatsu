package kumagai.Fukkatsu.logic;

/**
 * 全角数字文字列。
 */
public class NumberString
{
	private String str;

	/**
	 * 指定の数値を全角数字文字列化しオブジェクトを構築。
	 * @param num 数値
	 */
	public NumberString(int num)
	{
		str = new String();

		while (num > 0)
		{
			char c = (char)('０' + (num % 10));
			str = c + str;
			num /= 10;
		}
	}

	/**
	 * 全角数字文字列を取得。
	 * @return 全角数字文字列
	 */
	public String toString()
	{
		return str;
	}
}
