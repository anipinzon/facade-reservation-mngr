package co.edu.poli.facade;

import co.edu.poli.model.Vehicle;

public class VehicleService {
	
	private String url = "http://vehicles:8080/api/v1";	
	private RestClient http = new RestClient(url);
	
	public String getVechicleAvailability(String type) {
		String response = http.get("/vehicles/" + type +"/available");
		System.out.println(response);
		return response;
	}
	
	public Vehicle getVehicle(Long id) {
		System.out.println("Inside service vehicle...");
		try {
			String response = http.get("/vehicles/" + id);
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
