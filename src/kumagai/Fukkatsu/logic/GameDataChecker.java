package kumagai.Fukkatsu.logic;

import java.util.*;

/**
 * ゲームデータチェックオブジェクト。
 * @author kumagai
 */
public interface GameDataChecker
{
	static public GameDataChecker [] checkers =
	{
		new アイテム入手Checker()
	};

	/**
	 * アイテム入手チェック。
	 * @author kumagai
	 */
	class アイテム入手Checker
		implements GameDataChecker
	{
		public String[] checkAndCorrect(IGameData gameData)
		{
			ArrayList<String> errors = new ArrayList<String>();

			HashMap<ItemName, Integer> itemCount =
				new HashMap<ItemName, Integer>();

			for (Item item : gameData.getItem())
			{
				if (itemCount.containsKey(item.getName()))
				{
					// ２回目以降のアイテムである。

					itemCount.put(
						item.getName(),
						itemCount.get(item.getName()) + 1);
				}
				else
				{
					// 初出のアイテムである。

					itemCount.put(item.getName(), 1);
				}
			}

			ItemName [] cantDuplicateItems =
				new ItemName []
				{
					ItemName.ようせいのふえ,
					ItemName.ロトのしるし,
					ItemName.おうじょのあい,
					ItemName.ぎんのたてごと,
					ItemName.たいようのいし,
					ItemName.あまぐものつえ,
					ItemName.にじのしずく
				};

			for (ItemName name : cantDuplicateItems)
			{
				if (itemCount.containsKey(name))
				{
					// 持っている。

					if (itemCount.get(name) >= 2)
					{
						// ２個以上持っている。

						errors.add(
							String.format(
								"%sを%s個も持っています。",
								name,
								new NumberString(itemCount.get(name))));
					}
				}
			}

			if (!gameData.getゴーレムを倒した())
			{
				// ゴーレムを倒していない。

				if (gameData.getWeapon().getName() == WeaponName.ほのおのつるぎ)
				{
					// ゴーレムを倒さずにほのおのつるぎを手に入れている。

					errors.add("ゴーレムを倒さずにほのおのつるぎは手に入れられないはずです。ほのおのつるぎが手に入るメルキドに入るためにはゴーレムを倒す必要があるためです。");
				}

				if (gameData.getArmor().getName() == ArmorName.まほうのよろい)
				{
					// ゴーレムを倒さずにまほうのよろいを手に入れている。

					errors.add("ゴーレムを倒さずにまほうのよろいは手に入れられないはずです。まほうのよろいが手に入るメルキドに入るためにはゴーレムを倒す必要があるためです。");
				}

				if (gameData.getShield().getName() == ShieldName.みかがみのたて)
				{
					// ゴーレムを倒さずにみかがみのたてを手に入れている。

					errors.add("ゴーレムを倒さずにみかがみのたては手に入れられないはずです。みかがみのたてが手に入るメルキドに入るためにはゴーレムを倒す必要があるためです。");
				}
			}

			if (! itemCount.containsKey(ItemName.にじのしずく) &&
				gameData.getWeapon().getName() == WeaponName.ロトのつるぎ)
			{
				// にじのしずくを手に入れずにロトのつるぎを手に入れている。

				errors.add("にじのしずくを手に入れずにロトのつるぎは手に入れられないはずです。");
			}

			if (! gameData.getドラゴンを倒した() &&
				itemCount.containsKey(ItemName.おうじょのあい))
			{
				// ドラゴンを倒さずにおうじょのあいを手に入れている。

				errors.add("ドラゴンを倒さずにおうじょのあいは手に入れられないはずです。");
			}

			if (itemCount.containsKey(ItemName.ロトのしるし) &&
				! itemCount.containsKey(ItemName.おうじょのあい))
			{
				// おうじょのあいを手に入れずにロトのしるしを手に入れている。

				errors.add("おうじょのあいを手に入れずにロトのしるしを手に入れています。おうじょのあいがなくてもロトのしるしは手に入れられますが、おうじょのあい入手を省略すべきではありません。");
			}

			if (itemCount.containsKey(ItemName.にじのしずく) &&
				(!itemCount.containsKey(ItemName.あまぐものつえ) ||
				!itemCount.containsKey(ItemName.たいようのいし)))
			{
				// あまぐものつえ・たいようのいしを揃えずににじのしずくを手に入/
				// れている。

				errors.add("あまぐものつえ・たいようのいしを揃えずににじのしずくを手に入れています。");
			}

			return (String [])errors.toArray(new String [] {});
		}
	}

	/**
	 * チェックと訂正。
	 * @param gameData ゲームデータ
	 * @return エラーメッセージ
	 */
	String[] checkAndCorrect(IGameData gameData);
}
