package kumagai.Fukkatsu.struts2;

import org.apache.struts2.convention.annotation.*;

/**
 * 呪文入力画面表示アクション。
 * @author kumagai
 */
@Namespace("/fukkatsu")
@Result(name="success", location="/fukkatsu/analyzejumon1.jsp")
public class AnalyzeJumon1Action
{
	/**
	 * 何もしない。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("analyzejumon1")
    public String execute()
    	throws Exception
	{
		return "success";
	}
}
