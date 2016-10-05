package kumagai.Fukkatsu.logic;

/**
 * ゲームデータとしてのアクセッサを持ったバイト配列。
 */
public class GameDataBitArray
	extends BitArray
	implements IGameData
{
	private boolean valid;

	/**
	 * 基底クラスの初期化をしつつオブジェクトを構築。データ→呪文用。
	 */
	public GameDataBitArray()
	{
		super(8 * 14);
	}

	/**
	 * 呪文のコードデータからオブジェクトを構築。呪文→データ用。
	 * @param jumon 呪文コードデータ
	 */
	public GameDataBitArray(Jumon jumon)
	{
		this();

		// 6bit 毎の data[] を、8bit 毎の code[] に変換
		BitArray bitArray = new BitArray(8 * 15);

		for (int i=0 ; i<jumon.getCode().length ; i++)
		{
			bitArray.set(
				new BitPosition(6 * i),
				new BitArray(jumon.getCode()[i], 0, 6));
		}

		byte [] data8bit = bitArray.getByteArray(8);

		// 逆にする。
		data8bit = ArrayUtility.reverse(data8bit);

		valid = true;
		if (new BitArrayWithChecksum(data8bit).getChecksum() == 0)
		{
			// チェックサム OK。

			for (int i=0 ; i<data8bit.length - 1 ; i++)
			{
				set(new BitPosition(i, 0), new BitArray(data8bit[i], 0, 8));
			}

			if (! getValid())
			{
				// データは正しい。

				valid = false;
			}
		}
		else
		{
			// チェックサム NG。

			valid = false;
		}
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getName()
	 */
	public PlayerName getName()
	{
		PlayerName ret = new PlayerName();

		ret.set(0, getByte( 9, 2, 6));
		ret.set(1, getByte( 1, 1, 6));
		ret.set(2, getByte(12, 0, 6));
		ret.set(3, getByte( 7, 0, 6));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setName(kumagai.Fukkatsu.logic.PlayerName)
	 */
	public void setName(PlayerName value)
	{
		set(new BitPosition( 9, 2), new BitArray(value.get(0), 0, 6));
		set(new BitPosition( 1, 1), new BitArray(value.get(1), 0, 6));
		set(new BitPosition(12, 0), new BitArray(value.get(2), 0, 6));
		set(new BitPosition( 7, 0), new BitArray(value.get(3), 0, 6));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getWeapon()
	 */
	public Weapon getWeapon()
	{
		Weapon ret = new Weapon();

		ret.setValue(getByte(6, 5, 3));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setWeapon(kumagai.Fukkatsu.logic.Weapon)
	 */
	public void setWeapon(Weapon value)
	{
		set(new BitPosition( 6, 5), new BitArray(value.getValue(), 0, 3));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getArmor()
	 */
	public Armor getArmor()
	{
		Armor ret = new Armor();

		ret.setValue(getByte(6, 2, 3));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setArmor(kumagai.Fukkatsu.logic.Armor)
	 */
	public void setArmor(Armor value)
	{
		set(new BitPosition( 6, 2), new BitArray(value.getValue(), 0, 3));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getShield()
	 */
	public Shield getShield()
	{
		Shield ret = new Shield();

		ret.setValue(getByte(6, 0, 2));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setShield(kumagai.Fukkatsu.logic.Shield)
	 */
	public void setShield(Shield value)
	{
		set(new BitPosition( 6, 0), new BitArray(value.getValue(), 0, 2));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getItem()
	 */
	public Item [] getItem()
	{
		Item [] ret = new Item [8];

		for (int i=0 ; i<ret.length ; i++)
		{
			ret[i] = new Item();
		}

		ret[0].setValue(getByte( 0, 0, 4));
		ret[1].setValue(getByte( 0, 4, 4));
		ret[2].setValue(getByte(11, 0, 4));
		ret[3].setValue(getByte(11, 4, 4));
		ret[4].setValue(getByte( 3, 0, 4));
		ret[5].setValue(getByte( 3, 4, 4));
		ret[6].setValue(getByte( 8, 0, 4));
		ret[7].setValue(getByte( 8, 4, 4));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setItem(kumagai.Fukkatsu.logic.Item[])
	 */
	public void setItem(Item [] value)
	{
		set(new BitPosition( 0, 0), new BitArray(value[0].getValue(), 0, 4));
		set(new BitPosition( 0, 4), new BitArray(value[1].getValue(), 0, 4));
		set(new BitPosition(11, 0), new BitArray(value[2].getValue(), 0, 4));
		set(new BitPosition(11, 4), new BitArray(value[3].getValue(), 0, 4));
		set(new BitPosition( 3, 0), new BitArray(value[4].getValue(), 0, 4));
		set(new BitPosition( 3, 4), new BitArray(value[5].getValue(), 0, 4));
		set(new BitPosition( 8, 0), new BitArray(value[6].getValue(), 0, 4));
		set(new BitPosition( 8, 4), new BitArray(value[7].getValue(), 0, 4));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getKeyCount()
	 */
	public int getKeyCount()
	{
		return getByte(4, 4, 4);
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setKeyCount(int)
	 */
	public void setKeyCount(int value)
	{
		set(new BitPosition( 4, 4), new BitArray(value, 0, 4));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getYakusouCount()
	 */
	public int getYakusouCount()
	{
		return getByte(4, 0, 4);
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setYakusouCount(int)
	 */
	public void setYakusouCount(int value)
	{
		set(new BitPosition( 4, 0), new BitArray(value, 0, 4));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getExperience()
	 */
	public Experience getExperience()
	{
		Experience ret = new Experience();

		ret.setValue(getByte(2, 0, 8) * 0x100 + getByte(13, 0, 8));

		return ret;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setExperience(kumagai.Fukkatsu.logic.Experience)
	 */
	public void setExperience(Experience value)
	{
		set(new BitPosition(13, 0), new BitArray(value.getValue(), 0, 8));
		set(new BitPosition( 2, 0), new BitArray(value.getValue(), 8, 8));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getGold()
	 */
	public int getGold()
	{
		return getByte(5, 0, 8) * 0x100 + getByte(10,0, 8);
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setGold(int)
	 */
	public void setGold(int value)
	{
		set(new BitPosition(10, 0), new BitArray(value, 0, 8));
		set(new BitPosition( 5, 0), new BitArray(value, 8, 8));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#get竜のうろこを装備()
	 */
	public boolean get竜のうろこを装備()
	{
		return getBitValue()[8 * 1 + 7];
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#set竜のうろこを装備(boolean)
	 */
	public void set竜のうろこを装備(boolean value)
	{
		set(new BitPosition( 1, 7), new BitArray(value));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#get戦士の指輪を装備()
	 */
	public boolean get戦士の指輪を装備()
	{
		return getBitValue()[8 * 1];
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#set戦士の指輪を装備(boolean)
	 */
	public void set戦士の指輪を装備(boolean value)
	{
		set(new BitPosition( 1, 0), new BitArray(value));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getドラゴンを倒した()
	 */
	public boolean getドラゴンを倒した()
	{
		return getBitValue()[8 * 7 + 6];
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setドラゴンを倒した(boolean)
	 */
	public void setドラゴンを倒した(boolean value)
	{
		set(new BitPosition( 7, 6), new BitArray(value));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getゴーレムを倒した()
	 */
	public boolean getゴーレムを倒した()
	{
		return getBitValue()[8 * 9 + 1];
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setゴーレムを倒した(boolean)
	 */
	public void setゴーレムを倒した(boolean value)
	{
		set(new BitPosition( 9, 1), new BitArray(value));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#get死の首飾りを入手()
	 */
	public boolean get死の首飾りを入手()
	{
		return getBitValue()[8 * 12 + 6];
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#set死の首飾りを入手(boolean)
	 */
	public void set死の首飾りを入手(boolean value)
	{
		set(new BitPosition(12, 6), new BitArray(value));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getVariation()
	 */
	public byte getVariation()
	{
		return
			(byte)(
				(getByte( 7, 7, 1) * 0x04) |
				(getByte( 9, 0, 1) * 0x02) |
				(getByte(12, 7, 1)));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#setVariation(int)
	 */
	public void setVariation(int value)
	{
		set(new BitPosition(12, 7), new BitArray(value, 0, 1));
		set(new BitPosition( 9, 0), new BitArray(value, 1, 1));
		set(new BitPosition( 7, 7), new BitArray(value, 2, 1));
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#getValid()
	 */
	public boolean getValid()
	{
		return valid && getYakusouCount() <= 6 && getKeyCount() <= 6;
	}

	/**
	 * @see kumagai.Fukkatsu.logic.IGameData#dump()
	 */
	public String dump()
	{
		String ret =  "名前：" + getName().getText() + "\n";
		ret += "武器：" + getWeapon().getName() + "\n";
		ret += "鎧：" + getArmor().getName() + "\n";
		ret += "盾：" + getShield().getName() + "\n";

		for (int i=0 ; i<getItem().length ; i++)
		{
			ret += getItem()[i].getName() + "\n";
		}

		ret += "鍵：" + getKeyCount() + "\n";
		ret += "薬草：" + getYakusouCount() + "\n";
		ret += "経験値：" + getExperience().getValue() + "\n";
		ret += "ゴールド：" + getGold() + "\n";
		ret += "竜の鱗を装備：" + get竜のうろこを装備() + "\n";
		ret += "戦士の指輪を装備：" + get戦士の指輪を装備() + "\n";
		ret += "ドラゴンを倒した：" + getドラゴンを倒した() + "\n";
		ret += "ゴーレムを倒した：" + getゴーレムを倒した() + "\n";
		ret += "死の首飾りを入手：" + get死の首飾りを入手() + "\n";
		ret += "CRC：" + getVariation() + "\n";

		return ret;
	}
}
