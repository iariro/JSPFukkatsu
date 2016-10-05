package kumagai.Fukkatsu.struts2;

/**
 * インデックスと名前の対。
 * @author kumagai
 */
public class IndexAndName
{
	private int index;
	private String name;

	/**
	 * 指定の値を割り当てる。
	 * @param index インデックス
	 * @param name 名前
	 */
	public IndexAndName(int index, String name)
	{
		this.index = index;
		this.name = name;
	}

	/**
	 * インデックスを取得。
	 * @return インデックス
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * インデックスを割り当て。
	 * @param index インデックス
	 */
	public void setIndex(int index)
	{
		this.index = index;
	}

	/**
	 * 名前を取得。
	 * @return 名前
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 名前を割り当て。
	 * @param name 名前
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
