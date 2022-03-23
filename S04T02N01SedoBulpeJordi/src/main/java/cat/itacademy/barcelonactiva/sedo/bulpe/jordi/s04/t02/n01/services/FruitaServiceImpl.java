package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.domain.Fruita;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.repository.FruitaRepo;

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
	public Fruita mostrarFruita(int id) {
		return repo.findById(id).orElse(null);
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
	public boolean existsByNom(String nom) {
		return repo.existsByNom(nom);
	}
	

	
	
}
