<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Gestion des Automates</title>
</head>
<body>
 <center>
  <h1>Automate en services</h1>
        <h2>
         <a href="en_service">En service</a>
         
         <a href="hors_service">Hors service </a>
         <a href="ventes">Ventes</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5" id="table_automate">
            <caption><h2>Liste des automates : </h2></caption>
            <tr>
                
                <th>Automate Id</th>
                <th>Statut Fonctionnement</th>
                <th>date heure</th>
                <th>etat</th>
                <th>temperature</th>
                <th>erreurs</th>
                <th>montant de vente</th>
                <th>systeme de paiement</th>
                <th>Articles </th>
            </tr>
            
        </table>
    </div> 
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/script_en_service.js"> </script>

