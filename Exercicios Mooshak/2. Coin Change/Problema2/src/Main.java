import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	 static int recursiveCoinChange(int[] coins, int value){

        int[] minCoin = new int[value + 1];
        
        for (int j = 0; j <= value; j++){
            minCoin[j] = Integer.MAX_VALUE;
        }
        
        //caso base, se o valor do troco for = 0
        minCoin[0] = 0;

        for (int i = 1; i <= value; i++) {
            for (int j=0; j < coins.length; j++)
            {
                if (i >= coins[j] && minCoin[i-coins[j]] + 1 < minCoin[i]){;
                    minCoin[i] = 1 + minCoin[i-coins[j]];
                }
            }
        }
        
        return minCoin[value];
    }

	static String[] reverse_array(String[] array) {
		
		int size = array.length;
		String[] array2= new String[size];
		int i = 0;
		
		for(int j = array.length - 1; j >= 0; j--) {
			array2[i] = array[j];
			i++;
		}
		
		return array2;
	}

	public static void main(String[] args) throws IOException {
		   
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   String n = br.readLine();

		   String valores = br.readLine();
		   String[] arrOfStr = valores.split(" "); 
		   int[] intArray = new int[arrOfStr.length];
		   
		   for(int i = 0; i < arrOfStr.length; i++) {
			   intArray[i] = Integer.parseInt(arrOfStr[i]);
		   }
		   
		   //String[] reversedArray = reverse_array(arrOfStr);
		
		   String perguntas = br.readLine();
		   Integer perguntasSize = Integer.parseInt(perguntas);
		   
		   int array_valores[] = new int[perguntasSize];
		   int array_changes[] = new int[perguntasSize];
		   
		   int j = 0;
		   
		   while(j < perguntasSize) {
			   String value= br.readLine();
			   Integer change =Integer.parseInt(value);
			   //System.out.println(change + ": " + "[" + recursiveCoinChange(intArray, change) +"]");
			   array_changes[j] = change;
			   array_valores[j] = recursiveCoinChange(intArray, change);
			   j++;
		   }
		   
		   for(int x = 0; x < array_valores.length; x++) {
			   System.out.println(array_changes[x] + ": " + "[" + array_valores[x] + "]");
		   }
	}

}
