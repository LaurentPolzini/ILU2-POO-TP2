package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] vendeursProduit(String produit) {
		return this.village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(int nbAchatProd, Gaulois vendeur) {
		return this.village.rechercherEtal(vendeur).acheterProduit(nbAchatProd);
	}
	
	public Gaulois trouverHabitant(String nomGaugau) {
		return this.village.trouverHabitant(nomGaugau);
	}
	
}
