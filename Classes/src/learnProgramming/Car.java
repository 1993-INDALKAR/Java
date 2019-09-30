package learnProgramming;

public class Car {
	public int doors = 2;
	private int wheels;
	private String model;
	private String engine;
	private String colour;
	
	public void setMode(String model) {
		String validModel = model.toLowerCase();
		if(validModel.equals("carrera") || validModel.equals("commondore")) {
			this.model = model;
		}
		else {
			this.model = "Unknown";
		}
		
	}
	
	public String getModel() {
		return this.model;
	}
	
	
}
