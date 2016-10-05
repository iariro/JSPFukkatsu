package kumagai.Fukkatsu.logic;

/**
 * 隣り合う値の差分を利用した暗号化配列。
 */
abstract class CryptByteArray
{
	protected byte [] data6bit;

	/**
	 * 平文バイト配列の値を取得。
	 * @param i インデックス値
	 * @return 平文バイト値
	 */
	public byte get(int i)
	{
		return data6bit[i];
	}

	/**
	 * 平文バイト配列の値を割り当て。
	 * @param i インデックス値
	 * @param value 平文バイト値
	 */
	public void set(int i, byte value)
	{
		data6bit[i] = value;
	}

	/**
	 * 平文バイト配列を取得。
	 * @return 平文バイト配列
	 */
	public byte [] getArray()
	{
		return data6bit;
	}

	/**
	 * 暗号化する。
	 * @return 暗号化したバイト配列
	 */
	public byte [] encrypt()
	{
		byte [] ret = new byte [20];

		byte w = 0;

		// 4 を足しデータを累計していく。
		for (int i=0 ; i<20 ; i++)
		{
			ret[i] = (byte)((data6bit[i] + w + 4) & 0x3f);
			w = ret[i];
		}

		return ret;
	}
}
