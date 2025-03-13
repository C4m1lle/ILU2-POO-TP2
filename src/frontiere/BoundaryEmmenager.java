package frontiere;

import controleur.ControlEmmenager;
import villagegaulois.Village;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println(
							"Bienvenue villageois"+nomVisiteur);
					controlEmmenager.ajouterGaulois(nomVisiteur,Clavier.entrerEntier("Quelle est votre force?"));
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println(
		 		"Bienvenue Druide"+nomVisiteur);
		controlEmmenager.ajouterDruide(nomVisiteur,Clavier.entrerEntier("Quelle est votre force?"),Clavier.entrerEntier("Quelle est votre potMin?"),Clavier.entrerEntier("Quelle est votre Potmax?"));
	}
}
