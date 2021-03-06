package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.*;

import java.time.LocalDate;
import java.util.ArrayList;


import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;

import personnel.*;

public class LigueConsole 
{
	private GestionPersonnel gestionPersonnel;
	private EmployeConsole employeConsole;

	public LigueConsole(GestionPersonnel gestionPersonnel, EmployeConsole employeConsole)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.employeConsole = employeConsole;
	}

	Menu menuLigues()
	{
		Menu menu = new Menu("Gérer les ligues", "l");
		menu.add(afficherLigues());
		menu.add(ajouterLigue());
		menu.add(selectionnerLigue());
		menu.addBack("q");
		return menu;
	}

	private Option afficherLigues()
	{
		return new Option("Afficher les ligues", "l", () -> {System.out.println(gestionPersonnel.getLigues());});
	}

	private Option afficher(final Ligue ligue)
	{
		return new Option("Afficher la ligue", "l", 
				() -> 
				{
					System.out.println(ligue);
					System.out.println("administrée par " + ligue.getAdministrateur());
				}
		);
	}
	private Option afficherEmployes(final Ligue ligue)
	{
		return new Option("Afficher les employes", "l", () -> {System.out.println(ligue.getEmployes());});
	}
	

	private Option ajouterLigue()
	{
		return new Option("Ajouter une ligue", "a", () -> 
		{
			try
			{
				gestionPersonnel.addLigue(getString("nom : "));
			}
			catch(SauvegardeImpossible exception)
			{
				System.err.println("Impossible de sauvegarder cette ligue");
			}
		});
	}
	
	private Menu editerLigue(Ligue ligue)
	{
		Menu menu = new Menu("Editer " + ligue.getNom());
		menu.add(afficher(ligue));
		menu.add(gererEmployes(ligue));
		menu.add(changerAdministrateur(ligue));
		menu.add(changerNom(ligue));
		menu.add(supprimer(ligue));
		menu.setAutoBack(true);
		menu.addBack("q");
		return menu;
	}
	
private LocalDate  getDate() {
		int year,month,day;
		year = getInt("Année: ");
		month= getInt("Mois: ");
		day = getInt("Jour: ");
		
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}

	private Option changerNom(final Ligue ligue)
	{
		return new Option("Renommer", "r", 
				() -> {ligue.setNom(getString("Nouveau nom : "));});
	}

	private List<Ligue> selectionnerLigue()
	{
		return new List<Ligue>("Sélectionner une ligue", "e", 
				() -> new ArrayList<>(gestionPersonnel.getLigues()),
				(element) -> editerLigue(element)
				);
	}
	
	private Option ajouterEmploye(final Ligue ligue)
	{
		return new Option("ajouter un employé", "a",
				() -> 
				{
					ligue.addEmploye(getString("nom : "), 
						getString("prenom : "), getString("mail : "), 
						getString("password : "),getDate());
				}
		);
	}
	private Menu editer(Employe employe)
	{
		Menu menu = new Menu(" Editer "+ employe.getNom() +" "+employe.getPrenom());
		menu.add(employeConsole.editerEmploye(employe));
		menu.add(finContrat(employe));
		menu.add(supprimerEmp(employe));
		menu.setAutoBack(true);
		menu.addBack("q");
		return menu;
	}
	
	private Menu gererEmployes(Ligue ligue)
	{
		Menu menu = new Menu("Gérer les employés de " + ligue.getNom(), "e");
		menu.add(afficherEmployes(ligue));
		menu.add(ajouterEmploye(ligue));
		menu.add(selectionnerEmploye(ligue));
		menu.addBack("q");
		return menu;
	}
	private List<Employe> selectionnerEmploye(Ligue ligue)
	{
		return new List<>("S�l�ctionner un(e) Employ�(e)","n",
		()-> new ArrayList<>(ligue.getEmployes()),
		(element)->editer(element)
		);
	}

	private Option supprimerEmploye(final Employe employe)
	{
		return new Option("Suprimmer "+ employe.getNom()+" "+employe.getPrenom(),"v"
				,()->{employe.remove();});
	}
	
	private List<Employe> changerAdministrateur(final Ligue ligue)
	{
		return new List<>("Changer administrateur de ligue","c",
				()-> new ArrayList<>(ligue.getEmployes()),
				(index,element)->{ligue.setAdministrateur(element);}
				);
	}		


	private Option supprimer(Ligue ligue)
	{
		return new Option("Supprimer", "d", () -> {gestionPersonnel.removeLigue(ligue);});
	}
	private Option finContrat(Employe employe) {
		return new Option("Ajouter une date de fin de contrat ","k",
				()-> {employe.setDateDepart(getDate());});
	}
	
	private Option supprimerEmp(Employe employe)
	{
		return new Option("Supprimer "+ employe.getNom()+" "+employe.getPrenom(),"v", () -> {gestionPersonnel.removeEmp(employe);});
	}
	
}
