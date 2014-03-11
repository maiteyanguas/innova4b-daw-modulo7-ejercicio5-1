package innova4b.ejercicio1;

import org.springframework.context.annotation.*;

@Configuration
public class ApplicationContextConfig {

	@Bean
	public FinderFromText finderFromText(){
		return new FinderFromText("resources/movies1.txt");
	}
	
	@Bean
	public DBConfigurator dbConfigurator(){
		return new DBConfigurator("jdbc:mysql://localhost/movies", "root", "root");
	}
	
}
