package innova4b.ejercicio1;

public class DBConfigurator {
	
	String url;
	String user;
	String password;
		
	public DBConfigurator(String url, String user, String password){
		this.url=url;
		this.user=user;
		this.password=password;
	}
	
	public String getConnectionUrl(){		
		String connectionUrl = this.url+"?user="+this.user+"&password="+this.password;
		return connectionUrl;
	}
	


}
