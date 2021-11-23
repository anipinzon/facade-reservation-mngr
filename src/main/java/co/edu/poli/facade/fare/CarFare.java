package co.edu.poli.facade.fare;

public class CarFare implements Fare{

	public int fare = 30;
	public Double tax = 1.2;

	@Override
	public Integer calculateFare(Integer days) {
		System.out.println("Car Motorcylce");
		return (int) (days * fare * tax);
	}
}
