package kumagai.Fukkatsu.logic;

/**
 * 呪文「ふるいけや...」を導き出すためのゲームデータ。
 */
public class YonhietaGameData
	extends GameDataBitArray
{
	/**
	 * フィールドを初期化。
	 */
	public YonhietaGameData()
	{
		setName(new PlayerName("４ひえた"));

		setGold(15143);

		Experience experience = new Experience(2898);
		setExperience(experience);

		setYakusouCount(4);
		setKeyCount(1);

		Weapon weapon = new Weapon();
		Armor armor = new Armor();
		Shield shield = new Shield();
		weapon.setName(WeaponName.こんぼう);
		armor.setName(ArmorName.くさりかたびら);
		shield.setName(ShieldName.なし);
		setWeapon(weapon);
		setArmor(armor);
		setShield(shield);

		Item [] item = new Item[8];

		for (int i=0 ; i<item.length ; i++)
		{
			item[i] = new Item();
		}

		item[1].setName(ItemName.ようせいのふえ);
		item[2].setName(ItemName.ロトのしるし);
		item[3].setName(ItemName.のろいのベルト);
		item[4].setName(ItemName.せいすい);
		item[5].setName(ItemName.ぎんのたてごと);
		item[6].setName(ItemName.たいようのいし);
		item[7].setName(ItemName.ようせいのふえ);
		setItem(item);

		set竜のうろこを装備(true);
		set戦士の指輪を装備(true);
		setドラゴンを倒した(false);
		setゴーレムを倒した(true);
		set死の首飾りを入手(false);
		setVariation(4);
	}
}
