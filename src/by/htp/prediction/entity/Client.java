package by.htp.prediction.entity;

public class Client implements Comparable<Client>{
	private String name;
	
	
	public Client(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Client client) {
		int result = this.name.compareTo(client.name);
		return result;
	}




}
