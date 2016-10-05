package kumagai.Fukkatsu.logic;

/**
 * 武器情報。
 */
public class Weapon
{
	private WeaponName weapon;

	/**
	 * オブジェクトの構築とともに武器なしに設定。
	 */
	public Weapon()
	{
		weapon = WeaponName.なし;
	}

	/**
	 * 指定の武器をメンバーに割り当てる。
	 * @param weapon 武器名
	 */
	public Weapon(WeaponName weapon)
	{
		this.weapon = weapon;
	}

	/**
	 * 武器名を取得。
	 * @return 武器名
	 */
	public WeaponName getName()
	{
		return (WeaponName)weapon;
	}

	/**
	 * 武器名を割り当て。
	 * @param value 武器名
	 */
	public void setName(WeaponName value)
	{
		 weapon = value;
	}

	/**
	 * 武器の番号を取得。
	 * @return 武器の番号
	 */
	public byte getValue()
	{
		return (byte)weapon.ordinal();
	}

	/**
	 * 武器の番号を割り当て。
	 * @param value 武器の番号
	 */
	public void setValue(int value)
	{
		weapon = WeaponName.values()[value];
	}
}
