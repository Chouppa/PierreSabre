package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 0;
	}
	
	public void extorquer(Commercant victime) {
		int argent;
		parler(victime.nom + ", si tu tiens à la vie donne moi ta bourse!");
		argent = victime.seFaireExtorquer();
		this.argent += argent;
		reputation += 1;
		parler("J’ai piqué les " + argent + " sous de Marco, ce qui me fait " + this.argent + " sous dans ma poche. Hi! Hi!");
	}
}
