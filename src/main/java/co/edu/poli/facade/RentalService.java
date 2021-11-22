package co.edu.poli.facade;

public class RentalService {
	
	private String url = "http://rental:8080/api/v1";	
	private RestClient http = new RestClient(url);
	
	public String publishToRental(String reservationId) {
		String reservation = "{}";
		String response = http.post("/rental", reservation );
		System.out.println(response);
		return response;
	}

}
