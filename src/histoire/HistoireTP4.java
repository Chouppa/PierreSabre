package histoire;
import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		Commercant marco = new Commercant("Marco", 20);
		Yakuza yakuLeNoir = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		
		System.out.println("");
		
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		
		System.out.println("");
		
		yakuLeNoir.direBonjour();
		yakuLeNoir.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		yakuLeNoir.extorquer(marco);
		
		System.out.println("");
		
		roro.direBonjour();
		roro.donner(marco);
		
		System.out.println("");
		
		roro.provoquer(yakuLeNoir);
	}
}