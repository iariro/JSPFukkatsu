package kumagai.Fukkatsu.struts2;

import org.apache.struts2.convention.annotation.*;
import kumagai.Fukkatsu.logic.*;

/**
 * 呪文解析結果表示アクション。
 * @author kumagai
 */
@Namespace("/fukkatsu")
@Result(name="success", location="/fukkatsu/analyzejumon2.jsp")
public class AnalyzeJumon2Action
{
	public boolean valid;
	public String jumon;
	public String name;
	public int variation;
	public int gold;
	public int experience;
	public int level;
	public int yakusouCount;
	public int keyCount;
	public String [] items;
	public String weapon;
	public String armor;
	public String shield;
	public String 竜のうろこを装備;
	public String 戦士の指輪装備;
	public String ドラゴンを倒した;
	public String ゴーレムを倒した;
	public String 死の首飾りを入手;

	/**
	 * 呪文解析。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("analyzejumon2")
    public String execute()
    	throws Exception
	{
		Jumon jumon = new Jumon(this.jumon);

		GameDataBitArray gamedata = new GameDataBitArray(jumon);

		valid = gamedata.getValid();

		name = gamedata.getName().getText();
		variation = gamedata.getVariation();
		gold = gamedata.getGold();
		experience = gamedata.getExperience().getValue();
		level = gamedata.getExperience().getLevel();
		yakusouCount = gamedata.getYakusouCount();
		keyCount = gamedata.getKeyCount();

		items = new String [8];

		for (int i=0 ; i<8 ; i++)
		{
			items[i] = gamedata.getItem()[i].getName().name();
		}

		weapon = gamedata.getWeapon().getName().name();
		armor = gamedata.getArmor().getName().name();
		shield = gamedata.getShield().getName().name();

		竜のうろこを装備 =
			gamedata.get竜のうろこを装備() ? "している" : "していない";
		戦士の指輪装備 =
			gamedata.get戦士の指輪を装備() ? "している" : "していない";
		ドラゴンを倒した =
			gamedata.getドラゴンを倒した() ? "倒している" : "倒していない";
		ゴーレムを倒した =
			gamedata.getゴーレムを倒した() ? "倒している" : "倒していない";
		死の首飾りを入手 =
			gamedata.get死の首飾りを入手() ? "している" : "していない";

		return "success";
	}
}
