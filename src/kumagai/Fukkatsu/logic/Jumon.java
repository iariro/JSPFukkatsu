package kumagai.Fukkatsu.logic;

import java.util.*;

/**
 * 呪文文字列情報。平文バイト配列を内部表現とする。
 */
public class Jumon
{
	static private CharAndCode [] charAndCodes =
	{
		new CharAndCode('あ', 0),
		new CharAndCode('い', 1),
		new CharAndCode('う', 2),
		new CharAndCode('え', 3),
		new CharAndCode('お', 4),
		new CharAndCode('か', 5),
		new CharAndCode('き', 6),
		new CharAndCode('く', 7),
		new CharAndCode('け', 8),
		new CharAndCode('こ', 9),
		new CharAndCode('さ', 10),
		new CharAndCode('し', 11),
		new CharAndCode('す', 12),
		new CharAndCode('せ', 13),
		new CharAndCode('そ', 14),
		new CharAndCode('た', 15),
		new CharAndCode('ち', 16),
		new CharAndCode('つ', 17),
		new CharAndCode('て', 18),
		new CharAndCode('と', 19),
		new CharAndCode('な', 20),
		new CharAndCode('に', 21),
		new CharAndCode('ぬ', 22),
		new CharAndCode('ね', 23),
		new CharAndCode('の', 24),
		new CharAndCode('は', 25),
		new CharAndCode('ひ', 26),
		new CharAndCode('ふ', 27),
		new CharAndCode('へ', 28),
		new CharAndCode('ほ', 29),
		new CharAndCode('ま', 30),
		new CharAndCode('み', 31),
		new CharAndCode('む', 32),
		new CharAndCode('め', 33),
		new CharAndCode('も', 34),
		new CharAndCode('や', 35),
		new CharAndCode('ゆ', 36),
		new CharAndCode('よ', 37),
		new CharAndCode('ら', 38),
		new CharAndCode('り', 39),
		new CharAndCode('る', 40),
		new CharAndCode('れ', 41),
		new CharAndCode('ろ', 42),
		new CharAndCode('わ', 43),
		new CharAndCode('が', 44),
		new CharAndCode('ぎ', 45),
		new CharAndCode('ぐ', 46),
		new CharAndCode('げ', 47),
		new CharAndCode('ご', 48),
		new CharAndCode('ざ', 49),
		new CharAndCode('じ', 50),
		new CharAndCode('ず', 51),
		new CharAndCode('ぜ', 52),
		new CharAndCode('ぞ', 53),
		new CharAndCode('だ', 54),
		new CharAndCode('ぢ', 55),
		new CharAndCode('づ', 56),
		new CharAndCode('で', 57),
		new CharAndCode('ど', 58),
		new CharAndCode('ば', 59),
		new CharAndCode('び', 60),
		new CharAndCode('ぶ', 61),
		new CharAndCode('べ', 62),
		new CharAndCode('ぼ', 63)
	};

	/**
	 * 文字→文字コード変換テーブル
	 */
	static private HashMap<Byte, Character> codeToCharacterTable;

	/**
	 * 文字コード→文字変換テーブル
	 */
	static private HashMap<Character, Byte> characterToCodeTable;

	/**
	 * 文字・コード変換テーブルを初期化。
	 */
	static
	{
		codeToCharacterTable = new HashMap<Byte, Character>();
		characterToCodeTable = new HashMap<Character, Byte>();

		for (CharAndCode charAndCode : charAndCodes)
		{
			codeToCharacterTable.put(charAndCode.code, charAndCode.character);
			characterToCodeTable.put(charAndCode.character, charAndCode.code);
		}
	}

	/**
	 * 文字コード配列
	 */
	private CryptByteArray byteArray;

	/**
	 * ゲームデータを受けてオブジェクトを構築。
	 * @param bitArray 8bit 配列によるゲームデータ
	 */
	public Jumon(BitArray bitArray)
	{
		// チェックサムを計算する。
		bitArray = new BitArrayWithChecksum(bitArray);

		// 逆から byte 配列化。
		byte [] data8bit = bitArray.getByteArray(8);
		data8bit = ArrayUtility.reverse(data8bit);

		// 8bit 毎の byte 配列を 6bit 毎の byte 配列化。
		bitArray = new BitArray(data8bit);
		byte [] data6bit = bitArray.getByteArray(6);

		// 内部表現としてのオブジェクト化。
		byteArray = new EncryptByteArray(data6bit);
	}

	/**
	 * 平文バイト配列を取得。
	 * @return 平文バイト配列
	 */
	public byte [] getCode()
	{
		return byteArray.getArray();
	}

	/**
	 * 復活の呪文文字列を受けてオブジェクトを構築。
	 * @param jumon 復活の呪文文字列
	 */
	public Jumon(String jumon)
	{
		int count = 0;

		byte [] code = new byte [20];

		for (int i=0 ; i<jumon.length() ; i++)
		{
			char ch = jumon.charAt(i);

			if (ch != ' ' && ch != '　' && ch != '\r' && ch != '\n')
			{
				// 空白文字ではない。

				if (characterToCodeTable.containsKey(ch))
				{
					// 有効な文字である。

					code[count] = characterToCodeTable.get(ch);
					count++;

					if (count >= 20)
					{
						// 終端に達した。

						break;
					}
				}
			}
		}

		// 復号化。
		byteArray = new DecryptByteArray(code);
	}

	/**
	 * 復活の呪文文字列を生成。
	 * @return 復活の呪文文字列
	 */
	public String getString()
	{
		byte [] code = byteArray.encrypt();

		String ret = new String();

		for (int i=0 ; i<20 ; i++)
		{
			ret += codeToCharacterTable.get(code[i]);

			if (i == 4 || i == 16)
			{
				// 空白が入る場所である。

				ret += ' ';
			}
			else if (i == 11)
			{
				// 改行が入る場所である。

				ret += "\r\n";
			}
		}

		return ret;
	}

	/**
	 * 王様のせりふとして文字列化。
	 * @return せりふの文字列
	 */
	public String getJumonAsKingSerifu()
	{
		byte [] code = byteArray.encrypt();

		String jumon1 = new String();
		for (int i=0 ; i<12 ; i++)
		{
			jumon1 += codeToCharacterTable.get(code[i]);

			if (i==4)
			{
				// 空白が入る場所である。

				jumon1 += '　';
			}
		}

		String jumon2 = new String();

		for (int i=12 ; i<20 ; i++)
		{
			jumon2 += codeToCharacterTable.get(code[i]);

			if (i==16)
			{
				// 空白が入る場所である。

				jumon2 += '　';
			}
		}

		IGameData gameData = new GameDataBitArray(this);

		String ret;

		if (gameData.getExperience().getValue() < Experience.getMax())
		{
			// 最大レベルではない。

			ret =
				String.format(
					JumonSerifu.serifu1,
					gameData.getName().getText(),
					new NumberString(gameData.getExperience().getForNextLevel()),
					jumon1,
					jumon2,
					gameData.getName().getText());
		}
		else
		{
			// 最大レベルである。

			ret =
				String.format(
					JumonSerifu.serifuKing,
					gameData.getName().getText(),
					jumon1,
					jumon2,
					gameData.getName().getText());
		}

		return ret;
	}

	/**
	 * 竜王のせりふとして文字列化。パラメータは事前に変更済みとすること。
	 * @return せりふの文字列
	 */
	public String getJumonAsRyuuouSerifu()
	{
		byte [] code = byteArray.encrypt();

		String jumon1 = new String();
		for (int i=0 ; i<12 ; i++)
		{
			jumon1 += codeToCharacterTable.get(code[i]);

			if (i==4)
			{
				// 空白が入る場所である。

				jumon1 += '　';
			}
		}

		String jumon2 = new String();

		for (int i=12 ; i<20 ; i++)
		{
			jumon2 += codeToCharacterTable.get(code[i]);

			if (i==16)
			{
				// 空白が入る場所である。

				jumon2 += '　';
			}
		}

		IGameData gameData = new GameDataBitArray(this);

		return
			String.format(
				JumonSerifu.serifuRyuuou,
				gameData.getName().getText(),
				gameData.getName().getText(),
				jumon1,
				jumon2);
	}
}
