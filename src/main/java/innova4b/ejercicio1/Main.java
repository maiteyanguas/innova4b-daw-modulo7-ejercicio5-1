package innova4b.ejercicio1;



import innova4b.ejercicio1.model.Movie;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("innova4b.ejercicio1");
		context.refresh();
		MovieLister movieLister = context.getBean(MovieListerFromDB.class);
		Movie[] movies = movieLister.moviesDirectedBy("Kubrik");
		System.out.println(movies[0].getName());
	}
}