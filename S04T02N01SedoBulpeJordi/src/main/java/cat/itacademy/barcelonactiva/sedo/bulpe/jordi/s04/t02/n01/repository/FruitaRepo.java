package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n01.domain.Fruita;

@Repository
public interface FruitaRepo extends JpaRepository<Fruita, Integer>{

	boolean existsByNom(String nom);
	
}
