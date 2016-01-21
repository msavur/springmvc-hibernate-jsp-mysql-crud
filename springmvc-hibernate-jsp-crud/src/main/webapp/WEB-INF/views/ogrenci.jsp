<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script>
	function myFunction() {
		return confirm('Ogrenciyi Silme istiyor musunuz ?')
	}
</script>
<title>Ogrenci</title>
</head>
<body>
	<div align="center">
		<h2>Ogrenci EKLE</h2>
		<form:form commandName="ogrenci" method="POST" action="/ekleOgrenci">

			<table>

				<tr>
					<td>Adinizi Giriniz :</td>
					<td><input type="text" name="adi"></td>
					<td><form:errors path="adi" /></td>
				</tr>
				<tr>
					<td>Soyadinizi Giriniz :</td>
					<td><input type="text" name="soyadi"></td>
					<td><form:errors path="soyadi" /></td>
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
		<br>


		<c:if test="${!empty listOgrenci}">
			<div class="container">
				<h2>Ogrenci Listesi</h2>

				<table border="1" class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>ADI</th>
							<th>SOYADI</th>
							<th>Sil</th>
							<th>Duzenle</th>
						</tr>
					</thead>
					<c:forEach items="${listOgrenci}" var="ogrenci">
						<tbody>
							<tr>
								<td>${ogrenci.id}</td>
								<td>${ogrenci.adi}</td>
								<td>${ogrenci.soyadi}</td>
								<td><a href="/silOgrenci/${ogrenci.id}"
									onclick="return myFunction()"> <span
										class="glyphicon glyphicon-trash"></span>
								</a></td>
								<td><a href="/duzenleOgrenci/${ogrenci.id}"> <span
										class="glyphicon glyphicon-pencil"></span>
								</a></td>

							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</c:if>
	</div>

</body>
</html>
