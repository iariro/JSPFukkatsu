package kumagai.Fukkatsu.struts2;

/**
 * 復活の呪文生成アクション用フォームのチェックオブジェクト。
 * @author kumagai
 */
public interface GenerateJumonFormChecker
{
	static public final GenerateJumonFormChecker [] checkers =
	{
		new NameChecker(),
		new GoldChecker(),
		new ExperienceChecker()
	};

	/**
	 * 名前チェック。
	 * @author kumagai
	 */
	class NameChecker
		implements GenerateJumonFormChecker
	{
		/**
		 * @see kumagai.Fukkatsu.struts2.GenerateJumonFormChecker#checkAndCorrect(kumagai.Fukkatsu.struts2.GenerateJumon2Action)
		 */
		public String checkAndCorrect(GenerateJumon2Action form)
		{
			if (form.name.length() > 4)
			{
				// 名前が長過ぎる。

				String before = form.name;

				form.name = before.substring(0, 4);

				return
					String.format(
						"名前%sが不正です。%sを割り当てました。",
						before,
						form.name);
			}

			return null;
		}
	}

	/**
	 * ゴールド欄チェッカー。
	 * @author kumagai
	 */
	class GoldChecker
		implements GenerateJumonFormChecker
	{
		/**
		 * @see kumagai.Fukkatsu.struts2.GenerateJumonFormChecker#checkAndCorrect(kumagai.Fukkatsu.struts2.GenerateJumon2Action)
		 */
		public String checkAndCorrect(GenerateJumon2Action form)
		{
			try
			{
				int gold = Integer.valueOf(form.gold);

				if (gold < 0 || gold > 65535)
				{
					// ゴールドが範囲外。

					if (gold < 0)
					{
						// ゴールドが負の値。

						form.gold = "0";
					}

					if (gold > 65535)
					{
						// ゴールドが限界を越えている。

						form.gold = "65535";
					}

					return
						String.format(
							"ゴールド%dが範囲外です。%sに調整しました。",
							gold,
							form.gold);
				}
			}
			catch (NumberFormatException exception)
			{
				String before = form.gold;

				form.gold = "0";

				return
					String.format(
						"ゴールド%sが不正です。0を割り当てました。",
						before);
			}

			return null;
		}
	}

	/**
	 * 経験値チェック。
	 * @author kumagai
	 */
	class ExperienceChecker
		implements GenerateJumonFormChecker
	{
		/**
		 * @see kumagai.Fukkatsu.struts2.GenerateJumonFormChecker#checkAndCorrect(kumagai.Fukkatsu.struts2.GenerateJumon2Action)
		 */
		public String checkAndCorrect(GenerateJumon2Action form)
		{
			try
			{
				int experience = Integer.valueOf(form.experience);

				if (experience < 0 || experience > 65535)
				{
					// 経験値が範囲外。

					if (experience < 0)
					{
						// 経験値が負の値。

						form.experience = "0";
					}

					if (experience > 65535)
					{
						// 経験値が限界を越えている。

						form.experience = "65535";
					}

					return
						String.format(
							"経験値%dが範囲外です。%sに調整しました。",
							experience,
							form.experience);
				}
			}
			catch (NumberFormatException exception)
			{
				String before = form.experience;

				form.experience = "0";

				return
					String.format(
						"経験値%sが不正です。0を割り当てました。",
						before);
			}

			return null;
		}
	}

	/**
	 * チェックと訂正処理。
	 * @param form フォームオブジェクト
	 * @return エラーメッセージ文字列
	 */
	String checkAndCorrect(GenerateJumon2Action form);
}
