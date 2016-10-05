package kumagai.Fukkatsu.logic;

import java.util.*;

/**
 * プレイヤー名前情報。
 */
public class PlayerName
{
	static private CharAndCode nameCharAndCodes [] =
	{
		new CharAndCode('０', 0),
		new CharAndCode('１', 1),
		new CharAndCode('２', 2),
		new CharAndCode('３', 3),
		new CharAndCode('４', 4),
		new CharAndCode('５', 5),
		new CharAndCode('６', 6),
		new CharAndCode('７', 7),
		new CharAndCode('８', 8),
		new CharAndCode('９', 9),
		new CharAndCode('あ', 10),
		new CharAndCode('い', 11),
		new CharAndCode('う', 12),
		new CharAndCode('え', 13),
		new CharAndCode('お', 14),
		new CharAndCode('か', 15),
		new CharAndCode('き', 16),
		new CharAndCode('く', 17),
		new CharAndCode('け', 18),
		new CharAndCode('こ', 19),
		new CharAndCode('さ', 20),
		new CharAndCode('し', 21),
		new CharAndCode('す', 22),
		new CharAndCode('せ', 23),
		new CharAndCode('そ', 24),
		new CharAndCode('た', 25),
		new CharAndCode('ち', 26),
		new CharAndCode('つ', 27),
		new CharAndCode('て', 28),
		new CharAndCode('と', 29),
		new CharAndCode('な', 30),
		new CharAndCode('に', 31),
		new CharAndCode('ぬ', 32),
		new CharAndCode('ね', 33),
		new CharAndCode('の', 34),
		new CharAndCode('は', 35),
		new CharAndCode('ひ', 36),
		new CharAndCode('ふ', 37),
		new CharAndCode('へ', 38),
		new CharAndCode('ほ', 39),
		new CharAndCode('ま', 40),
		new CharAndCode('み', 41),
		new CharAndCode('む', 42),
		new CharAndCode('め', 43),
		new CharAndCode('も', 44),
		new CharAndCode('や', 45),
		new CharAndCode('ゆ', 46),
		new CharAndCode('よ', 47),
		new CharAndCode('ら', 48),
		new CharAndCode('り', 49),
		new CharAndCode('る', 50),
		new CharAndCode('れ', 51),
		new CharAndCode('ろ', 52),
		new CharAndCode('わ', 53),
		new CharAndCode('を', 54),
		new CharAndCode('ん', 55),
		new CharAndCode('っ', 56),
		new CharAndCode('ゃ', 57),
		new CharAndCode('ゅ', 58),
		new CharAndCode('ょ', 59),
		new CharAndCode('゛', 60),
		new CharAndCode('゜', 61),
		new CharAndCode('－', 62),
		new CharAndCode('　', 63)
	};

	/**
	 * 文字→文字コード変換テーブル
	 */
	static private HashMap<Character, Byte> characterToCodeTable;

	/**
	 * 文字コード→文字変換テーブル
	 */
	static private HashMap<Byte, Character> codeToCharacterTable;

	/**
	 * 文字・コードテーブルを初期化。
	 */
	static
	{
		characterToCodeTable = new HashMap<Character, Byte>();
		codeToCharacterTable = new HashMap<Byte, Character>();

		for (CharAndCode charAndCode : nameCharAndCodes)
		{
			characterToCodeTable.put(charAndCode.character, charAndCode.code);
		}

		for (CharAndCode charAndCode : nameCharAndCodes)
		{
			codeToCharacterTable.put(charAndCode.code, charAndCode.character);
		}
	}

	/**
	 * 文字コード配列
	 */
	private byte [] code = new byte [4];

	/**
	 * 文字コードを取得。
	 * @param i インデックス値
	 * @return 文字コード
	 */
	public byte get(int i)
	{
		return code[i];
	}

	/**
	 * 文字コードを割り当て。
	 * @param i インデックス値
	 * @param value 文字コード
	 */
	public void set(int i, int value)
	{
		code[i] = (byte)value;
	}

	/**
	 * 名前を設定しない場合用のコンストラクタ
	 */
	public PlayerName()
	{
	}

	/**
	 * オブジェクトの初期化とともに名前文字列により名前コードを設定する
	 * @param name 名前文字列
	 */
	public PlayerName(String name)
	{
		setText(name);
	}

	/**
	 * 名前を取得する。
	 * @return 名前
	 */
	public String getText()
	{
		String ret = new String();

		for (int i=0 ; i<code.length ; i++)
		{
			ret += (char)codeToCharacterTable.get(code[i]);
		}

		return ret;
	}

	/**
	 * 名前を割り当てる。
	 * @param value 名前
	 */
	public void setText(String value)
	{
		for (int i=0 ; i<value.length() ; i++)
		{
			if (characterToCodeTable.containsKey(value.charAt(i)))
			{
				// 有効な文字である。

				code[i] =
					(byte)characterToCodeTable.get(value.charAt(i)).byteValue();
			}
		}
	}
}
