package kumagai.Fukkatsu.logic;

/**
 * 呪文「まるかつは...」を導き出すためのゲームデータ。
 */
public class YonkinehachiGameData
	extends GameDataBitArray
{
	/**
	 * フィールドを初期化。
	 */
	public YonkinehachiGameData()
	{
		setName(new PlayerName("４きね８"));

		setGold(64673);

		Experience experience = new Experience(31377);
		setExperience(experience);

		setYakusouCount(2);
		setKeyCount(2);
		setVariation(0);

		setWeapon(new Weapon(WeaponName.ロトのつるぎ));
		setArmor(new Armor(ArmorName.なし));
		setShield(new Shield(ShieldName.みかがみのたて));

		Item [] item = new Item[8];

		item[0] = new Item(ItemName.あまぐものつえ);
		item[1] = new Item(ItemName.ぎんのたてごと);
		item[2] = new Item(ItemName.りゅうのうろこ);
		item[3] = new Item(ItemName.おうじょのあい);
		item[4] = new Item(ItemName.にじのしずく);
		item[5] = new Item(ItemName.ようせいのふえ);
		item[6] = new Item(ItemName.ぎんのたてごと);
		item[7] = new Item(ItemName.おうじょのあい);

		setItem(item);

		set竜のうろこを装備(true);
		set戦士の指輪を装備(true);
		setドラゴンを倒した(true);
		setゴーレムを倒した(true);
		set死の首飾りを入手(false);
	}
}
