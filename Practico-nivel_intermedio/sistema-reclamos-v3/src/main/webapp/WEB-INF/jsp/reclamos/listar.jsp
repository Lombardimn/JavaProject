<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Listado de Reclamos</h2>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Título</th>
			<th>Descripción</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${claims}" var="r">
		<tr>
			<td>${r.id}</td>
			<td>${r.titleClaim}</td>
			<td>${r.descriptionClaim}</td>
			<td>
				<a class="btn btn-primary" href="/reclamos/${r.id}">Ver</a>
				<a class="btn btn-warning" href="/reclamos/${r.id}/editar">Editar</a>
				<a class="btn btn-danger" onclick="borrarReclamo(${r.id})" href="#">Borrar</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	function deletedClaim(idClaim) {
		bootbox.confirm('Seguro que queres borrar el reclamo ' + idClaim, function(result) {
        	if(result == true) {
        		window.location = '/reclamos/borrar/' + idClaim;
        	}
		});
	}
</script>

<jsp:include page="../template_inferior.jsp"></jsp:include>