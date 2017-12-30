package stormTP.core;



public abstract class AbstractRunner {

    long id = -1;    // identifiant du coureur
    long top = -1;   // numéro d'observation
    int position = -1;  // numéro de cellule sur la piste
    String nom = "";  // nom du coureur
    String rang = "";   // rang du coueur
    int nbDevant = -1;   // nombre de coureurs se trouvant devant le coueur courant dans le classement
    int nbDerriere = -1;  //nombre de coureurs se trouvant derrière le coureur courant dans le classement
    int total = -1;  // nombre de coureurs en lice pour la course courante
    int points = 0;  // nombre de points cumulés par le coureur


    public AbstractRunner(long id, String name, int before, int after, int total, int position, long top){
        this.id = id;
        this.nom = name;
        this.nbDevant = before;
        this.nbDerriere = after;
        this.total = total;
        this.position = position;
        this.top = top;
    }
    public AbstractRunner(){}

}
