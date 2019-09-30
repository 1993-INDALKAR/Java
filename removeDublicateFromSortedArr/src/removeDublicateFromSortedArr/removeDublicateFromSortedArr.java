package removeDublicateFromSortedArr;

public class removeDublicateFromSortedArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		int len = nums.length;
		
		int j = 0;
		
		for(int i =0;i< len-1;i++) {
			
			if(nums[i] != nums[i+1]) {
				nums[j++] = nums[i];
			}
			
			
		}
		
		nums[j++] = nums[len-1];
		
//		return nums.length;
		
		System.out.println(nums.length);

	}

}
