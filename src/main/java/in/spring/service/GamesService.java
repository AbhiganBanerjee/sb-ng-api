package in.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.spring.document.Games;

@Service
public interface GamesService {
	//Add business requirement methods 
	
	//Method to getAll the categories
	List<String> getAllTheCategories();
	
	//Method to getAll the Games
	List<Games> getAllTheGames();
	
	//Method to add the new game
	Games addNewGame(Games g);
	
	//Method to retrieve games based on Categories
	List<Games> getGamesOnCategory(String category);
}
