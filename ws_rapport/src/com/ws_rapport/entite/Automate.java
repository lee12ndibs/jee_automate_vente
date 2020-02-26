package com.ws_rapport.entite;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@Entity
@Table(name = "automate")
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Automate {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		
		@Column(name = "num_serie")
		private String num_serie;
		
		@Column(name = "type")
		private String type;
		
		@Column(name = "adresse_instal")
		private String adresse_instal;
		
		@Column(name = "emplacement")
		private String emplacement;
		
		@Column(name = "latitude")
		private String latitude;
		
		@Column(name = "longitude")
		private String longitude;
		
		@Column(name = "date_intervention")
		private String date_intervention;
		
		@Column(name = "commentaire")
		private String commentaire;
	

		public Automate() {
			super();
		}
		
		public Automate(String num_serie, String date_intervention) {
			super();
			this.num_serie = num_serie;
			this.date_intervention = date_intervention;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNum_serie() {
			return num_serie;
		}
		public void setNum_serie(String num_serie) {
			this.num_serie = num_serie;
		}
		public String getAdresse_instal() {
			return adresse_instal;
		}
		public void setAdresse_instal(String adresse_instal) {
			this.adresse_instal = adresse_instal;
		}
		public String getEmplacement() {
			return emplacement;
		}
		public void setEmplacement(String emplacement) {
			this.emplacement = emplacement;
		}
		
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getDate_intervention() {
			return date_intervention;
		}
		public void setDate_intervention(String date_intervention) {
			this.date_intervention = date_intervention;
		}
		public String getCommentaire() {
			return commentaire;
		}
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}
		
		@Override
		public String toString() {
			return "Automate [id=" + id + ", num_serie=" + num_serie + ", adresse_instal=" + adresse_instal
					+ ", emplacement=" + emplacement + "]";
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
}
