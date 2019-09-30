package moveZero;

import java.util.*;

public class moveZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0,1,0,3,12};
		
//		 List<int> numsList = new ArrayList<int>();
		
int count = 0;
        
        for(int i =0;i< nums.length;i++){
            
            if(nums[i] != 0){
                nums[count] = nums[i];
                count++;
            }
            
        }
        
     
        
        while(count < nums.length){
            nums[count++] = 0;
        }
        
        
//        numsList = Arrays.asList(nums);
        
        System.out.println(Arrays.toString(nums));
        
        
        
		
		
	}

}
