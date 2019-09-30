package minSubArrSum;

public class minSumSubArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {5,1,3,5,10,7,4,9,2,8};
		
//		int[] nums = {2,3,1,2,4,3};
		
//		int s = 7;
		
		int s = 15;
		
		
int minLength = nums.length + 1;
        
        int start = 0;
        int end = 0;
        
        int sum = 0;
        
       
        
        int len = nums.length;
        
       
        for(; start > len;start++) {
        	
        	sum += nums[start];
        	
        	while(sum >= s) {
        		sum -= nums[end];
        		end++;
        	}
        }
        
       System.out.print(minLength);

	}

}
