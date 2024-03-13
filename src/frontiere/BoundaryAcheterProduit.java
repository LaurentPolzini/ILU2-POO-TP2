package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// Obtient le nom du produit désiré
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.next();
		Gaulois[] gaulioVendantProd = this.controlAcheterProduit.vendeursProduit(produit);
		
		if (gaulioVendantProd == null) {
			System.out.println("Désolé, personne ne vend actuellement de " + produit + " au marché.");
			
		} else {
			// Liste les commercants du dit produit
			System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
			for (int i = 0; i < gaulioVendantProd.length; i++) {
				System.out.println((i + 1) + " - " + gaulioVendantProd[i].getNom());
			}
			
			// Obtient le nom du vendeur
			String nomVendeur;
			boolean isVendeurInList = false;	
			do {
				nomVendeur = scan.next();
				for (Gaulois nomGaulois: gaulioVendantProd) { // cherche que le nom entré soit bien un vendeur du produit
					if (nomGaulois.getNom().equals(nomVendeur)) {
						isVendeurInList = true;
					}
				}
				if (!isVendeurInList) {
					System.out.println(nomVendeur + " ne vend pas de " + produit + " !");
					System.out.println("Chez qui voulez vous achetez " + produit + " ?");
				}
			} while (!isVendeurInList);
			
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal de " + nomVendeur);
			System.out.println(nomVendeur + ": Bonjour " + nomAcheteur + " !");
			int nbProdVoulu = Clavier.entrerEntier("Combien de " + produit + " veux-tu donc ?");
			int nbProdReel = this.controlAcheterProduit.acheterProduit(nbProdVoulu, this.controlAcheterProduit.trouverHabitant(nomVendeur));
			if (nbProdReel == 0) {
				System.out.println("Désolé, je n'ai plus du tout de " + produit + "...");
			}
			if (nbProdReel < nbProdVoulu) {
				System.out.println("Désolé " + nomAcheteur + ", il ne me reste plus que " + nbProdReel + " " + produit);
				System.out.println(nomAcheteur + " finit le stock de " + produit + " " + nomVendeur);
			}
			else {
				System.out.println(nomAcheteur + " achète " + nbProdReel + " " + produit + " à " + nomVendeur);
			}
			
			System.out.println("Très bonne journée à toi " + nomAcheteur + " !");
		}
		
	}
}
