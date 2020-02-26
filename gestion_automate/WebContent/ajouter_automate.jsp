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
         &nbsp;&nbsp;&nbsp;
         <a href="liste">Liste de tous les automates</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${automate != null}">
   <form action="modifier" method="post">
        </c:if>
        <c:if test="${automate == null}">
   <form action="ajouter" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${automate != null}">
               Modifier un automate
              </c:if>
              <c:if test="${automate == null}">
               Ajouter un automate
              </c:if>
             </h2>
            </caption>
            <c:if test="${automate != null}">
               <input type="hidden" name="update" value="<c:out value='1' />" />
              </c:if>
         
           <input type="hidden" name="id" value="<c:out value='${automate.id}' />" />
                    
            <tr>
                <th>Numéro de série : <c:out value='${automate.num_serie}' /></th>
                <td>
                 <input type="text" name="num_serie" size="45"
                   value="<c:out value='${automate.num_serie}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Adresse d'installation : </th>
                <td>
                 <input type="text" name="adresse_instal" size="45"
                   value="<c:out value='${automate.adresse_instal}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Emplacement : </th>
                <td>
                 <input type="text" name="emplacement" size="30"
                   value="<c:out value='${automate.emplacement}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Latitude GPS : </th>
                <td>
                 <input type="text" name="latitude" size="30"
                   value="<c:out value='${automate.latitude}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Longitude GPS : </th>
                <td>
                 <input type="text" name="longitude" size="30"
                   value="<c:out value='${automate.longitude}' />"
                 />
                </td>
            </tr>
            <c:if test="${automate != null}">
                <tr>
                <th>Date intervention : </th>
                <td>
                 <input type="text" name="date_intervention" size="30"
                   value="<c:out value='${automate.date_intervention}' />"
                 />
                </td>
            </tr>
              </c:if>
            <tr>
                <th>Commentaires : </th>
                <td>
                 <input type="text" name="commentaire" size="30"
                   value="<c:out value='${automate.commentaire}' />"
                 />
                </td>
            </tr>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>