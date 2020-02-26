<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Gestion des Automates</title>
</head>
<body>
 <center>
  <h1>Rapport des automates</h1>
        <h2>
         <a href="en_service" style="margin-right:10px"> En service </a>
         <a href="hors_service" style="margin-right:10px"> Hors service </a>
         <a href="a_reapprovisionner" style="margin-right:10px"> A reapprovisionner </a>
         <a href="ventes" style="margin-right:10px"> Ventes </a>
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5" id="table_automate">
            <caption><h2>Liste des automates hors services : </h2></caption>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/script_hors_service.js"> </script>

