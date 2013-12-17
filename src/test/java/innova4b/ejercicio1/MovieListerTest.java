package innova4b.ejercicio1;

import static org.junit.Assert.*;

import innova4b.ejercicio1.model.Movie;

import org.junit.Before;
import org.junit.Test;


public class MovieListerTest {
	
	MovieLister movieLister;
	
	@Before
	public void setUp() {
		movieLister	= new MovieLister();		
	}

	@Test
	public void encuentra_las_peliculas_en_un_archivo() {
		Finder finder = new FinderFromText("resources/movies1.txt");
		movieLister.setFinder(finder);
		Movie[] movies = movieLister.moviesDirectedBy("Almodovar");
		assertEquals(2, movies.length);
	}
	
	@Test
	public void encuentra_las_peliculas_en_la_BD(){
		FinderFromDB finder = new FinderFromDB();
		finder.setUrl("jdbc:mysql://localhost/movies");
		finder.setUser("root");
		finder.setPassword("root");
		movieLister.setFinder(finder);
		Movie[] movies = movieLister.moviesDirectedBy("Kubrik");
		assertEquals(3, movies.length);
	}

}
