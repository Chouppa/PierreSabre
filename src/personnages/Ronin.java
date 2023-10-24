package personnages;

public class Ronin extends Humain {
	private int honneur;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
		this.honneur = 1;
	}

	public void donner(Commercant beneficiaire) {
		parler(beneficiaire.nom + ", prend ces 6 sous.");
		beneficiaire.recevoir(argent/10);
		argent *= 0.9;
	}
}
