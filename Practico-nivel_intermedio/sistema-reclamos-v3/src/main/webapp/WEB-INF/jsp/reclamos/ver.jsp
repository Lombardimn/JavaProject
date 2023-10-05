<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Detalle del Reclamo</h2>
Id: ${claim.id}<br>
Titulo: ${claim.titleClaim}<br>
Descripcion: ${claim.descriptionClaim}<br>

<jsp:include page="../template_inferior.jsp"></jsp:include>
