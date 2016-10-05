package kumagai.Fukkatsu.logic;

/**
 * アイテム情報。
 */
public class Item
{
	private ItemName item;

	/**
	 * オブジェクトの構築とともにアイテムなしに設定
	 */
	public Item()
	{
		item = ItemName.なし;
	}

	/**
	 * オブジェクトの構築とともに指定のアイテムをメンバーに設定
	 * @param item アイテム名
	 */
	public Item(ItemName item)
	{
		this.item = item;
	}

	/**
	 * アイテム名を取得。
	 * @return アイテム名
	 */
	public ItemName getName()
	{
		return (ItemName)item;
	}

	/**
	 * アイテム名を割り当て。
	 * @param value アイテム名
	 */
	public void setName(ItemName value)
	{
		item = value;
	}

	/**
	 * アイテム番号を取得。
	 * @return アイテム番号
	 */
	public byte getValue()
	{
		return (byte)item.ordinal();
	}

	/**
	 * アイテム番号を割り当て。
	 * @param value アイテム番号
	 */
	public void setValue(int value)
	{
		item = ItemName.values()[value];
	}
}
