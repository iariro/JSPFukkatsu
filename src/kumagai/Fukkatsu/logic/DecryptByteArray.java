package kumagai.Fukkatsu.logic;

/**
 * 復号化用バイト配列。
 */
class DecryptByteArray
	extends CryptByteArray
{
	/**
	 * 指定の暗号の復号化を行いオブジェクトを構築。
	 * @param data6bit 文字コード２０文字分
	 */
	public DecryptByteArray(byte [] data6bit)
	{
		this.data6bit = new byte[20];

		for (int i=0 ; i<data6bit.length ; i++)
		{
			this.data6bit[i] = data6bit[i];
		}

		// 4 を引き、前後の文字の差分を取る。
		for (int i=19 ; i>=1 ; i--)
		{
			this.data6bit[i] =
				(byte)((this.data6bit[i] - this.data6bit[i - 1] - 4) & 0x3f);
		}

		this.data6bit[0] = (byte)((this.data6bit[0] - 4) & 0x3f);
	}
}