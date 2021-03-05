package net.problema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Scanner;

public class Problema1 {
	
	public static void main(String[] args) throws IOException {
		 /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.print("Enter a string: ");
		 
		 String[] str = br.readLine().split(" ");
		*/
		
		Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayLines = new ArrayList<>();
        String line_size = scanner.nextLine();
        int size = Integer.parseInt(line_size);

        String line;
        while(size > 0){
            line = scanner.nextLine();
        
              int size2 =  Integer.parseInt(line);
              
              while(size2 > 0) {
            	  String line2 = scanner.nextLine();
                  arrayLines.add(line2);
                  size2--;
              }
                  
            size--;
        }
        
        int max = 0;
        
        for(int i = 0; i < arrayLines.size(); i++) {
        	if(Integer.parseInt(arrayLines.get(i)) > max) {
        		max = Integer.parseInt(arrayLines.get(i));
        		
        	}
        }
        System.out.print(max);		
	}

}

//ler linha a linha
// Example of input given: 4 3 5 12 2 0 3 25 5 17 5 2 4 2 10 21
//ayj2Q9
