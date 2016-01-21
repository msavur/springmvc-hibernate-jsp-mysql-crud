<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Ogrenci</title>
</head>
<body>
	<div align="center">
		<h2>Ogrenci DUZENLEME</h2>
		<form:form commandName="ogrenci" method="POST"
			action="/guncelleOgrenci/${id}">

			<table>

				<tr>
					<td>Adinizi Giriniz :</td>
					<td><input type="text" name="adi"></td>

				</tr>
				<tr>
					<td>Soyadinizi Giriniz :</td>
					<td><input type="text" name="soyadi"></td>

				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-floppy-saved"></span> Kaydet
						</button>
					</td>
				</tr>

			</table>


		</form:form>
	</div>
</body>
</html>
