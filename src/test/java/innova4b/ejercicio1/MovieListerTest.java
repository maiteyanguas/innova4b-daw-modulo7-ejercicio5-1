package innova4b.ejercicio1;

import static org.junit.Assert.*;

import innova4b.ejercicio1.model.Movie;

import org.junit.Test;


public class MovieListerTest {


	@Test
	public void encuentra_las_peliculas_en_un_archivo() {
		MovieListerFromText movieListerFromText = new MovieListerFromText();
		FinderFromText finderFromText = new FinderFromText("resources/movies1.txt");
		movieListerFromText.setFinderFromText(finderFromText);
		Movie[] movies = movieListerFromText.moviesDirectedBy("Almodovar");
		assertEquals(2, movies.length);
	}
	
	@Test
	public void encuentra_las_peliculas_en_la_BD(){
		MovieListerFromDB movieListerFromDB = new MovieListerFromDB();
		FinderFromDB finderFromDB = new FinderFromDB();
		movieListerFromDB.setFinderFromDB(finderFromDB);
		Movie[] movies = movieListerFromDB.moviesDirectedBy("Kubrik");
		assertEquals(3, movies.length);
	}

}
