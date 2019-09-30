
public class vehicle {
	
	int noofGears;
	String color;
	int wheels;
	int seats;
	String vehicleType;
	String brand;
	
	vehicle(){
		System.out.println("The vehicle is in production now and its default color is white.");
		this.color = "white";
	}
	
	vehicle(String brand){
		this.brand = brand;
		System.out.println("Brand of your vehicle is "+this.brand + ".");
	}

	void setGear(int gear) {
		this.noofGears = gear;
	}
	
	void setColor(String color) {
		this.color = color;
	}
	
	void setWheels(int wheel) {
		this.wheels = wheel;
	}
	
	void setSeats(int seat) {
		this.seats = seat;
	}
	
	void setType(String type) {
		this.vehicleType = type;
	}
	
	void printDetails() {
		System.out.println("Vehicle " + this.vehicleType + " has "+ this.noofGears +" gears, "+
						   this.wheels+" wheels, " + this.seats + " seats and it is "+
				           this.color + " in colour.");
	}


	
	
	
	
	
	

}
