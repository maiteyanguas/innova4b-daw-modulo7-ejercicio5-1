package innova4b.ejercicio1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieListerFromText extends MovieLister {
	
	@Autowired
	public void setFinderFromText(FinderFromText finderFromText){
		this.finder = finderFromText;
	}

}
