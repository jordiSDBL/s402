package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.services;

import java.util.List;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.domain.Fruita;

public interface FruitaService {

	public void desarFruita(Fruita fruita);
	public void esborrarFruita(int id);
	public Fruita mostrarFruita(int id);
	public boolean existeixIdFruita(int idFruita);
	public boolean existsByNom(String nom);
	public List<Fruita> mostrarTotesFruites();
	
	
}
