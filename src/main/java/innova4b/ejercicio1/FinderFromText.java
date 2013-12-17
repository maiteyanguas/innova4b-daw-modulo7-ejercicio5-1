package innova4b.ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import innova4b.ejercicio1.model.Movie;

public class FinderFromText implements Finder {

	private String texto;

	public FinderFromText(String texto) {
		this.texto = texto;
	}

	@Override
	public List<Movie> findAll() {
		ObjectMapper mapper = new ObjectMapper();
		List<Movie> movies = new ArrayList<Movie>();
		try {
			movies = mapper.readValue(new File(texto), new TypeReference<List<Movie>>() {});
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return movies;

	}

}
