package longCommnPrefix;

public class longComnPref {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strArr = {"flower","flow","flight"};
		
		String min = findMin(strArr);
        
        String lonComPref = findLongCommnPrefix(strArr,min); 
        
        System.out.println(lonComPref);

	}
	
 static String findLongCommnPrefix(String[] arr,String min){
        
        for(int i =0; i< arr.length;i++) {
        	if(!arr[i].startsWith(min)) {
        		min = min.substring(0, min.length()-1);
        		min = findLongCommnPrefix(arr, min);
        	}
        }
        
        return min;
        
    }
    
    static String findMin(String[] arr){
        
        int len = arr.length;
        
        int min = arr[0].length();
        
        String str = arr[0];
        
        for(int i=1;i<len;i++){
            
            if(arr[i].length() < min){
                min = arr[i].length();
                str = arr[i];  
            }
        }
        
        return str;
        
    }

}
