package co.edu.poli.facade.fare;

public class MotorcycleFare implements Fare {
	
	public int fare = 15;

	@Override
	public Integer calculateFare(Integer days) {
		System.out.println("Motorcycle Fare");
		return (int) (days * fare);
	}
}
