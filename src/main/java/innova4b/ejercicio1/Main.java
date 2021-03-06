package innova4b.ejercicio1;



import innova4b.ejercicio1.model.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("innova4b/ejercicio1/application-context.xml");
		 MovieLister movieLister = context.getBean("movieListerFromText", MovieLister.class);
		 Movie[] movies = movieLister.moviesDirectedBy("Almodovar");
		 System.out.println(movies[0].getName());
	}

}
