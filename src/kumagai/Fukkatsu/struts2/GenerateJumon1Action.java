package kumagai.Fukkatsu.struts2;

import org.apache.struts2.convention.annotation.*;
import kumagai.Fukkatsu.logic.*;

/**
 * ゲームデータ編集画面表示アクション。
 * @author kumagai
 */
@Namespace("/fukkatsu")
@Result(name="success", location="/fukkatsu/generatejumon1.jsp")
public class GenerateJumon1Action
{
	public IndexAndName [] items;
	public IndexAndName [] weapons;
	public IndexAndName [] armors;
	public IndexAndName [] shields;

	/**
	 * ゲームデータ編集画面表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("generatejumon1")
	public String execute()
    	throws Exception
	{
		// アイテムリスト作成。
		ItemName [] itemName = ItemName.values();
		items = new IndexAndName [itemName.length];

		for (int i=0 ; i<itemName.length ; i++)
		{
			items[i] = new IndexAndName(i, itemName[i].name());
		}

		// 武器リスト作成。
		WeaponName [] weaponName = WeaponName.values();
		weapons = new IndexAndName [weaponName.length];

		for (int i=0 ; i<weaponName.length ; i++)
		{
			weapons[i] = new IndexAndName(i, weaponName[i].name());
		}

		// 鎧リスト作成。
		ArmorName [] armorName = ArmorName.values();
		armors = new IndexAndName [armorName.length];

		for (int i=0 ; i<armorName.length ; i++)
		{
			armors[i] = new IndexAndName(i, armorName[i].name());
		}

		// 盾リスト作成。
		ShieldName [] shieldName = ShieldName.values();
		shields = new IndexAndName [shieldName.length];

		for (int i=0 ; i<shieldName.length ; i++)
		{
			shields[i] = new IndexAndName(i, shieldName[i].name());
		}

		return "success";
	}
}
