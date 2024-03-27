package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	private Etal getEtal(String nomVendeur) { // simplement pour factoriser la ligne de code
		return this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public boolean isVendeur(String nomVendeur) {
		return (getEtal(nomVendeur) != null);
	}


	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] etatEtal = this.getEtal(nomVendeur).etatEtal();
		
		this.getEtal(nomVendeur).libererEtal();
		
		return etatEtal;
	}

}
