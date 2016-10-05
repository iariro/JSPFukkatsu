package kumagai.Fukkatsu.logic;

/**
 * 経験値情報。
 */
public class Experience
{
	/**
	 * レベルごとの経験値。
	 */
	static private int [] levelPoint =
	{
			0,	  7,   23,	 47,  110,	220,  450,	800, 1300, 2000,
		 2900, 4000, 5500, 7500,10000,13000,17000,21000,25000,29000,
		33000,37000,41000,45000,49000,53000,57000,61000,65000,65535
	};

	/**
	 * 最大ポイントを取得。
	 * @return 最大ポイント
	 */
	static public int getMax()
	{
		return levelPoint[levelPoint.length - 1];
	}

	private int experience;

	/**
	 * 既定のコンストラクタ。
	 */
	public Experience()
	{
		// 何もしない。
	}

	/**
	 * 値をメンバーに割り当てる。
	 * @param experience 経験値
	 */
	public Experience(int experience)
	{
		this.experience = experience;
	}

	/**
	 * 経験値を取得。
	 * @return 経験値
	 */
	public int getValue()
	{
		return experience;
	}

	/**
	 * 経験値を割り当て。
	 * @param value 経験値
	 */
	public void setValue(int value)
	{
		experience = value;
	}

	/**
	 * レベルを取得。
	 * @return レベル
	 */
	public int getLevel()
	{
		int i;

		for (i=0 ; i<levelPoint.length && experience >= levelPoint[i] ; i++)
		{
		}

		return i;
	}

	/**
	 * 次のレベルまでに必要なポイントを取得。
	 * @return 次のレベルまでに必要なポイント
	 */
	public int getForNextLevel()
	{
		return levelPoint[getLevel()] - experience;
	}
}
