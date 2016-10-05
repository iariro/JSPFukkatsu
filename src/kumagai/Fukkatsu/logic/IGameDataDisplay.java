package kumagai.Fukkatsu.logic;

/**
 * ゲームデータ入力インターフェイス。
 */
public interface IGameDataDisplay
{
	/**
	 * ゲームデータを取得。
	 * @return ゲームデータ
	 */
	GameDataBitArray get();

	/**
	 * ゲームデータを割り当て。
	 * @param gameData ゲームデータ
	 */
	void set(IGameData gameData);
}
