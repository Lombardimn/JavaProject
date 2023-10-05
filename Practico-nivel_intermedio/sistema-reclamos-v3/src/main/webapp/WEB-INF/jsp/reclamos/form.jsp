<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Formulario de Reclamo</h2>

<form:form action="/reclamos/guardar" id="formReclamo" modelAttribute="reclamoForm">

	<div class="row">
		<div class="col-md-6">	
			<div class="mb-3">
			  <label class="form-label">Id</label>
			  <form:input cssClass="form-control" path="idForm" readonly="true"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Título</label>
			  <form:input cssClass="form-control required" path="titleForm"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Descripción</label>
			  <form:textarea cssClass="form-control required" path="descriptionForm" rows="5" cols="15" />
			</div>
		
		
			<button class="btn btn-primary" id="buttonEnviar" type="button">Enviar</button>
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>

		</div>
	</div>
	
	<script>
		$(document).ready(function() {
			console.log('Listo término de cargar todo el html de la página....');
			
			
			$('#buttonEnviar').on('click', function() {
				if($('#formReclamo').valid() == true) {
					$('#formReclamo').submit();
				} else {
					bootbox.alert('Por favor completar los campos que faltan....');
				}
			});
			
			$('#buttonCancelar').on('click', function() {
				history.back();
			});
		
			
		});
	</script>

</form:form>

<jsp:include page="../template_inferior.jsp"></jsp:include>
