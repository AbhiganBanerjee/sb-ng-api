package in.spring.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.document.Games;
import in.spring.repository.GamesRepository;

@Service
public class GamesServiceImpl implements GamesService {

	//Inject the repository reference
	@Autowired
	private GamesRepository gamesRepo;
	
	@Override
	public List<String> getAllTheCategories() {
		//Create an String[] of all the categories
		String[] cats = {"In Saree", "Normal Attire", "With Bld(Me)"};
	
		//return this String array as a List
		return Arrays.asList(cats);
	}

	@Override
	public List<Games> getAllTheGames() {
		//Return all the games by calling repo method
		return gamesRepo.findAll();
	}

	@Override
	public Games addNewGame(Games g) {
		//Add new game by repo.save(g) method, then return the inserted obj
		return gamesRepo.save(g);
	}
	
	@Override
	public List<Games> getGamesOnCategory(String category) {
		//Based on category retrieve the books
		if(category.equalsIgnoreCase("all")) {
			//return all games
			return gamesRepo.findAll();
		}else {
			//return the specific category game
			return gamesRepo.findByCategory(category);
		}
	}
}
