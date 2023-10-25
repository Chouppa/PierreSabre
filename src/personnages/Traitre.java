package personnages;
import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise;
	
	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
		this.niveauTraitrise = 0;
	}
	
	@Override
	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + nom + " et j'aime boire du " + boisson + ".");
		parler("Je suis fier de servir le seigneur " + seigneur + ".");
		parler("Mais je suis un traître et mon niveau de traîtrise est "+ niveauTraitrise +". Chut!");
	}
	
	public void ranconner(Commercant commercant) {
		int argentRanconner;
		
		if (niveauTraitrise < 3) {
			argentRanconner = commercant.getArgent() * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Donne-moi "+ argentRanconner +" sous ou gare à toi!");
			commercant.parler("Tout de suite grand "+ nom +".");
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer!");
		}
	}
	
	public void faireLeGentil() {
		Random rand = new Random();
		Humain humain;
		int don;
		
		if (nbConnaissance == 0) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne! Snif.");
		} else {
			humain = memoire[rand.nextInt(nbConnaissance)];
			don = argent / 20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "+ humain.nom +".");
			parler("Bonjour l'ami! Je voudrais vous aider en vous donnant "+ don +" sous.");
			humain.gagnerArgent(don);
			perdreArgent(don);
			humain.parler("Merci "+ nom +". Vous êtes quelqu'un de bien.");
			niveauTraitrise -= (niveauTraitrise>0) ? 1 : 0;
		}
	}

}
