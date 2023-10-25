package personnages;

public class Humain {
	protected String nom;
	protected String boisson;
	protected int argent;
	protected Humain[] memoire;
	protected int nbConnaissance;
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
		this.memoire = new Humain[30];
		this.nbConnaissance = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + "! Gloups!");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			argent -= prix;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous");
		}
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void faireConnaissanceAvec(Humain humain) {
			direBonjour();
			humain.repondre(this);
			memoriser(humain);
	}
	
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : " + memoire[0].nom;
		if (nbConnaissance == 0) {
			parler("Je ne connais personne pour l'instant.");
		} else {
			for (int i=1 ; i<nbConnaissance ; i++) {
				texte += ", " + memoire[i].nom;
			}
			parler(texte);
		}
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance == memoire.length) {
			for(int i=1 ; i<nbConnaissance ; i++) {
				memoire[i-1] = memoire[i];
			}
			memoire[nbConnaissance - 1] = humain;
		} else {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
}