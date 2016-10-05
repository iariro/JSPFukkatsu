package kumagai.Fukkatsu.logic;

/**
 * 鎧情報。
 * @author kumagai
 */
public class Armor
{
	private ArmorName armor;

	/**
	 * オブジェクトの構築とともに鎧なしに設定。
	 */
	public Armor()
	{
		armor = ArmorName.なし;
	}

	/**
	 * 指定の鎧名をメンバーに割り当てる。
	 * @param armor 鎧名
	 */
	public Armor(ArmorName armor)
	{
		this.armor = armor;
	}

	/**
	 * 鎧名を取得。
	 * @return 鎧名
	 */
	public ArmorName getName()
	{
		return armor;
	}

	/**
	 * 鎧名を割り当て。
	 * @param value 鎧名
	 */
	public void setName(ArmorName value)
	{
		armor = value;
	}

	/**
	 * 鎧の番号を取得。
	 * @return 鎧の番号
	 */
	public byte getValue()
	{
		return (byte)armor.ordinal();
	}

	/**
	 * 鎧の番号を割り当て。
	 * @param value 鎧の番号
	 */
	public void setValue(int value)
	{
		armor = ArmorName.values()[value];
	}
}
