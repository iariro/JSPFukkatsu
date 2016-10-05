package kumagai.Fukkatsu.struts2;

import java.util.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.Fukkatsu.logic.*;

/**
 * 復活の呪文生成アクション。
 * @author kumagai
 */
@Namespace("/fukkatsu")
@Results
({
	@Result(name="normal", location="/fukkatsu/generatejumon2.jsp"),
	@Result(name="ryuuou", location="/fukkatsu/generatejumon2ryuuou.jsp")
})
public class GenerateJumon2Action
{
	public String name;
	public int variation;
	public String gold;
	public String experience;
	public int level;
	public int yakusouCount;
	public int keyCount;
	public int [] item = new int [8];
	public int weapon;
	public int armor;
	public int shield;
	public String ryuunoUroko;
	public String senshiNoYubiwa;
	public String dragonTaoshita;
	public String gooremuTaoshita;
	public String shiNoKubikazari;

	public int jumonStyle;
	public String [] jumonString;
	public String [] errors;
	public int errorsLength;

	/**
	 * アイテム１を割り当て。
	 * @param item アイテム１
	 */
	public void setItem1(String item)
	{
		this.item[0] = Integer.valueOf(item);
	}

	/**
	 * アイテム２を割り当て。
	 * @param item アイテム２
	 */
	public void setItem2(String item)
	{
		this.item[1] = Integer.valueOf(item);
	}

	/**
	 * アイテム３を割り当て。
	 * @param item アイテム３
	 */
	public void setItem3(String item)
	{
		this.item[2] = Integer.valueOf(item);
	}

	/**
	 * アイテム４を割り当て。
	 * @param item アイテム４
	 */
	public void setItem4(String item)
	{
		this.item[3] = Integer.valueOf(item);
	}

	/**
	 * アイテム５を割り当て。
	 * @param item アイテム５
	 */
	public void setItem5(String item)
	{
		this.item[4] = Integer.valueOf(item);
	}

	/**
	 * アイテム６を割り当て。
	 * @param item アイテム６
	 */
	public void setItem6(String item)
	{
		this.item[5] = Integer.valueOf(item);
	}

	/**
	 * アイテム７を割り当て。
	 * @param item アイテム７
	 */
	public void setItem7(String item)
	{
		this.item[6] = Integer.valueOf(item);
	}

	/**
	 * アイテム８を割り当て。
	 * @param item アイテム８
	 */
	public void setItem8(String item)
	{
		this.item[7] = Integer.valueOf(item);
	}

	/**
	 * 呪文解析。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("generatejumon2")
    public String execute()
    	throws Exception
	{
		ArrayList<String> errors = new ArrayList<String>();

		for (GenerateJumonFormChecker checker :
			GenerateJumonFormChecker.checkers)
		{
			String error = checker.checkAndCorrect(this);

			if (error != null)
			{
				// エラーあり。

				errors.add(error);
			}
		}

		GameDataBitArray gameData = new GameDataBitArray();

		gameData.setName(new PlayerName(name));
		gameData.setVariation(variation);

		if (jumonStyle != 2)
		{
			// 竜王のせりふ形式ではない場合。

			gameData.setGold(Integer.valueOf(gold));
			gameData.setExperience(new Experience(Integer.valueOf(experience)));
			gameData.setYakusouCount(yakusouCount);
			gameData.setKeyCount(keyCount);

			Item [] items = new Item [8];
			for (int i=0 ; i<items.length ; i++)
			{
				items[i] = new Item(ItemName.values()[item[i]]);
			}
			gameData.setItem(items);

			gameData.setWeapon(new Weapon(WeaponName.values()[weapon]));
			gameData.setArmor(new Armor(ArmorName.values()[armor]));
			gameData.setShield(new Shield(ShieldName.values()[shield]));

			gameData.set竜のうろこを装備(ryuunoUroko != null);
			gameData.set戦士の指輪を装備(senshiNoYubiwa != null);
			gameData.setドラゴンを倒した(dragonTaoshita != null);
			gameData.setゴーレムを倒した(gooremuTaoshita != null);
			gameData.set死の首飾りを入手(shiNoKubikazari != null);
		}

		level = gameData.getExperience().getLevel();

		Jumon jumon = new Jumon(gameData);

		String jumonString;

		switch (jumonStyle)
		{
			case 0:
				jumonString = jumon.getString();
				break;

			case 1:
				jumonString = jumon.getJumonAsKingSerifu();
				break;

			case 2:
				jumonString = jumon.getJumonAsRyuuouSerifu();
				break;

			default:
				throw new Exception();
		}

		for (GameDataChecker gameDataChecker : GameDataChecker.checkers)
		{
			String [] errors2 = gameDataChecker.checkAndCorrect(gameData);

			if (errors2 != null)
			{
				// エラーあり。

				for (String error : errors2)
				{
					errors.add(error);
				}
			}
		}

		this.jumonString = jumonString.split("\n");
		this.errors = (String [])errors.toArray(new String [0]);
		this.errorsLength = this.errors.length;

		if (jumonStyle != 2)
		{
			// 竜王以外。

			return "normal";
		}
		else
		{
			// 竜王。

			return "ryuuou";
		}
	}
}
