package co.edu.poli.proyectoweb.controller;

import co.edu.poli.proyectoweb.model.Casos;
import co.edu.poli.proyectoweb.model.User;
import co.edu.poli.proyectoweb.repository.CasosRepository;
import co.edu.poli.proyectoweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/proyecto")
public class CasosController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private CasosRepository casosRepository;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/casos")
	public List<Casos> getAllBooks() {
		// The BookRepository is already injected and you can use it
		return casosRepository.findAll();
	}

	@GetMapping("/caso/{id}")
	public Casos getCasoById(@PathVariable Integer id) {
		Casos casos =  casosRepository.findById(id).get();
		return casos;
	}
	
	@PostMapping("/caso")
	public Casos createCaso(@RequestBody Casos caso) {
		return casosRepository.save(caso);
	}

	@PutMapping("/casos/{id}")
	public Casos updateBook(@PathVariable Integer id, @RequestBody Casos casoNew) {
		Casos casodb = casosRepository.findById(id).get();

		casodb.setId(casoNew.getId());
		casodb.setCaso(casoNew.getCaso());

		casosRepository.save(casodb);
		return casodb;
	}
	
	@DeleteMapping("/caso/{id}")
	public Casos deleteCaso(@PathVariable Integer id) {
		Casos casodb = casosRepository.findById(id).get();
		casosRepository.deleteById(id);
		return casodb;
	}
	
	//Query
	@GetMapping("/casos/{UserId}")
	public List<Casos> getfindByUserId(@PathVariable Integer UserId) {
		return casosRepository.findByUserId(UserId);
	}

	
	//Load List of Books
	@PostMapping("/casos")
	public String createEmployeeList(@RequestBody List<Casos> casos) {
		casosRepository.saveAll(casos);
		return "done";
	}

	@PutMapping("/caso/{idUsuario}/{idCaso}")
	public Casos associate(@PathVariable int idUsuario, @PathVariable int idCaso) {

		Casos caso = casosRepository.findById(idCaso).get();
		User user = userRepository.findById(idUsuario).get();

		caso.setUser(user);

		casosRepository.save(caso);
		return caso;
	}
	
}
