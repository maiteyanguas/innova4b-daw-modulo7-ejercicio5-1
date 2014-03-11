package innova4b.ejercicio1;

import static org.junit.Assert.assertEquals;
import innova4b.ejercicio1.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:innova4b/ejercicio1/application-context.xml")
public class MovieListerConApplicationContextTest {
	
	ApplicationContext context;
	
	@Before
	public void setUp() {
		context = new ClassPathXmlApplicationContext("innova4b/ejercicio1/application-context.xml");
	}

	@Test
	public void encuentra_las_peliculas_en_un_archivo() {
		MovieLister movieLister = context.getBean("movieListerFromText", MovieLister.class);
		Movie[] movies = movieLister.moviesDirectedBy("Almodovar");
		assertEquals(2, movies.length);
	}
	
	@Test
	public void encuentra_las_peliculas_en_la_BD(){
		MovieLister movieLister = context.getBean("movieListerFromDB", MovieLister.class);
		Movie[] movies = movieLister.moviesDirectedBy("Kubrik");
		assertEquals(3, movies.length);
	}

}
