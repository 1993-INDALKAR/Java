package learnProgramming;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int result = 1+2;
		System.out.println(result);
		
		int previousResult = result;
		System.out.println(previousResult);
		
		result = result + 45;
		System.out.println(result);
		System.out.println(previousResult);
		
		result = result * 20;
		System.out.println(result);
		
		result++;
		
		boolean isAlien = false;
		if(isAlien == true)
			System.out.println("It is not an alien!");
			System.out.println("I am scared of Aliens.");
	
		int topScore = 80;
		if(topScore == 100) {
			System.out.println("You got the high score!");
		}
		
		int secondTopScore = 60;
		if(topScore < 100 && topScore > secondTopScore) {
			System.out.println("Greater than second top score and less than 100");
		}
		
		
		if((topScore > 90) || (secondTopScore <=90) ) {
			System.out.println("Either or both of the Conditions are true");
			
		boolean isCar = false;
		if(isCar == true) {
			System.out.println("It is a Car.");
		}
		
		boolean wasCar = isCar ? true : false;
		System.out.println(wasCar);
		
		int myVariable = 50;
		if(myVariable == 50); myVariable = 60; System.out.println("myVariable value is "+myVariable);
		
		}
		
	}

}