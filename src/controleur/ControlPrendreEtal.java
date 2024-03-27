package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return this.village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		return this.village.installerVendeur(this.village.trouverHabitant(nomVendeur), produit, nbProduit);
	}

	public boolean verifierIdentite(String nomVendeur) {
		return this.controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	// true si deja un vendeur; false sinon
	public boolean isVendeur(String nomVendeur) {
		return this.village.rechercherEtal(this.village.trouverHabitant(nomVendeur)) != null;
	}
	
	public boolean isOccupe(String nomVendeur) {
		Etal etalVendeur = this.village.rechercherEtal(this.village.trouverHabitant(nomVendeur));
		boolean isIt = false;
		
		if (etalVendeur != null) {
			isIt = etalVendeur.isEtalOccupe();
		}
		
		return isIt;
	}
	
}
