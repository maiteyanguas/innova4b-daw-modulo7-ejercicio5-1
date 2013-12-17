package innova4b.ejercicio1;

import java.util.Iterator;
import java.util.List;

import innova4b.ejercicio1.model.Movie;


public class MovieLister {
	private Finder finder;
	
	public void setFinder(Finder finder) {
		this.finder = finder;
	}

//	public MovieLister(){
//		finder = new FinderFromText("movies.txt");
//	}

	public Movie[] moviesDirectedBy(String director){
		
		List<Movie> allMovies = finder.findAll();
		Iterator<Movie> it = allMovies.iterator();
		
		while (it.hasNext()){
			if (!it.next().getDirector().equals(director))
				it.remove();
		}		
		return allMovies.toArray(new Movie[allMovies.size()]);
	}
}
