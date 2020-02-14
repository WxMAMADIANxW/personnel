package personnel;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Employé d'une ligue hébergée par la M2L. Certains peuvent 
 * être administrateurs des employés de leur ligue.
 * Un seul employé, rattaché à aucune ligue, est le root.
 * Il est impossible d'instancier directement un employé, 
 * il faut passer la méthode {@link Ligue#addEmploye addEmploye}.
 */

public class Employe implements Serializable, Comparable<Employe>
{
	private static final long serialVersionUID = 4795721718037994734L;
	private String nom, prenom, password, mail;
	private LocalDate dateArrive , dateDepart;
	private Ligue ligue;
	
	Employe(Ligue ligue, String nom, String prenom, String mail, String password,LocalDate dateArrive)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.mail = mail;
		this.ligue = ligue;
		this.dateArrive = dateArrive;
	}
	
	/**
	 * Retourne vrai ssi l'employé est administrateur de la ligue 
	 * passée en paramètre.
	 * @return vrai ssi l'employé est administrateur de la ligue 
	 * passée en paramètre.
	 * @param ligue la ligue pour laquelle on souhaite vérifier si this 
	 * est l'admininstrateur.
	 */
	
	public boolean estAdmin(Ligue ligue)
	{
		return ligue.getAdministrateur() == this;
	}
	
	/**
	 * Retourne vrai ssi l'employé est le root.
	 * @return vrai ssi l'employé est le root.
	 */
	
	public boolean estRoot()
	{
		return GestionPersonnel.getGestionPersonnel().getRoot() == this;
	}
	
	/**
	 * Retourne le nom de l'employé.
	 * @return le nom de l'employé. 
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom de l'employé.
	 * @param nom le nouveau nom.
	 */
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne le prénom de l'employé.
	 * @return le prénom de l'employé.
	 */
	
	public String getPrenom()
	{
		return prenom;
	}
	
	/**
	 * Change le prénom de l'employé.
	 * @param prenom le nouveau prénom de l'employé. 
	 */

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	/**
	 * Retourne le mail de l'employé.
	 * @return le mail de l'employé.
	 */
	
	public String getMail()
	{
		return mail;
	}
	
	/**
	 * Change le mail de l'employé.
	 * @param mail le nouveau mail de l'employé.
	 */

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	/**
	 * Retourne vrai ssi le password passé en paramètre est bien celui
	 * de l'employé.
	 * @return vrai ssi le password passé en paramètre est bien celui
	 * de l'employé.
	 * @param password le password auquel comparer celui de l'employé.
	 */
	
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}

	/**
	 * Change le password de l'employé.
	 * @param password le nouveau password de l'employé. 
	 */
	
	public void setPassword(String password)
	{
		this.password= password;
	}
	
	/**
	 * Controle la saisie de la date d'arriv�e
	 * @param dateDepart
	 */

	/**
	 * Change la date d'arrivé de l'employé.
	 * @param dateArrive
	 */
	public void setDateArrive(LocalDate dateArrive)
	{
		this.dateArrive = dateArrive;
	}
	
	/**
	 * Changement avec controle de la date de départ de l'employé.
	 * 
	 * @param dateDepart
	 */
	
	public void setDateDepart(LocalDate dateDepart)
	{
		if(dateDepart.isBefore(this.dateArrive)) {
			throw new RuntimeException();
		}
		else {
			this.dateDepart = dateDepart;
		}
		
		
	}
	
	/**
	 * Retourne la date d'arrive de l'employé.
	 * @param dateArrive
	 * @return dateArrive
	 */
	
	public LocalDate getDateArrive()
	{
		return this.dateArrive;
	}
	
	/**
	 * Retourne la date de départ de l'employé.
	 * @param dateDepart
	 * @return dateDepart
	 */
	public LocalDate getDateDepart()
	{
		return this.dateDepart;
	}
	
	/**
	 * Retourne la ligue à laquelle l'employé est affecté.
	 * @return la ligue à laquelle l'employé est affecté.
	 */
	
	public Ligue getLigue()
	{
		return ligue;
	}

	/**
	 * Supprime l'employé. Si celui-ci est un administrateur, le root
	 * récupère les droits d'administration sur sa ligue.
	 */
	
	public void remove()
	{
		Employe root = GestionPersonnel.getGestionPersonnel().getRoot();
		if (this != root)
		{
			if (estAdmin(getLigue()))
				getLigue().setAdministrateur(root);
				ligue.remove(this);
				this.ligue = null;
		}
		else
			throw new ImpossibleDeSupprimerRoot();  
	}
	
	@Override
	public int compareTo(Employe autre)
	{
		int cmp = getNom().compareTo(autre.getNom());
		if (cmp != 0)
			return cmp;
		return getPrenom().compareTo(autre.getPrenom());
	}
	
	@Override
	public String toString()
	{
		String res =" Nom :"+ nom + "\n Pr�nom :  " + prenom + "\n Date D'arrvi�e : " + dateArrive+"\n Date D�part : "+ dateDepart+ " \n(";
		if (estRoot())
			res += "super-utilisateur";
		else
			res += ligue.toString();
		return res + ")";
	}
}
