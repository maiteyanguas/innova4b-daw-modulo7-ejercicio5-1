package innova4b.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import innova4b.ejercicio1.model.Movie;

@Component
public class FinderFromDB implements Finder {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;


	@Override
	public List<Movie> findAll(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: "+e.getMessage());
		}
		List<Movie> movies = new ArrayList<Movie>();	
		
		try {			
			String connectionUrl = "jdbc:mysql://localhost/movies?user=root&password=root";
			connect = DriverManager.getConnection(connectionUrl);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from movies");			
			movies = writeResultSet(resultSet);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
		return movies;
	}

	private List<Movie> writeResultSet(ResultSet resultSet) throws SQLException {
		List<Movie> movies = new ArrayList<Movie>();
		while (resultSet.next()) {
			Movie movie = new Movie();
			movie.setDirector(resultSet.getString("director"));
			movie.setName(resultSet.getString("name"));
			movies.add(movie);
		}
		return movies;
	}

}
