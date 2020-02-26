fetch('http://localhost:9090/ws_rapport/api/dashboard/all')
.then(res=> res.json())//response type
.then(data =>{
   let tr;
   let syspaie;
   let articles;
   for (let index = 0; index < data.length; index++) {
   tr = document.createElement("tr");
   let rapportIndexArray = new Array();

      if (!rapportIndexArray.includes(data[index]['auto_id'])  && index == lastRapportId(data[index]['auto_id'], data)){
         if((reapprovisionner(data[index]['articles']) == 1))
         {
            // tr.appendChild(document.createElement("td")).textContent = data[index]['id']
            tr.appendChild(document.createElement("td")).textContent = data[index]['auto_id']
            tr.appendChild(document.createElement("td")).textContent = data[index]['statut_fonctionnement']
            tr.appendChild(document.createElement("td")).textContent = data[index]['date_heure']
            tr.appendChild(document.createElement("td")).textContent = data[index]['etat']
            tr.appendChild(document.createElement("td")).textContent = data[index]['temperature']
            tr.appendChild(document.createElement("td")).textContent = data[index]['erreurs']
            tr.appendChild(document.createElement("td")).textContent = data[index]['montant_vente']
            syspaie = tr.appendChild(document.createElement("td")).appendChild(document.createElement("ul"));
            syspaie.appendChild(document.createElement("li")).textContent = "monayeur : " + data[index]['systeme_paiement']['monayeur']
            syspaie.appendChild(document.createElement("li")).textContent = "carte_a_puce : " + data[index]['systeme_paiement']['carte_a_puce']
            syspaie.appendChild(document.createElement("li")).textContent = "paiement_sans_contact : " + data[index]['systeme_paiement']['carte_sans_contact']
            
            articles = tr.appendChild(document.createElement("td")).appendChild(document.createElement("ul"));
            for (let j = 0; j < data[index]['articles'].length; j++) {
               articles.appendChild(document.createElement("li")).textContent = "nom : " + data[index]['articles'][j]['nom']+ "   -   " +  data[index]['articles'][j]['prix']+ " euros (" +data[index]['articles'][j]['quantite_restante'] + ")" 
            }
            let commentaires = tr.appendChild(document.createElement("td"))
            if(reapprovisionnerChaudTroisFoisPlus(data)){
                commentaires.innerHTML += "Réapprovisionner Trois fois plus de boissons chaudes<br>"

             }
             if(reapprovisionnerFroidTroisFoisPlus(data)){
             	commentaires.innerHTML += "Réapprovisionner Trois fois plus de boissons froides<br>"
             }
            
            document.getElementById("table_automate").appendChild(tr);
            rapportIndexArray.push(data[index]['auto_id'])
         }

      }
  
   }
   
}); 

function reapprovisionner(articles){
   // console.log(articles[0])
   for (let index = 0; index < articles.length; index++) {
      if (articles[index]['quantite_restante'] == 0)
      {
         return 1;
      }
   }
   return 0;
}

function lastRapportId(id_auto,data){
   let max_id = 0;
   for (let index = 0; index < data.length; index++) {
      if((data[index]['auto_id'] == id_auto) && (index >= max_id)){
            max_id = index;
      }
   }
   return max_id;
}

function reapprovisionnerChaudTroisFoisPlus(data){
	for (let index = 0; index < data.length; index++) {
		if((reapprovisionner(data[index]['articles']) == 1) && (data[index]['temperature'] < 5)){
			return 1;
		}
   }
   return 0;
}
function reapprovisionnerFroidTroisFoisPlus(data){
	for (let index = 0; index < data.length; index++) {
		if((reapprovisionner(data[index]['articles']) == 1) && (data[index]['temperature'] > 25)){
			return 1;
		}
   }
   return 0;
}

