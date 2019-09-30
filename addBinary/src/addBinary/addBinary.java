package addBinary;

public class addBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a ="11";
		String b ="1";
		
		String result = "";
		int s = 0;
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		
		while(i >= 0 || j>= 0 || s == 1) {
			
			s += ( (i>=0) ? a.charAt(i) - '0' : 0   );
//			System.out.println(a.charAt(i) - '0');
			s += ( (j>=0) ? b.charAt(j) - '0' : 0   );
			
			
			result = (char)(s % 2 + '0') + result; 
			  
            // Compute carry 
            s /= 2; 
  
            // Move to next digits 
            i--; j--; 
			
		}
		
		
       System.out.println(result);
     
        
   
	}
	


}

 
