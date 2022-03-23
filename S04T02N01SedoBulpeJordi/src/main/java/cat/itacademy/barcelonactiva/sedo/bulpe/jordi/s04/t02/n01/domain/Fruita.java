package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruita {

	@Id
	private int idFruita;
	private String nom;
	private int qttQuilos;
	
	public Fruita() {
		
	}

	public Fruita(int idFruita, String nom, int qttQuilos) {
		this.idFruita = idFruita;
		this.nom = nom;
		this.qttQuilos = qttQuilos;
	}

	

	public int getIdFruita() {
		return idFruita;
	}



	public void setIdFruita(int idFruita) {
		this.idFruita = idFruita;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getQttQuilos() {
		return qttQuilos;
	}



	public void setQttQuilos(int qttQuilos) {
		this.qttQuilos = qttQuilos;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fruita [idFruita=");
		builder.append(idFruita);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", qttQuilos=");
		builder.append(qttQuilos);
		builder.append("]");
		return builder.toString();
	}
	
}
