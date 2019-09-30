package designHashSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class designHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {4,1,-1,2,-1,2,3};
		int k = 2;
		
		 Map<Integer,Integer> freqMap = new HashMap<Integer,Integer>();
	        List<Integer> queueMax = new ArrayList<Integer>();
	        List<Integer> resultMax = new ArrayList<Integer>();
	        
	        for(int i =0;i<nums.length;i++){
	            
	            if(!freqMap.containsKey(nums[i])){
	                freqMap.put(nums[i],1);
	                queueMax.add(nums[i]);
	            }
	            else{
	                int freq = freqMap.get(nums[i]);
	                freq++;
	                freqMap.put(nums[i],freq);
	            }
	            
	            
	        }
	        

	        int maxHeapLength = queueMax.size();
	        
	        for(int i = (maxHeapLength)/2 -1; i>=0; i--){
	            
	            queueMax = maxHeapify(queueMax,i,freqMap);
	            
	        }
	        
	        while(k-->0) {
	        	resultMax.add(queueMax.get(0));
	        	queueMax.remove(0);
	        	queueMax = maxHeapify(queueMax,0,freqMap);
	        }
	        
	        System.out.println(queueMax);
	        System.out.println(freqMap);
	        
//	        return queueMax.subList(0,k);
	        
	        System.out.println(queueMax.subList(0,k));
		
		
	}
	
	static public List<Integer> maxHeapify(List<Integer> queueMax, int i,Map<Integer,Integer> freqMap){
	        int left = (2 * i ) + 1;
	        int right = (2*i) + 2;
	        
	        int largest;
	        
	        if(left < queueMax.size() && freqMap.get(queueMax.get(left)) > freqMap.get(queueMax.get(i)) ){
	            largest  = left;
	        }
	        else{
	            largest = i;
	        }
	        
	        if(right < queueMax.size() && freqMap.get(queueMax.get(right)) > freqMap.get(queueMax.get(largest)) ){
	            largest = right;
	        }
	        
	        if(largest != i){
	            int temp = queueMax.get(i);
	            queueMax.set(i,queueMax.get(largest) );
	            queueMax.set(largest,temp);
	            maxHeapify(queueMax,largest,freqMap);
	        }
	        
	        return queueMax;
	    }
	
	

}
