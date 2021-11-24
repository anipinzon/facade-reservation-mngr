package co.edu.poli.facade;

public class RentalService {
	
	private String url;	
	private RestClient http;
		
	
	public RentalService() {
		super();
		this.url = "http://rental:8080/api/v1";
		this.http = new RestClient(this.url);
	}

	public String publishToRental(String reservationId) {
		String reservation = "{}";
		String response = http.post("/rental", reservation );
		System.out.println(response);
		return response;
	}

}
