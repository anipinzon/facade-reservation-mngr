package co.edu.poli.facade;

import co.edu.poli.model.Vehicle;

public class VehicleService {
	
	private String url;	
	private RestClient http;
	
	public VehicleService() {
		super();
		this.url = "http://vehicles:8080/api/v1";
		this.http = new RestClient(this.url);
	}

	public String getVechicleAvailability(String type) {
		String response = this.http.get("/vehicles/" + type +"/available");
		System.out.println(response);
		return response;
	}
	
	public Vehicle getVehicle(int id) {
		System.out.println("Inside service vehicle...");
		try {
			String response = this.http.get("/vehicles/" + id);
			System.out.println(response);
			Vehicle vehicle = new Vehicle();
			vehicle.setId(id);
			vehicle.setType(response);
			return vehicle;			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	

}
