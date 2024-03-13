package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = this.controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} 
		else {
			String[] donneesEtal = this.controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0].equals("true")) {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " " + donneesEtal[2] + " sur " + donneesEtal[3]);
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée !");
			}
		}
	}

}
