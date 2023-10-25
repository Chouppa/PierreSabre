package personnages;

public class Yakuza extends Humain{
	private String clan;
	protected int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
		this.reputation = 4;
	}
	
	@Override
	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
		parler("Mon clan est celui de " + clan + ".");
	}
	
	public void extorquer(Commercant victime) {
		int argent;
		parler(victime.nom + ", si tu tiens à la vie donne moi ta bourse!");
		argent = victime.seFaireExtorquer();
		this.argent += argent;
		reputation++;
		parler("J’ai piqué les " + argent + " sous de Marco, ce qui me fait " + this.argent + " sous dans ma poche. Hi! Hi!");
	}
	
	public int perdre() {
		int argent;
		
		parler("J’ai perdu mon duel et mes " + this.argent + " sous, snif... J'ai déshonoré le clan de" + clan);
		argent = this.argent;
		this.argent = 0;
		reputation--;
		return argent;
	}
	
	public void gagner(int gain) {
		parler("Ce ronin pensait vraiment battre "+ nom +" du clan de "+ clan +"? Je l'ai dépouillé de ses "+ gain +" sous.");
		argent += gain;
		reputation++;
	}
}
