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
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol�e " + nomVendeur + " mais il faut �tre "
					+ " habitant de notre village pour commercer ici.\n");
		}
		else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous " +
					"trouver un �tal.\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol�e " + nomVendeur + " je n'ai plus d'�tal qui ne + "
						+ " soit pas d�j� occup�.\n");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		Clavier entree = new Clavier();
		System.out.println("C'est parfait, il me reste un �tal pour vous !");
		System.out.println("Il me faudrait quelques renseignements:");
		String produit = entree.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = entree.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " 
					+ (numeroEtal+1) + ".");
		}
	}
}