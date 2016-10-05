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
				<s:form action="analyzejumon2" theme="simple">
					<h3>呪文</h3>
					<s:textarea name="jumon" rows="5" cols="25" value="ふるいけや かわずとびこむ みずのおと ばしや" />
					<br>
					<s:submit value="解析" />
				</s:form>
			</div>
		</div>
	</body>
</html>
