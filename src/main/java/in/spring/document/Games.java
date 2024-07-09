package in.spring.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "mine")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Games{
	@Id
	private String _id;
	private String title;
	private String category;
	private String image;
}
