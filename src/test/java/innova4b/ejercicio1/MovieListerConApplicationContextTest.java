package innova4b.ejercicio1;

import static org.junit.Assert.*;
import innova4b.ejercicio1.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:innova4b/ejercicio1/application-context.xml")
public class MovieListerConApplicationContextTest {
	
	GenericApplicationContext context;
	
	@Before
	public void setUp() {
		context = new GenericApplicationContext();  
	    XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);  
	    xmlReader.loadBeanDefinitions(new ClassPathResource("innova4b/ejercicio1/application-context.xml"));  
	    context.refresh();  
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
