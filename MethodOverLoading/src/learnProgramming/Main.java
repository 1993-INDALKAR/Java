package learnProgramming;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int newScore = calculateScore("Harish",500);
		System.out.println("New SCore is "+ newScore);
		
		calculateScore(400);
		calculateScore();
	}
	
	public static int calculateScore(String playerName,int score) {
		System.out.println("Player "+ playerName + " scored " + score);
		return score * 100;
	}
	
	public static int calculateScore(int score) {
		System.out.println("Unnamed player scored " + score);
		return score * 100;
	}
	
	public static int calculateScore() {
		System.out.println("No Player name, no score");
		return 0;
	}
	
	public static double calcFeetAndInchesToCentimeters(double feet,int inches) {
		if(feet >= 0 && (inches >= 0 && inches<=12)) {
			float centimeter = (float) (feet * 30.48);
			centimeter+= inches*2.54;
			return centimeter;
		}
		
		return -1;
	}
	
	public static double calcFeetAndInchesToCentimeters(int inches) {
		if(inches >= 0 ) {
			double feet = (double) (inches * 0.0833333);
			double centimeter = calcFeetAndInchesToCentimeters(feet, inches);
			return centimeter;
		}
		
		return -1;
	}

}
