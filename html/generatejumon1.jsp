<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ドラゴンクエスト 復活の呪文</title>
		<link rel="stylesheet" type="text/css" href="hatena.css">
	</head>

	<body>
		<h1>ドラゴンクエスト 復活の呪文</h1>

		<div class=hatena-body>
		<div class=main>

			<div class=day>

				<s:form action="generatejumon2" theme="simple">

				<h2><span class=title>名前など</span></h2>
				<div class=body>
				<div class=section>

					名前：
					<input type="text" name="name" value="とんぬら"><br>

					バリエーション：
					<s:select name="variation" list="#{ '0':'0','1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7' }"/>

					ゴールド：
					<input type="text" name="gold" value="0">

					経験値：
					<input type="text" name="experience" value="0" align="right"><br>

					薬草：
					<s:select name="yakusouCount" list="#{ '0':'0個','1':'1個','2':'2個','3':'3個','4':'4個','5':'5個','6':'6個' }"/>

					鍵：
					<s:select name="keyCount" list="#{ '0':'0個','1':'1個','2':'2個','3':'3個','4':'4個','5':'5個','6':'6個' }"/>
					<br>

				</div>
				</div>

				<h2><span class=title>アイテム</span></h2>
				<div class=body>
				<div class=section>

				<s:select name="item1" list="items" listKey="index" listValue="name" />
				<s:select name="item2" list="items" listKey="index" listValue="name" />
				<s:select name="item3" list="items" listKey="index" listValue="name" />
				<s:select name="item4" list="items" listKey="index" listValue="name" />

				<br>

				<s:select name="item5" list="items" listKey="index" listValue="name" />
				<s:select name="item6" list="items" listKey="index" listValue="name" />
				<s:select name="item7" list="items" listKey="index" listValue="name" />
				<s:select name="item8" list="items" listKey="index" listValue="name" />

				</div>
				</div>

				<h2><span class=title>装備</span></h2>
				<div class=body>
				<div class=section>

				武器：
				<s:select name="weapon" list="weapons" listKey="index" listValue="name" />

				鎧：
				<s:select name="armor" list="armors" listKey="index" listValue="name" />

				盾：
				<s:select name="shield" list="shields" listKey="index" listValue="name" />

				</div>
				</div>

				<h2><span class=title>イベント</span></h2>
				<div class=body>
				<div class=section>

				<input type="checkbox" name="ryuunoUroko">竜のうろこを装備
				<input type="checkbox" name="senshiNoYubiwa">戦士の指輪を装備
				<input type="checkbox" name="dragonTaoshita">ドラゴンを倒した
				<input type="checkbox" name="gooremuTaoshita">ゴーレムを倒した
				<input type="checkbox" name="shiNoKubikazari">死の首飾りを入手
				<br>

				</div>
				</div>

				<h2><span class=title>出力形式</span></h2>
				<div class=body>
				<div class=section>

				<s:select name="jumonStyle" list="#{ '0':'呪文のみ','1':'王様','2':'竜王' }"/>

				</div>
				</div>

				<s:submit value="呪文生成" />

				</s:form>

			</div>

		</div>
		</div>
	</body>
</html>
