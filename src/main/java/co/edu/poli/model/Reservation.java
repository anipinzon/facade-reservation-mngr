package co.edu.poli.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "reservation")
public class Reservation {
	
	private String id;
	
	private String username;
	
	private Integer days;
	
	@Field(name = "id_vehicle")
	private Long idVehicle;
	
	private int price;
	
	private String status;
	
	public Reservation(String username, Integer days, Long idVehicle) {
		super();
		this.username = username;
		this.days = days;
		this.idVehicle = idVehicle;
		this.price = 0;
		this.status = "CREATED";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	

}
