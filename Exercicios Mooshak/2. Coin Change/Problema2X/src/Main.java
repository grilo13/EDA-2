import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	 
	 static int[] recursiveCoinChange2(int[] coins, int value){

	        int[] minCoin = new int[value + 1];
	        
	        int arrayValues[] = new int[value+1];
	        
	        //caso base, se o valor do troco for = 0
	        minCoin[0] = 0;

	        for (int i = 1; i <= value; i++) {
	        	minCoin[i] = Integer.MAX_VALUE;
	            for (int j=0; j < coins.length; j++) {
	            	if (i >= coins[j] && minCoin[i-coins[j]] + 1 < minCoin[i]){;
                    	minCoin[i] = 1 + minCoin[i-coins[j]];
                    	arrayValues[i] = coins[j];  //atribui a arrayValues os valores minimos das moedas que foram atribuidas
	            	}
	            }  
	        }
	        
	        //System.out.println("MINCOIN: " + minCoin[value]);
	        
	        int x = value;
	        
	        int[] array_solutions = new int[minCoin[value] + 1];  
	        array_solutions[0] = minCoin[value]; //atribui à primeira posição do array o número minimo de moedas usados, return da funcao recursive1
	        for(int z = 1; z <= minCoin[value]; z++) {   //se existem 2 moedas, 1...2...
	        	if(x > 0) {
	        		array_solutions[z] = arrayValues[x];
	        		x = x - arrayValues[x];
	        		//System.out.println(array_solutions[z]);
	        	}
	        }
	          
	        return array_solutions;
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
		   
		
		   String perguntas = br.readLine();
		   Integer perguntasSize = Integer.parseInt(perguntas);
	
		   int array_division[] = new int[perguntasSize];
		   
		   int j = 0;
		   
		   while(j < perguntasSize) {
			   String value= br.readLine();
			   Integer change =Integer.parseInt(value);
			   array_division = recursiveCoinChange2(intArray,change);
			   for(int x = 0; x < array_division.length; x++) {
				   if(x == 0) {
					   System.out.print(change +": ["+array_division[x]+"] ");
				   } else if(x == array_division.length -1) {
					   System.out.println(array_division[x]);
				    } else {
					   System.out.print(array_division[x]+" ");
				   }
			   }
			   j++;
		   }
	}

}