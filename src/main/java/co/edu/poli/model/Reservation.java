package co.edu.poli.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "reservation")
public class Reservation {
	
	private String id;
	
	private String username;
	
	private Integer days;
	
	@Field(name = "id_vehicle")
	private int idVehicle;
	
	private int price;
	
	private String status;
	
	public Reservation(String username, Integer days, int idVehicle) {
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

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", username=" + username + ", days=" + days + ", idVehicle=" + idVehicle
				+ ", price=" + price + ", status=" + status + "]";
	}
	
	
	

}
