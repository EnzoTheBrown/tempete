package stormTP.core;

public class Classement {
    private int id;
    private int top;
    private String nom;
    private String rang;
    private int nbTotal;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
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

    public int getNbTotal() {
        return nbTotal;
    }

    public void setNbTotal(int nbTotal) {
        this.nbTotal = nbTotal;
    }
}
