<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Gestion des Automates</title>
</head>
<body>
 <center>
  <h1>Gestion des Automates</h1>
        <h2>
         <a href="ajouter">Ajouter un nouvel automate</a>
         
         <a href="liste">Liste de tous les automates</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Liste des automates : </h2></caption>
            <tr>
                <th>ID</th>
                <th>Numero de serie</th>
                <th>Adresse d'installation</th>
                <th>Emplacement</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Date intervention</th>
                <th>Commentaire</th>
            </tr>
            <c:forEach var="automate" items="${listeAutomate}">
                <tr>
                    <td><c:out value="${automate.id}" /></td>
                    <td><c:out value="${automate.num_serie}" /></td>
                    <td><c:out value="${automate.adresse_instal}" /></td>
                    <td><c:out value="${automate.emplacement}" /></td>
                    <td><c:out value="${automate.latitude}" /></td>
                    <td><c:out value="${automate.longitude}" /></td>
                    <td><c:out value="${automate.date_intervention}" /></td>
                    <td><c:out value="${automate.commentaire}" /></td>
                    <td>
                     <a href="modifier?id=<c:out value='${automate.id}' />">Modifier</a>
                    
                     <a href="supprimer?id=<c:out value='${automate.id}' />">Supprimer</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>