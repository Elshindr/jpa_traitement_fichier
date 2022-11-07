package entities;

import components.RecupFichier;

import javax.persistence.*;

@Entity
@Table(name="marque")
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String libelle;

	public Marque() {
	}

	public Marque(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Marque(String libelle) {
		this.id = RecupFichier.MARQUE_MAP.size() ;
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Marque{" +
				"id=" + id +
				", libelle='" + libelle + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
