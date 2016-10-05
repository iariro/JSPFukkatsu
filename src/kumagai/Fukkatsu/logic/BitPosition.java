package kumagai.Fukkatsu.logic;

/**
 * ビット位置。
 * @author kumagai
 */
public class BitPosition
{
	public int position;

	/**
	 * 単純なビット位置指定によりオブジェクトを構築。
	 * @param position ビット位置
	 */
	public BitPosition(int position)
	{
		this.position = position;
	}

	/**
	 * バイト，ビット位置指定によりオブジェクトを構築。
	 * @param bytePosition バイト位置
	 * @param bitPosition ビット位置
	 */
	public BitPosition(int bytePosition, int bitPosition)
	{
		this.position = 8 * bytePosition + bitPosition;
	}
}
