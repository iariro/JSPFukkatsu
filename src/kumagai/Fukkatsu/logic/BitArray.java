package kumagai.Fukkatsu.logic;

/**
 * 指定ビット数ごとにバイト配列か可能なビット配列。
 * @author kumagai
 */
public class BitArray
{
	protected boolean [] bits;

	/**
	 * ビット配列。
	 * @return ビット配列
	 */
	public boolean [] getBitValue()
	{
		return bits;
	}

	/**
	 * 指定ビット数の配列を初期化しつつオブジェクトを構築。
	 * @param size 配列サイズ
	 */
	public BitArray(int size)
	{
		bits = new boolean [size];
	}

	/**
	 * 指定の１ビットのみのデータを内容とするオブジェクトを構築。
	 * @param value １ビットのデータ
	 */
	public BitArray(boolean value)
	{
		bits = new boolean [1];

		bits[0] = value;
	}

	/**
	 * 指定のバイト配列を内容とするオブジェクトを構築。
	 * @param value バイト配列
	 */
	public BitArray(byte [] value)
	{
		bits = new boolean [8 * value.length];

		for (int i=0 ; i<value.length ; i++)
		{
			for (int j=0 ; j<8 ; j++)
			{
				bits[8 * i + j] = (value[i] & (0x01 << j)) != 0x00;
			}
		}
	}

	/**
	 * 指定のバイト値の一部分を内容とするオブジェクトを構築。
	 * @param value バイト値
	 * @param position 対象となるバイト値の開始位置
	 * @param size ビットサイズ
	 */
	public BitArray(byte value, int position, int size)
	{
		bits = new boolean [size];

		value >>= position;

		for (int i=0 ; i<size ; i++)
		{
			bits[i] = (value & 0x01) != 0x00;
			value >>= 1;
		}
	}

	/**
	 * 指定のショート値の一部分を内容とするオブジェクトを構築。
	 * @param value ショート値
	 * @param position 対象となるショート値の開始位置
	 * @param size ビットサイズ
	 */
	public BitArray(int value, int position, int size)
	{
		bits = new boolean [size];

		value >>= position;

		for (int i=0 ; i<size ; i++)
		{
			bits[i] = (value & 0x01) != 0x00;
			value >>= 1;
		}
	}

	/**
	 * 別の BitArray オブジェクトを指定位置にセット。
	 * @param position セットを行う位置
	 * @param bitArray2 セットを行うビット配列
	 */
	public void set(BitPosition position, BitArray bitArray2)
	{
		for (int i=0 ; i<bitArray2.getBitValue().length ; i++)
		{
			bits[position.position + i] = bitArray2.getBitValue()[i];
		}
	}

	/**
	 * バイト値として内容を取得。
	 * @param bytePosition バイトアドレス
	 * @param bitPosition ビット位置
	 * @param width
	 * @return 取得したバイト値
	 */
	public int getByte(int bytePosition, int bitPosition, int width)
	{
		int ret = 0;

		for (int i=0 ; i<width ; i++)
		{
			ret |=
				(int)(bits[8 * bytePosition + bitPosition + i] ?
				(0x01 << i) : 0);
		}

		return ret;
	}

	/**
	 * 内容を指定ビット幅のバイト配列として取得。
	 * @param size ビット幅
	 * @return 取得したバイト配列
	 */
	public byte [] getByteArray(int size)
	{
		byte [] ret = new byte [bits.length/size];

		for (int i=0 ; i<bits.length/size ; i++)
		{
			ret[i] = 0;

			for (int j=0 ; j<size ; j++)
			{
				ret[i] |= (byte)(bits[size * i + j] ? (0x01 << j) : 0);
			}
		}

		return ret;
	}
}
