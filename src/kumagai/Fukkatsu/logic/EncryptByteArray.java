package kumagai.Fukkatsu.logic;

/**
 * 暗号化用。
 */
class EncryptByteArray
	extends CryptByteArray
{
	/**
	 * 平文データを単純にコピーしオブジェクトを構築。
	 * @param data6bit 平文データ
	 */
	public EncryptByteArray(byte [] data6bit)
	{
		this.data6bit = data6bit;
	}
}
