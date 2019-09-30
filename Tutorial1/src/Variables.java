import java.util.Arrays;
import java.util.Scanner;

public class Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String name = "Harish";
		
		System.out.println("Hello World " + name);
		
		int age = 67;
		
		System.out.println(name + " is " + age + " years old.");
		
		double distance = 56.4;
		
		System.out.println(name + " walked " + distance + " km this morning.");
		
		int inch = 1000;
		double convMeter = 0.0254;
		
		double meter = inch * convMeter;
		System.out.println("Conversion of "+inch+ " inch to meter is "+meter+".");
		
		int odd = 1;
		int sum = 0;
		for(int i = 1;i<=5;i++) {
			sum +=odd;
			System.out.println("Odd number "+ i+" is:"+odd);
			odd +=2;
			
		}
		
		System.out.println("Sum of Odd number is "+sum);
		
		System.out.println("Pattern:");
		
		int num = 1;
		
		for(int i =0;i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
		
		switch("Hi") {
		case "Hi":
			System.out.println("He said Hi.");
			break;
		case "Hello":
			System.out.println("He said Hello.");
			break;
		default:
			System.out.println("He said nothing");
		}
		
		
		String month = "December";
		
		switch(month) {
		case "January":
		case "March":
		case "May":
		case "July":
		case "August":
		case "October":
		case "December":
			System.out.println(month + " has 31 days");
		    break;
		case "April":
		case "June":
		case "September":
		case "November":
			System.out.println(month + " has 30 days.");
			break;
		case "February":
			System.out.println(month + " has 29 days when year is leap and 28 days when year is not leap.");
			break;
		default:
			System.out.println("There is no such month "+ month+".");
		}
		
		
		int[] numbers = {1,45,32,78,54};
		
		num = 54;
		boolean flag = false;
		for(int i=0;i<numbers.length;i++) {
			if(numbers[i]==num) {
				System.out.println(num+" is present in Array.");
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println(num+" is not present in Array.");
		}
		
		int[] numbersCopy = new int[numbers.length];
		int min = numbers[0], max = numbers[0];
		
		for(int i =0;i<numbers.length;i++) {
			
			numbersCopy[i]=numbers[i];
			
			if(min> numbers[i] && i > 0) {
				min = numbers[i]; 
			}
			
			if(max < numbers[i]  && i > 0) {
				max = numbers[i];
			}
		}
		
		System.out.println("Array copied is:" );
		printArray(numbersCopy);
		System.out.println("Minimum nunber in Array is "+min);
		
		System.out.println("Maximum nunber in Array is "+max);
		
		
		System.out.println("Please enter your name:");
		String firstName = sc.nextLine();
		System.out.println("Please enter your age " + firstName+":");
	    age = sc.nextInt();
		System.out.println("Hi "+ firstName+" you are "+ age+" years old.");
		
		
		System.out.println("Please enter length of rectangle:");
		int length = sc.nextInt();
		System.out.println("Please enter breath os rectangle:");
		int breath = sc.nextInt();
		int area = length * breath;
		System.out.println("Area of rectangle is "+ area+".");
		
		double num1 = 56.254;
		double num2 = 5768.87;
		double min1 = minNumber(num1,num2);
		if(min1 == -1) {
			System.out.println("Given numbers "+ num1 + " and "+num2+" both are equal.");
		}
		else {
			System.out.println("Minimum number between "+ num1+" and "+ num2 +" is "+ min1+".");	
		}
		
		
		
		int[] arr1 = {1,2,3};
		int arr2[] = arr1.clone();
		arr1[1] = 10;
		for(int i =0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		
		System.out.println(arr2 == arr1);
		
		System.out.println(Arrays.equals(arr1, arr2));
		System.out.println(Arrays.toString(arr1));
		
		final int arr3[] = {3,5,6};
		int arr4[] = {6,7,8};
		arr4 = arr3;
		arr3[1] = 'a';
		System.out.println("arr[3]" + Arrays.toString(arr3));
		byte b = 10;
		System.out.println("b" + b);
		
		
		
		System.out.print("User input = ");
		int input = sc.nextInt();
		
	}
	
	 static void printArray(int[] array){
		 
		 for(int i=0;i<array.length;i++) {
			 System.out.print(array[i]+" ");
		 }
			System.out.println();
		}
	 
	 static double minNumber(double num1,double num2) {
		 if(num1 == num2) {
			 return -1;
		 }
		 else if(num1 < num2) {
			 return num1;
		 }
		 else {
			 return num2;
		 }
	 }

}
