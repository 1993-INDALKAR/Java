import java.util.Scanner;
//import java.text.DecimalFormatSymbols;
public class game {
    	
		static char activePlayer = 'X';
		
		static int size = 3;
	
		static char grid[][] = new char[size][size];
		
		static boolean print = true;
 
    
	
    public static void main (String[] args)
    {
		
		Scanner s = new Scanner(System.in);
		
		
        initializeGrid();
        
        do
        {
           if(print) {
        	   printGrid();
           }
            
            int row=0;
            int col=0;
			int inp = 0;
            String inp1;
                System.out.println("Please enter a box number for player "+activePlayer+", or -1 to quit:");
//				inp = s.nextInt();
                inp1 = s.nextLine();
                if(isStringNumeric(inp1)) {
                	inp = Integer.parseInt(inp1);
    				//System.out.println(inp);
                }
				
                
				if( (inp < 10 && inp > 0) || inp == -1 ) {
					
					if(inp == 1)
					{
						row = 0;
						col = 0;	
					}
					else if(inp == 2)
					{
						row = 0;
						col = 1;	
					}
					else if(inp == 3)
					{
						row = 0;
						col = 2;	
					}
					else if(inp == 4)
					{
						row = 1;
						col = 0;	
					}
					else if(inp == 5)
					{
						row = 1;
						col = 1;	
					}
					else if(inp == 6)
					{
						row = 1;
						col = 2;	
					}
					else if(inp == 7)
					{
						row = 2;
						col = 0;	
					}
					else if(inp == 8)
					{
						row = 2;
						col = 1;	
					}
					else if(inp == 9)
					{
						row = 2;
						col = 2;	
					}
					else if(inp == -1)
					{
						System.exit(0);
					}

	            playTheChance(row, col);
	           
	            
					
				}
				else {
					print = false;
				}
				        }
        while(checkIfWon() == false && checkIfOccupied() == false);
        
        if (checkIfOccupied() == true  && checkIfWon() == false)
        {
			//printGrid();
            System.out.println("Players X and O have tied.");
        }
        else
        {
    
           //printGrid();
            
			if (activePlayer == 'X') 
			{
				activePlayer = 'O';
			}
			else 
			{
				activePlayer = 'X';
			}
			
            System.out.println("Player " +Character.toUpperCase(activePlayer)+ " has won the game!");
        }
    


	}


    static  void initializeGrid() {
		
		int cnt = 0;
  
        for (int i = 0; i < 3; i++) {


            for (int j = 0; j < 3; j++) {
				cnt+=1;
                grid[i][j] = (char)('0' + cnt);
            }
        }
    }

     static void printGrid() 
	 {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
				
				if(j == 2)
				{
					System.out.print(" " + grid[i][j]);
				}
				else
				{
					System.out.print(" " + grid[i][j] + " |");
				}
            }
            System.out.println();
			
			if(i < 2)
			{
				System.out.print("---+---+---");
			}
			if(i < 2)
			{
				System.out.println();
			}
			
			
          
        }
    }

     static boolean checkIfOccupied() 
	{
        boolean isOccupied = true;

        for (int i = 0; i < 3; i++) 
		{
            for (int j = 0; j < 3; j++) 
			{
                if (grid[i][j] != 'X' && grid[i][j] != 'O') 
				{
                    isOccupied = false;
                }
            }
        }

        return isOccupied;
    }

    static void playTheChance(int row, int col) 
	{
        if ((row >= 0) && (row < 3)) 
		{
            if ((col >= 0) && (col < 3)) 
			{
                if (grid[row][col] != 'X' && grid[row][col] != 'O') 
				{
                    grid[row][col] = activePlayer;
					
					if (activePlayer == 'X') 
					{
						activePlayer = 'O';
					}
					else 
					{
						activePlayer = 'X';
					}
					
					print = true;
                  
				}
                else {
                	print = false;
                }
            }
        }
    }
	
	static boolean checkIfWon()
	{
		for(int i=0; i<3; i++)
		{
			if((grid[i][0] == grid[i][1]) && (grid[i][0] == grid[i][2]))
			{
				return true;
			}
		}
		
		for(int j=0; j<3; j++)
		{
			if((grid[0][j] == grid[1][j]) && (grid[0][j] == grid[2][j]))
			{
				return true;
			}
		}
		
		if((grid[0][0] == grid[1][1]) && (grid[0][0] == grid[2][2]))
		{
			return true;
		}
		
		if((grid[0][2] == grid[1][1]) && (grid[0][2] == grid[2][0]))
		{
			return true;
		}
		
		return false;
		
	}
	
//	public static boolean isNumeric(String str) //https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
//	{
//	    for (char c : str.toCharArray())
//	    {
//	        if (!Character.isDigit(c)) return false;
//	    }
//	    return true;
//	}
	
	public static boolean isStringNumeric( String str )
	{
		char char1 = str.charAt( 0 );
		if( char1 == '-') {
			str = str.substring(1);
		}
		
		char[] charArray = str.toCharArray();
		
		for(char character : charArray) {
			int ascii = character;
			if( !(ascii > 47 && ascii < 58 )  ) {
				return false;
			}
		}
		
		return true;
		
//	    DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
//	    char localeMinusSign = currentLocaleSymbols.getMinusSign();
//
//	    if ( !Character.isDigit( str.charAt( 0 ) ) && str.charAt( 0 ) != localeMinusSign ) return false;
//
//	    boolean isDecimalSeparatorFound = false;
//	    char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();
//
//	    for ( char c : str.substring( 1 ).toCharArray() )
//	    {
//	        if ( !Character.isDigit( c ) )
//	        {
//	            if ( c == localeDecimalSeparator && !isDecimalSeparatorFound )
//	            {
//	                isDecimalSeparatorFound = true;
//	                continue;
//	            }
//	            return false;
//	        }
//	    }
//	    return true;
	}

}