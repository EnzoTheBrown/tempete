package stormTP.core;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.io.Serializable;

/** Classe représentant un coureur 'Tortue' ou 'Lièvre'
*/
public class Runner extends AbstractRunner{

	public Runner(long id, String name, int before, int after, int total, int position, long top){
		super( id, name, before, after, total,  position, top);
	}
	public Runner(){}

/* Getters and setters */
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getTop() {
		return top;
	}


	public void setTop(long top) {
		this.top = top;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getRang() {
		return rang;
	}


	public void setRang(String rang) {
		this.rang = rang;
	}


	public int getNbDevant() {
		return nbDevant;
	}


	public void setNbDevant(int nbDevant) {
		this.nbDevant = nbDevant;
	}


	public int getNbDerriere() {
		return nbDerriere;
	}


	public void setNbDerriere(int nbDerriere) {
		this.nbDerriere = nbDerriere;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}
	

	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
	
	
	public String getJSON_V1(){
		JsonObjectBuilder r = null;
		r = Json.createObjectBuilder();
		/* construction de l'objet JSON résultat */
		r.add("id", this.id);
		r.add("top", this.top);
		r.add("nom", this.nom);
		r.add("position", this.position);
        r.add("nbDevant", this.nbDevant);
        r.add("nbDerriere", this.nbDerriere);
        r.add("total", this.total);
       
        return r.build().toString();
	}


	public String getJSONRank(){
		JsonObjectBuilder r = null;
		r = Json.createObjectBuilder();
		/* construction de l'objet JSON résultat */
		r.add("id", this.id);
		r.add("top", this.top);
		r.add("nom", this.nom);
		r.add("rang", this.rang);
		r.add("nbTotal", this.total);

		return r.build().toString();
	}

	@Override
	public String toString(){
		return getJSON_V1();
	}
	
}
