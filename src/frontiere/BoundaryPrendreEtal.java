package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean isVendeurVerifie = this.controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!isVendeurVerifie) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal.");
			boolean isEtalDispo = this.controlPrendreEtal.resteEtals();
			if (!isEtalDispo) {
				System.out.println("Désolé " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé");
			} else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements: \nQuel produit souhaitez-vous vendre ?");
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if (numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numEtal + 1));
		}
	}
}
