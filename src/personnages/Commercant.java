package personnages;

public class Commercant extends Humain {
	
	public Commercant(String nom, int argent) {
		super(nom, "th�", argent);
	}
	
	public int seFaireExtorquer() {
		int perte = argent;

		parler("J'ai tout perdu! Le monde est trop injuste...");
		argent = 0;
		return perte;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous! Je te remercie g�n�reux donateur!");
		this.argent += argent;
	}
}
