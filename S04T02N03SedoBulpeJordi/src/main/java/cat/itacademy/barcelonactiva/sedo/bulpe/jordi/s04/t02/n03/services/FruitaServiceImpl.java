package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n03.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n03.domain.Fruita;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n03.repository.FruitaRepo;


@Service
public class FruitaServiceImpl implements FruitaService{
	@Autowired
	private FruitaRepo repo;

	@Override
	@Transactional
	public void desarFruita(Fruita fruita) {
		repo.save(fruita);		
	}

	@Override
	@Transactional
	public void esborrarFruita(int id) {
		repo.deleteById(id);		
	}
	
	@Override
	@Transactional(readOnly = true)	
	public Optional<Fruita> mostrarFruita(int id) {
		Optional<Fruita> fruitaOpt = repo.findById(id);
		return fruitaOpt;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fruita> mostrarTotesFruites() {	
		return (List<Fruita>) repo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existeixIdFruita(int idFruita){
        return repo.existsById(idFruita);
    }
	
	@Override
	@Transactional(readOnly = true)
	public boolean existeixNom(String nom) {
		Fruita fruita = new Fruita();
		fruita = repo.findByNom(nom);
			
		if(fruita == null) {
			return false;
		}
		return true;
	}
	
}
