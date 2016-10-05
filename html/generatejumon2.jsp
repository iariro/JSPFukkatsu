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
				<h3>呪文</h3>
				<s:iterator value="jumonString" id="line">
					<s:property value="line" /><br>
				</s:iterator>
				<br>

				<h3>ゲームデータ</h3>
				名前：
				<s:property value="name" />
				Level.<s:property value="level" /><br>
				<br>

				<s:if test="errorsLength > 0">
					<h3>エラー</h3>
					<ul>
						<s:iterator value="errors" id="error">
							<li><span class="error"><s:property value="error" /></span><br>
						</s:iterator>
					</ul>
				</s:if>
			</div>
			</div>
		</div>
	</body>
</html>
