package innova4b.ejercicio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieListerFromDB extends MovieLister {
	
	@Autowired
	public void setFinderFromDB(FinderFromDB finderFromDB){
		this.finder = finderFromDB;
	}

}
