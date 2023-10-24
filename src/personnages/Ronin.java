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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (honneur*2 >= adversaire.reputation) {
			parler("Je t'ai eu petit yakuza!");
			argent += adversaire.perdre();
			honneur++;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argent);
			argent = 0;
			honneur--;
		}
	}
}
