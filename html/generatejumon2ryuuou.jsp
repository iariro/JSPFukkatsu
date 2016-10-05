<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
	<head>
		<title>ドラゴンクエスト 復活の呪文</title>
		<link rel="stylesheet" type="text/css" href="ryuuou.css">
	</head>

	<body>
		<h1>ドラゴンクエスト 復活の呪文</h1>

		<div class=hatena-body>
			<div class=main>
			<div class=day>
				<s:iterator value="jumonString" id="line">
					<s:property value="line" /><br>
				</s:iterator>
			</div>
			</div>
		</div>
	</body>
</html>
