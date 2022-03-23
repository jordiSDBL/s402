package cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n02.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n02.domain.Fruita;
import cat.itacademy.barcelonactiva.sedo.bulpe.jordi.s04.t02.n02.services.FruitaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	private FruitaService fruitaservice;
	
	/**
	 * Retorna una fruita segons id per PathVariable
	 * @param idFruita
	 * @return
	 * @throws IOException 
	 */
	@GetMapping("/detallfruita/{idFruita}")
	public ResponseEntity<?> detallarFruita(@PathVariable("idFruita") int idFruita) {
		
		if(!fruitaservice.existeixIdFruita(idFruita)) {	
			return new ResponseEntity<>("No hi ha cap fruita amb aquest id.", HttpStatus.NOT_FOUND);
		}
		
		Optional<Fruita> fruitaOpt = fruitaservice.mostrarFruita(idFruita);
		return new ResponseEntity<Optional<Fruita>>(fruitaOpt, HttpStatus.OK);
	}
	
	/**
	 * Afegeix fruita a la BBDD segons header per RequestBody
	 * @param fruita
	 * @return
	 */
	@PostMapping("/afegirFruita")
	public ResponseEntity<?> afegirFruita(@RequestBody Fruita fruita){
		
		if(fruita.getNom().isBlank())
            return new ResponseEntity<>("És necessari introduir un nom.", HttpStatus.BAD_REQUEST);

        if(fruita.getQttQuilos()<0 || (Integer) fruita.getQttQuilos() == null)
            return new ResponseEntity<>("La quantitat no pot ser inferior a 0.", HttpStatus.BAD_REQUEST);
        
        if(fruitaservice.existsByNom(fruita.getNom()))
            return new ResponseEntity<>("Ja existeix una fruita amb aquest nom.", HttpStatus.BAD_REQUEST);
        
        if(fruitaservice.existeixIdFruita(fruita.getIdFruita()))
            return new ResponseEntity<>("Ja existeix una fruita amb aquest id.", HttpStatus.BAD_REQUEST);

        fruita = new Fruita(fruita.getNom(), fruita.getQttQuilos());
        fruitaservice.desarFruita(fruita);
        return new ResponseEntity<>(fruita.getNom() + " s'ha afegit correctament.", HttpStatus.OK);
		
	}
	
	/**
	 * Esborra fruita de la BBDD segons id per PathVariable
	 * @param idFruita
	 * @return
	 */
	@PostMapping("/esborrarfruita/{idFruita}")
	public ResponseEntity<?> esborrarfruita(@PathVariable("idFruita") int idFruita ){
		
		if(!fruitaservice.existeixIdFruita(idFruita)) {	
			return new ResponseEntity<>("Aquesta fruita no és en estoc.", HttpStatus.NOT_FOUND);
		}
		Optional<Fruita> fruitaOpt = fruitaservice.mostrarFruita(idFruita);
		fruitaservice.esborrarFruita(fruitaOpt.get().getIdFruita());

		
		
		return new ResponseEntity<>(fruitaOpt.get().getNom() + " s'ha esborrat correctamet.", HttpStatus.OK);
	}
	
	/**
	 * Retorna totes les fruites que hi ha a la BBDD
	 * @return
	 */
	@GetMapping("/mostrarfruites")
	public ResponseEntity<?> mostrarfruites() {
		if(fruitaservice.mostrarTotesFruites().isEmpty()) {
			return new ResponseEntity<>("La llista és buida.", HttpStatus.OK);
		}
		return new ResponseEntity<List<Fruita>>(fruitaservice.mostrarTotesFruites(), HttpStatus.OK);
	}

	/**
	 * Canvia dades d'una fruita segons hearder per RequestBody
	 * @param fruita
	 * @return
	 */
	@PutMapping("/actualitzarfruita")
	public ResponseEntity<?> actualitzarfruita(@RequestBody Fruita fruita){
		
		if(!fruitaservice.existeixIdFruita(fruita.getIdFruita())) {	
			return new ResponseEntity<>("No hi ha cap fruita amb aquest id.", HttpStatus.BAD_REQUEST);
		}
		
		fruitaservice.desarFruita(fruita);
		return new ResponseEntity<>("La fruita s'ha actualitzat correctament.", HttpStatus.OK);
	}
	
	
	
}
