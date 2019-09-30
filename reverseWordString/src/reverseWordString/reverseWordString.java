package reverseWordString;

public class reverseWordString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String s = "  hello world!  ";
		
		String s = "a good   example ";
		
		s = s.trim();
		
		s = s.replaceAll("\\s+"," ");
		
		String[] str = s.split(" ");
		
		System.out.println(s);
		
		for(int i = 0, j = str.length-1 ;i<j;i++,j--) {
			
			String temp = str[i];
			str[i] = str[j];
			str[j] = temp;
			
		}
		
		s = String.join(" ",str);
		
//		String result = new StringBuffer(s).reverse().toString();
//		
//		System.out.println(str[0]);
//		System.out.println(str[1]);
		System.out.println(s);
		
		char[] strArr = s.toCharArray();
		
		for(int i = 0, j = strArr.length-1; i<j;i++,j-- ) {
			char temp = strArr[i];
			strArr[i] = strArr[j];
			strArr[j] = temp;
		}
		
		s = String.valueOf(strArr);
		
		System.out.println(s);

	}

}
