<%-- 
    Document   : listarEvidences
    Created on : 29/09/2016, 11:46:49 AM
    Author     : PandithaGD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Evidences</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Id </th>
                    <th>Code</th>
                    <th>Seq</th>
                    <th>Association</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="evidence" items="${evicences}">
                    <tr>
                        <td>${evidence.id}</td>
                        <td>${evidence.code}</td>
                        <td>${evidence.seq}</td>
                        <td>${evidence.association}</td>
                        <td><a href="EvidenceController?action=cambiar&id=${evidence.id}">Cambiar</a></td>
                        <td><a href="EvidenceController?action=borrar&id=${evidence.id}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <p>
            <a href="EvidenceController?action=agregar">Nuevo Evidence</a>
        </p>
    </body>
</html>

