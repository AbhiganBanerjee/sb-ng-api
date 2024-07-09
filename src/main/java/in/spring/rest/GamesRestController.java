package in.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.spring.document.Games;
import in.spring.service.GamesService;

@RestController
public class GamesRestController {
	
	//Inject the Service reference in here
	@Autowired
	private GamesService service;
	
	//Create a GET Mapped method to get all categories
	@GetMapping("/getCategories")
	public List<String> getCategories(){
		//call the service method
		return service.getAllTheCategories();
	}
	
	//Create a GET mapped method to get all the Games
	@GetMapping("/getGames")
	public List<Games> getGames(){
		//call the service get games method
		return service.getAllTheGames();
	}
	
	//Create a POST Mapped method to insert new games
	@PostMapping("/addGame")
	public ResponseEntity<String> addGame(@RequestBody Games g){
		System.out.println(g);
		
		//Now call the service add method
		Games newG = service.addNewGame(g);
		
		//validate the result
		if(newG.get_id()!=null) {
			return new ResponseEntity<String>("Inserted..",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Failed!!",HttpStatus.BAD_GATEWAY);
		}
	}
	
	//Create another GET method to get games on category
	//it takes the category as Query Param
	@GetMapping("/onCategoryGames")
	public List<Games> onCategoryGames(@RequestParam(name = "category") String category){
		System.out.println(category);
		
		//call the service method
		return service.getGamesOnCategory(category);
	}
}
