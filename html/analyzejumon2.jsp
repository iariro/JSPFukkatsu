<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<title>ドラゴンクエスト 復活の呪文</title>
		<link rel="stylesheet" type="text/css" href="hatena.css">
	</head>

	<body>
		<h1>ドラゴンクエスト 復活の呪文</h1>

		<div class=hatena-body>
		<div class=main>
		<div class=day>
			<h2>呪文</h2>
			<s:property value="jumon" />
			<br>
			<br>

			<s:if test="%{!valid}">
			<div style="color:red;">じゅもんがちがいます</div>
			</s:if>

			<h2>パラメータ</h2>
			<table>
				<tr>
					<td>名前</td>
					<td align="right"><s:property value="name" /></td>
				</tr>
				<tr>
					<td>バリエーション</td>
					<td align="right"><s:property value="variation" /></td>
				</tr>
				<tr>
					<td>ゴールド</td>
					<td align="right"><s:property value="gold" /></td>
				</tr>
				<tr>
					<td>経験値</td>
					<td align="right"><s:property value="experience" /></td>
				</tr>
				<tr>
					<td>レベル</td>
					<td align="right"><s:property value="level" /></td>
				</tr>
				<tr>
					<td>薬草</td>
					<td align="right"><s:property value="yakusouCount" /></td>
				</tr>
				<tr>
					<td>鍵</td>
					<td align="right"><s:property value="keyCount" /></td>
				</tr>
			</table>

			<h2>イベント</h2>
			<table>
				<tr>
					<td>武器</td>
					<td><s:property value="weapon" /></td>
				</tr>
				<tr>
					<td>鎧</td>
					<td><s:property value="armor" /></td>
				</tr>
				<tr>
					<td>盾</td>
					<td><s:property value="shield" /></td>
				</tr>
			</table>

			<h2>イベント</h2>
			<table>
				<tr>
					<td>竜のうろこを装備</td>
					<td><s:property value="竜のうろこを装備" /></td>
				</tr>
				<tr>
					<td>戦士の指輪装備</td>
					<td><s:property value="戦士の指輪装備" /></td>
				</tr>
				<tr>
					<td>ドラゴンを倒した</td>
					<td><s:property value="ドラゴンを倒した" /></td>
				</tr>
				<tr>
					<td>ゴーレムを倒した</td>
					<td><s:property value="ゴーレムを倒した" /></td>
				</tr>
				<tr>
					<td>死の首飾りを入手</td>
					<td><s:property value="死の首飾りを入手" /></td>
				</tr>
			</table>

			<h2>アイテム</h2>
			<table>
				<tr>
					<td><s:property value="items[0]" /></td>
					<td><s:property value="items[1]" /></td>
					<td><s:property value="items[2]" /></td>
					<td><s:property value="items[3]" /></td>
				</tr>
				<tr>
					<td><s:property value="items[4]" /></td>
					<td><s:property value="items[5]" /></td>
					<td><s:property value="items[6]" /></td>
					<td><s:property value="items[7]" /></td>
				</tr>
			</table>

		</div>
		</div>
		</div>
	</body>
</html>
