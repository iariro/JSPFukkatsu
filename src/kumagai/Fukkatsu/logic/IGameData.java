package kumagai.Fukkatsu.logic;

/**
 * ゲームデータとしてのインターフェイス。
 */
public interface IGameData
{
	/**
	 * プレイヤー名を取得。
	 * @return プレイヤー名
	 */
	PlayerName getName();

	/**
	 * プレイヤー名を割り当て。
	 * @param playerName プレイヤー名
	 */
	void setName(PlayerName playerName);

	/**
	 * 武器情報を取得。
	 * @return 武器情報
	 */
	Weapon getWeapon();

	/**
	 * 武器情報を割り当て。
	 * @param weapon 武器情報
	 */
	void setWeapon(Weapon weapon);

	/**
	 * 鎧情報を取得。
	 * @return 鎧情報
	 */
	Armor getArmor();

	/**
	 * 鎧情報を割り当て。
	 * @param armor 鎧情報
	 */
	void setArmor(Armor armor);

	/**
	 * 盾情報を取得。
	 * @return 盾情報
	 */
	Shield getShield();

	/**
	 * 盾情報を割り当て。
	 * @param shield 盾情報
	 */
	void setShield(Shield shield);

	/**
	 * アイテム情報を取得。
	 * @return アイテム情報
	 */
	Item [] getItem();

	/**
	 * アイテム情報を割り当て。
	 * @param items アイテム情報
	 */
	void setItem(Item [] items);

	/**
	 * 鍵情報を取得。
	 * @return 鍵情報
	 */
	int getKeyCount();

	/**
	 * 鍵情報を割り当て。
	 * @param key 鍵情報
	 */
	void setKeyCount(int key);

	/**
	 * 薬草情報を取得。
	 * @return 薬草情報
	 */
	int getYakusouCount();

	/**
	 * 薬草情報を割り当て。
	 * @param herb 薬草情報
	 */
	void setYakusouCount(int herb);

	/**
	 * 経験値を取得。
	 * @return 経験値
	 */
	Experience getExperience();

	/**
	 * 経験値を割り当て。
	 * @param experience 経験値
	 */
	void setExperience(Experience experience);

	/**
	 * 所持金を取得。
	 * @return 所持金
	 */
	int getGold();

	/**
	 * 所持金を割り当て。
	 * @param gold 所持金
	 */
	void setGold(int gold);

	/**
	 * “竜の鱗を装備”情報を取得。
	 * @return “竜の鱗を装備”情報
	 */
	boolean get竜のうろこを装備();

	/**
	 * “竜の鱗を装備”情報を割り当て。
	 * @param b “竜の鱗を装備”情報
	 */
	void set竜のうろこを装備(boolean b);

	/**
	 * “戦士の指輪を装備”情報を取得。
	 * @return “戦士の指輪を装備”情報
	 */
	boolean get戦士の指輪を装備();

	/**
	 * “戦士の指輪を装備”情報を割り当て。
	 * @param b “戦士の指輪を装備”情報
	 */
	void set戦士の指輪を装備(boolean b);

	/**
	 * “ドラゴンを倒した”情報を取得。
	 * @return “ドラゴンを倒した”情報
	 */
	boolean getドラゴンを倒した();

	/**
	 * “ドラゴンを倒した”情報を割り当て。
	 * @param b “ドラゴンを倒した”情報
	 */
	void setドラゴンを倒した(boolean b);

	/**
	 * “ゴーレムを倒した”情報を取得。
	 * @return “ゴーレムを倒した”情報
	 */
	boolean getゴーレムを倒した();

	/**
	 * “ゴーレムを倒した”情報を割り当て。
	 * @param b “ゴーレムを倒した”情報
	 */
	void setゴーレムを倒した(boolean b);

	/**
	 * “死の首飾りを入手”情報を取得。
	 * @return “死の首飾りを入手”情報
	 */
	boolean get死の首飾りを入手();

	/**
	 * “死の首飾りを入手”情報を割り当て。
	 * @param b “死の首飾りを入手”情報
	 */
	void set死の首飾りを入手(boolean b);

	/**
	 * バリエーション値を取得。
	 * @return バリエーション値
	 */
	byte getVariation();

	/**
	 * バリエーション値を割り当て。
	 * @param variation バリエーション値
	 */
	void setVariation(int variation);

	/**
	 * 正当性情報を取得。
	 * @return 正当性情報
	 */
	boolean getValid();

	/**
	 * 情報ダンプ。
	 * @return ダンプした文字列
	 */
	String dump();
}
