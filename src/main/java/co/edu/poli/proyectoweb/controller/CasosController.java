package co.edu.poli.proyectoweb.controller;

import co.edu.poli.proyectoweb.model.Casos;
import co.edu.poli.proyectoweb.model.User;
import co.edu.poli.proyectoweb.repository.CasosRepository;
import co.edu.poli.proyectoweb.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Class: CasosController"})
@RestController // Defines that this class is a spring bean
@RequestMapping("/proyecto")
public class CasosController {
	
	
	// Tells the application context to inject an instance of BookRespository here
	@Autowired
	private CasosRepository casosRepository;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/casos")
	@ApiOperation(value = "*** Service Method Get All Casos ***", notes = "*** Get All Casos from MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Casos!!! ***")})
	public List<Casos> getAllCasos() {
		// The BookRepository is already injected and you can use it

		return casosRepository.findAll();
	}


	@GetMapping("/caso/{id}")
	@ApiOperation(value = "*** Service Method Get Caso by Id ***", notes = "*** Get from MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get Caso!!! ***")})
	public Casos getCasoById(@PathVariable Integer id) {
		Casos casos =  casosRepository.findById(id).get();
		System.out.println(casos);
		return casos;
	}
	
	@PostMapping("/caso")
	@ApiOperation(value = "*** Service Method Post New Caso ***", notes = "*** Create New Caso into MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error ***")})
	public Casos createCaso(@RequestBody Casos caso) {
		return casosRepository.save(caso);
	}

	@PutMapping("/casos/{id}")
	@ApiOperation(value = "*** Service Method Put Caso ***", notes = "*** Update Caso into MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Update Error  ***")})
	public Casos updateCaso(@PathVariable Integer id, @RequestBody Casos casoNew) {
		Casos casodb = casosRepository.findById(id).get();

		casodb.setCaso(casoNew.getCaso());

		casosRepository.save(casodb);
		return casodb;
	}
	
	@DeleteMapping("/caso/{id}")
	@ApiOperation(value = "*** Service Method Delete Caso ***", notes = "*** Delete Caso from MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Delete Error - CasoId ***")})
	public Casos deleteCaso(@PathVariable Integer id) {
		Casos casodb = casosRepository.findById(id).get();
		casosRepository.deleteById(id);
		return casodb;
	}
	
	//Query
	@GetMapping("/casos/{UserId}")
	@ApiOperation(value = "*** Service Method Get All Casos from User ***", notes = "*** Get All Casos from UserID\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Get Error - UserID not Found  ***")})
	public List<Casos> getfindByUserId(@PathVariable Integer UserId) {
		return casosRepository.findByUserId(UserId);
	}

	
	//Load List of Books
	@PostMapping("/casos")
	@ApiOperation(value = "*** Service Method Post List of Casos ***", notes = "***  Post List of Casos into MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Put Error ***")})
	public String createCasosList(@RequestBody List<Casos> casos) {
		casosRepository.saveAll(casos);
		return "done";
	}

	@PutMapping("/caso/{idUsuario}/{idCaso}")
	@ApiOperation(value = "*** Service Method Put to associate ***", notes = "***  Associate Caso with User into MySQL\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Put Error - UserID or CasoId not found ***")})
	public Casos associate(@PathVariable int idUsuario, @PathVariable int idCaso) {

		Casos caso = casosRepository.findById(idCaso).get();
		User user = userRepository.findById(idUsuario).get();

		caso.setUser(user);

		casosRepository.save(caso);
		return caso;
	}
	
}
