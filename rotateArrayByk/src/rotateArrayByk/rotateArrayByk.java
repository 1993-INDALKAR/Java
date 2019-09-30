package rotateArrayByk;
import java.util.Arrays;

public class rotateArrayByk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3,4,5,6,7};
		
		int k = 3;
		
int len = nums.length - k;
        
        nums = rotateArray(nums,0,len);
        
        nums = rotateArray(nums,len,nums.length);
        
        nums = rotateArray(nums,0,nums.length);
        
        System.out.println(Arrays.toString(nums));

	}
	
	
static int[] rotateArray(int[] nums,int start, int end){
        
        int i = start;
        int j = end-1;
        
        for( ; i < j ; i++,j--){
            
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[i] ^ nums[j];
            
        }
        
        return nums;
        
    }

}
