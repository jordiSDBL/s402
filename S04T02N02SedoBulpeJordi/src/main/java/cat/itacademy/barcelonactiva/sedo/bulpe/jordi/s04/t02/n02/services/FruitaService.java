package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n02.services;

import java.util.List;
import java.util.Optional;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n02.domain.Fruita;

public interface FruitaService {

	public void desarFruita(Fruita fruita);
	public void esborrarFruita(int id);
	public Optional<Fruita> mostrarFruita(int id);
	public boolean existeixIdFruita(int idFruita);
	public boolean existsByNom(String nom);
	public List<Fruita> mostrarTotesFruites();
	
	
}
