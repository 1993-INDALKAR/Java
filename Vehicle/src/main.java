
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		vehicle car = new vehicle("Lamborgini");
		car.setColor("black");
		car.setGear(5);
		car.setSeats(7);
		car.setWheels(4);
		car.setType("car");
		car.printDetails();
		
//		vehicle bike = new vehicle("BMW");
		vehicle bike = new vehicle();
		bike.setColor("red");
		bike.setGear(5);
		bike.setSeats(2);
		bike.setWheels(2);
		bike.setType("bike");
		bike.printDetails();
	}

}
