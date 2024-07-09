package in.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.spring.document.Games;
import java.util.List;


public interface GamesRepository extends MongoRepository<Games,String> {
	//create a findBy method to find games on category
	List<Games> findByCategory(String category);
}
