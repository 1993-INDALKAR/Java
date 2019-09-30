

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class huffman{
	
	public static char freqArray1[];
	public static int freqArray[];
	
	
	public static void main(String[] args){

     try {
    	 FileReader fr = new FileReader("infile.dat");
    	 FileWriter fw = new FileWriter("outfile.dat");

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);
         
         StringBuffer strbuf = new StringBuffer("");
         String str = strbuf.toString();

           int i = 0;
           String finalStr = "";

           while((i=br.read())!=-1) {
        	   str = str + String.valueOf((char)i);
             }
		   
           str = str.replaceAll("\\W", "");
           finalStr = str;
           
		   char StrArr[] = finalStr.toCharArray();
		   
TreeMap<Character, Integer> hs = new TreeMap<Character, Integer>();
		   
		   for(int ij=0; ij<StrArr.length; ij++)
		   {
			   if(!hs.containsKey(StrArr[ij]))
			   {
				   hs.put(StrArr[ij], 1);
			   }
			   else
			   {
				   int counter = hs.get(StrArr[ij]);
				   counter = counter+1;
				   
				   hs.put(StrArr[ij], counter);
			   }
		   }
		   	   
		   freqArray1 = new char[hs.size()];
		   freqArray = new int[hs.size()];
		   
		   int iot = 0;
		   for(char io : hs.keySet())
		   {
			   
			   freqArray1[iot] = io;
			   freqArray[iot] =  hs.get(io);
			   
			   
			   iot++;
		   }
		  
		   
		   int count3 = 1;
		   int count4 = 2;
		   
		   while(count3 != count4)
		   {
			   count3 = count4;
			   
			   for(int ok = 0; ok<freqArray.length-1; ok++)
			   {
				   if(freqArray[ok] > freqArray[ok+1])
				   {
					   int temp = freqArray[ok];
					   freqArray[ok] = freqArray[ok+1];
					   freqArray[ok+1] = temp;
					   
					   char temp1 = freqArray1[ok];
					   freqArray1[ok] = freqArray1[ok+1];
					   freqArray1[ok+1] = temp1;
					   count4++;
				   }
			   }
		   }
		   
		 
		   int similar1 = 0;
		   int similar2 = 0;
		   		   
		   while(similar2 < freqArray.length-1)
		   {
		
		   while(freqArray[similar1] == freqArray[similar2] && similar2 < freqArray.length-1)
		   {
			   similar2++;
		   }
		   
		   sortArr(similar1, similar2-1);
		   
		   similar1 = similar2;
			   
		   }
		   
	   HuffTree finalTree = HuffmanCode.buildTree(freqArray, freqArray1);
		   
		   StringBuffer s = new StringBuffer();
		   s.append("");
		   HuffmanCode.showhuffmancode(finalTree, s); 
   
		
		String[] FinalStr = HuffmanCode.d.toString().split(" ");
		int[] FrequencyArr = new int[StrArr.length];
		String[] SymbolArr = new String[StrArr.length];
		String[] codeArr = new String[StrArr.length];
		
		int count = 0;
		int n;

		for(n = 0; n<FinalStr.length; n++)
		{
			
			if((n % 3) == 0)
			{
				SymbolArr[count/3] = FinalStr[n];
			}
			
			if((n % 3) == 1)
			{
				FrequencyArr[count/3] = Integer.parseInt(FinalStr[n]);
			}
			
			if((n % 3) == 2)
			{
				codeArr[count/3] = FinalStr[n];
			}
		
			count++;
		}

		
		String temp = "";
		String temp1 = "";
		
		int count1=0;
		int count2 = 1;
		
		
		while(count1!=count2)
		{
			count1 = count2;
		for(int k=0; k<FrequencyArr.length; k++)
		{
			if(k+1 < FrequencyArr.length)
			{
			if(FrequencyArr[k] > FrequencyArr[k+1])
			{
				FrequencyArr[k] ^= FrequencyArr[k+1];
				FrequencyArr[k+1] ^= FrequencyArr[k];
				FrequencyArr[k] ^= FrequencyArr[k+1];
				
				temp = SymbolArr[k];
				SymbolArr[k] = SymbolArr[k+1];
				SymbolArr[k+1] = temp;
				
				temp1 = codeArr[k];
				codeArr[k] = codeArr[k+1];
				codeArr[k+1] = temp1;
				
				count2++;
				
			}
			}
			
		}
		}
         
		int sum = 0;
		
		for(int k=0; k<FrequencyArr.length; k++)
		{
			sum = sum+FrequencyArr[k];
		}
		
		for(int h=FrequencyArr.length-1; h>=0; h--)
		{
			
			if(SymbolArr[h]!=null && h<FrequencyArr.length-1)
			{
				bw.write("\n");
				
			}
			
			if(SymbolArr[h]!=null)
			{
			bw.write(SymbolArr[h]);
			bw.write(" ");
			}
						
			if(FrequencyArr[h] > 0)
			{
				
				float num = ((float)FrequencyArr[h])/(float)sum;
				float percent = num * 100;
				double per = Math.round(percent*100)/100.0;
				String sym = "%";
				bw.write(Double.toString(per) + sym + " ");
			}
			
		}
		
		bw.write("\n");
	

		int TotalBits = 0;
		int fl = FrequencyArr.length;
		
		for(int k=fl-1; k>=0; k--)
		{
			
			if(SymbolArr[k]!=null)
			{
			bw.write("\n");
			}
			
			if(SymbolArr[k]!=null)
			{
			
			bw.write(SymbolArr[k]);
			bw.write(" ");
			}
		
			if(codeArr[k]!=null)
			{
				TotalBits = TotalBits + (codeArr[k].length() * FrequencyArr[k]);
			
			bw.write(codeArr[k]);
			bw.write(" ");
			}
	}
		
		bw.write("\n\n");
		bw.write("Total Bits: "+TotalBits);
		bw.close();
           

        } catch(Exception e){
         //System.out.println(e);
      }

    }
	
	
	public static void sortArr(int s, int e)
	{
		int count3 = 1;
		int count4 = 2;
		
		
		
		while(count3 != count4)
		   {
			   count3 = count4;
			   
			   for(int ok = s; ok<e-1; ok++)
			   {
				   if(freqArray1[ok] > freqArray1[ok+1])
				   {
					   char temp1 = freqArray1[ok];
					   freqArray1[ok] = freqArray1[ok+1];
					   freqArray1[ok+1] = temp1;
					   count4++;
				   }
			   }
		   }
		
		 
	}
}


abstract class HuffTree implements Comparable<HuffTree> {
    public int freq; // the frequency of this tree
    public char val;
    public HuffTree(int f, char v) { freq = f; val = v;}
    public HuffTree(int f) { freq = f; }
 
    public int compareTo(HuffTree tree) {
    	int tf = freq - tree.freq;
        return tf;
    }
}
 
class HuffLeaf extends HuffTree {
    public final char val; // the character this leaf represents
 
    public HuffLeaf(int f, char v) {
        super(f, v);
        val = v;
    }
}
 
class HuffNode extends HuffTree {
    public final HuffTree left; // subtrees
    public final HuffTree right;
    
    public HuffNode(HuffTree l, HuffTree r) {
    	super(l.freq + r.freq);
    	 right = r;
    	left = l;
     }
}

class HuffmanCode {
    
    public static HuffTree buildTree(int[] Freq, char[] ch) {
        PriorityQueue<HuffTree> order = new PriorityQueue<HuffTree>();
       int i;
        int frel = Freq.length;
       
       for (i = 0; i < frel; i++)
            if(Freq[i] > 0)
                order.add(new HuffLeaf(Freq[i], ch[i]));
 
        assert order.size() > 0;
        
        while (order.size() > 1) {
            
        	HuffTree p = order.poll(), q= order.poll();
        	
        	if(p.freq == q.freq)
        	{
        		
        		if(p.val < q.val)
        		{
        			order.add(new HuffNode(q, p)); 
        		}
        		else
        		{
        			order.add(new HuffNode(p, q));
        		}
        	}
        	else
        	{
        		order.add(new HuffNode(p, q)); 
        	}
        }
        return order.poll();
    }




	public static StringBuffer d = new StringBuffer();
 
    public static  void showhuffmancode(HuffTree T, StringBuffer prefix) {
        assert T != null;

        if (T instanceof HuffLeaf) 
        {
        	HuffLeaf leaf = (HuffLeaf)T;
        	d.append("");
			d.append(leaf.val + " ");
			d.append(leaf.freq + " ");
			d.append(prefix + " ");
			
		 }
 
        else if (T instanceof HuffNode) {
            HuffNode node = (HuffNode)T;
            
            showhuffmancode(node.left, prefix.append('0'));
            prefix.deleteCharAt(prefix.length()-1);
 
            showhuffmancode(node.right, prefix.append('1'));
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
