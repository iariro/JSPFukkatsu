package kumagai.Fukkatsu.logic;

/**
 * 盾情報。
 */
public class Shield
{
	private ShieldName shield;

	/**
	 * オブジェクトの構築とともに盾なしに設定。
	 */
	public Shield()
	{
		shield = ShieldName.なし;
	}

	/**
	 * 指定の盾名をメンバーに割り当てる。
	 * @param shield 盾名
	 */
	public Shield(ShieldName shield)
	{
		this.shield = shield;
	}

	/**
	 * 盾名を取得。
	 * @return 盾名
	 */
	public ShieldName getName()
	{
		return shield;
	}

	/**
	 * 盾名を割り当て。
	 * @param value 盾名
	 */
	public void setName(ShieldName value)
	{
		shield = value;
	}

	/**
	 * 盾の番号を取得。
	 * @return 盾の番号
	 */
	public byte getValue()
	{
		return (byte)shield.ordinal();
	}

	/**
	 * 盾の番号を割り当て。
	 * @param value 盾の番号
	 */
	public void setValue(int value)
	{
		shield = ShieldName.values()[value];
	}
}
