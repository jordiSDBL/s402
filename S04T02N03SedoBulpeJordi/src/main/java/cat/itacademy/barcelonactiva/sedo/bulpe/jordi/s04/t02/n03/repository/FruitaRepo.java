package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n03.repository;



//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n03.domain.Fruita;

@Repository
public interface FruitaRepo extends MongoRepository<Fruita, Integer>{
	
	Fruita findByNom(String nom);

}

