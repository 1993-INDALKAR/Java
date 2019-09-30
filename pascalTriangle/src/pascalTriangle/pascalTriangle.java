package pascalTriangle;

import java.util.List;
import java.util.*;

public class pascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rowIndex = 8;
		
		int r = 0;
     		int   num = rowIndex;
     		   int cur = 1;
		
		List<Integer> pascalRow = new ArrayList<Integer>();
		
		pascalRow.add(1);
        
        for(int i = 0;i<rowIndex;i++){
            
//            pascalRow.add( (int) Math.pow(2,i)  );
        	
        	 r+=1;
        	 
        	 cur = (cur* num)/r;
        	 
        	pascalRow.add( cur );
        	
        	num -= 1;
            
        }
        
      
        System.out.println( pascalRow );
		
	}

}
