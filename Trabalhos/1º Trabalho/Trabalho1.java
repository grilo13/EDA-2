import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Boats { //classe para guardar os valores dos barcos (coordenadas e rating)
	   private int x;
	   private int y;
	   private int rating;
	   
	   public Boats(int x, int y, int rating){
	      this.x = x;
	      this.y = y;
	      this.rating = rating;
	   }
	   
	   //metodos de procura 
	   
	   public int getBoatX() { return x; }

	   public int getBoatY() { return y; }
	   
	   public int getRating() { return rating; }
	   
	   ////Para ajudar na visualizacao dos dados de cada barco
	   
	   public void display(){
	      System.out.println(this.x);
	      System.out.println(this.y);
	      System.out.println(this.rating);
	   }
}

class Spots { //classe para guardar os valores dos spots (coordenadas e quantidade de peixes)
	   private int x;
	   private int y;
	   private int amount;
	   
	   public Spots(int x, int y, int amount){
	      this.x = x;
	      this.y = y;
	      this.amount = amount;
	   }
	   
	   //metodos de procura 
	   
	   public int getSpotX() { return x; }

	   public int getSpotY() { return y; }
	   
	   public int getAmount() { return amount; }
	   
	   //Para ajudar na visualizacao dos dados de cada spot
	   
	   public void display(){
	      System.out.println(this.x);
	      System.out.println(this.y);
	      System.out.println(this.amount);
	   }
}



public class Trabalho1{
	
	static void ordenarArrayRating(Boats[] boats) {  //ordenar de forma crescente por rating
		
		for (int i = 0; i < boats.length; i++) {
		    for (int j = 0; j < boats.length - 1; j++) {
		        if (boats[j].getRating() > boats[j+1].getRating()) {
		            Boats temp = boats[j];
		            boats[j] = boats[j+1];
		            boats[j+1] = temp;
		        }
		    }
		}		
	}
	
	static void ordenarArrayAmount(Spots[] spots) { //ordenar de forma crescente por quantidade de peixes
		
		for (int i = 0; i < spots.length; i++) {
		    for (int j = 0; j < spots.length - 1; j++) {
		        if (spots[j].getAmount() > spots[j+1].getAmount()) {
		        	Spots temp = spots[j];
		            spots[j] = spots[j+1];
		            spots[j+1] = temp;
		        }
		    }
		}
	}
	
	static int[] codFishing(Boats[] boats, Spots[] spots) {
		
		int[] array = new int[3];
		
		int [][] totalDistance = new int [boats.length+1][spots.length+1]; //inicializar tabela para Distancia
		int [][] totalAmount = new int [boats.length+1][spots.length+1]; //inicializar tabela para Quantidade de Peixes
		int [][] totalRating = new int [boats.length+1][spots.length+1];  //inicializar tabela para Rating
	
		
		Arrays.fill(array, 0);
		
		
		for(int i = 0; i <= boats.length; i++) {
			for(int j = 0; j <= spots.length; j++) {
				if(i == 0 || j == 0) { //Atribuido valor 0 para os casos base : Onde nao ha barcos, onde nao ha sitios ou onde nao ha ambos
					totalDistance[i][j] = 0; 
					totalAmount[i][j] = 0;
					totalRating[i][j] = 0;
			
				}else{
					if(i == j) { 	//quando numero de barcos = numero de spots disponiveis
						totalDistance[i][j] = totalDistance[i-1][j-1] + distancia(boats[i-1],spots[j-1]);	//distância do ponto é a distância da sua diagonal(coordenada i-1,j-1) mais a distância do barco[i] e spot[j]
						totalAmount[i][j] = totalAmount[i-1][j-1] + spots[spots.length-j].getAmount();   //o amount total é o amount da sua diagonal mais o amount do spot[j] desse valor da tabela
						totalRating[i][j] = totalRating[i-1][j-1] + boats[i-1].getRating();    //o rating total é o rating total da sua diagonal mais o rating do boat[i] desse valor da tabela

						
					}else if(i > j) {  //quando o numero de barcos > numero de spots disponiveis
						totalDistance[i][j] = Math.min(totalDistance[i-1][j-1] + distancia(boats[i-1],spots[j-1]), totalDistance[i-1][j]);  //menor valor da distância entre o valor acima na tabela e o valor da distancia [i][j] + a diagonal
						totalAmount[i][j] = totalAmount[i-1][j-1] + spots[spots.length-j].getAmount();  //valor do amount é o amount da valor da diagonal mais o valor do amount do spot[j] 
						
						if(totalDistance[i-1][j] > totalDistance[i][j]) { //caso a distancia total da linha anterior na mesma coluna (mesmo numero de spots) tenha uma distancia maior que a "casa" onde se pertende atribuir o Rating
								totalRating[i][j] = totalRating[i-1][j-1] + boats[i-1].getRating(); 
						
						}else if(totalDistance[i-1][j] == totalDistance[i][j]){ //caso a distancia total da linha anterior na mesma coluna (mesmo numero de spots) seja igual que a "casa" onde se pertende atribuir o Rating
							totalRating[i][j] = totalRating[i-1][j];   //porque o de cima tem menor rating, porque os barcos estão por ordem decrescente
						}
				
					}else if(i < j) {  //quando numero de barcos < numero de spots disponiveis
			
						totalDistance[i][j] = totalDistance[i-1][j-1] + distancia(boats[i-1],spots[j-1]);	//a distancia é a distância diagonal mais a distância entre as coordenas atuais da tabela
						totalAmount[i][j] = Math.max(totalAmount[i][j-1], spots[spots.length-j].getAmount());			//o amount é o valor máximo entre o valor do amount do spot anterior e o atual, spot[j-1]
						totalRating[i][j] = totalRating[i-1][j-1] + boats[i-1].getRating();					//o rating é o rating do valor do rating da diagonal mais o valor do rating na coluna anterior
					
					}
				}
			}
		}
		
		/*
		 //imprimir as tabelas para desenvolvimento do algoritmo
	
		   for(int i = 0; i <= boats.length; i++) { //Imprimir tabela das distancias
			   for(int j = 0; j <= spots.length; j++)
				   System.out.printf("%3d ", totalDistance[i][j]);
		    System.out.println(); 
		  }	
		   
		  System.out.println();
		   
		   for(int i = 0; i <= boats.length; i++) { //Imprimir tabela da quantidade de peixes 
			   for(int j = 0; j <= spots.length; j++)
				   System.out.printf("%3d ", totalAmount[i][j]);
		    System.out.println(); 
		  }		
		   
		   System.out.println();
		   
		   for(int i = 0; i <= boats.length; i++) { //Imprimir tabela do rating
			   for(int j = 0; j <= spots.length; j++)
				   System.out.printf("%3d ", totalRating[i][j]);
		    System.out.println(); 
		  }		
		  
		*/
		
		array[0] = totalAmount[boats.length][spots.length]; //Valor final da tabela Amount na posicao "maxima" (canto inferior direito da tabela)
		array[1] = totalDistance[boats.length][spots.length]; //Valor final da tabela Distance na posicao "maxima" (canto inferior direito da tabela)
		array[2] = totalRating[boats.length][spots.length]; //Valor final da tabela Rating na posicao "maxima" (canto inferior direito da tabela)

		return array;
	}
	
	static int distancia(Boats boat, Spots spot) { //Função que calcula distância entre o barco e spot dos peixes
		/*
		 * Distância entre duas coordenadas = |Xb - Xa| + |Yb-Ya|
		 */
		
		double distancia = 0;
		
		double parcela1 = Math.abs(spot.getSpotX() - boat.getBoatX()); 
		
		double parcela2 = Math.abs(spot.getSpotY() - boat.getBoatY());
		
		distancia = parcela1 + parcela2; //soma da diferença entre as coordenadas dadas para o barco e para o spot
		
		return (int)distancia;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		String readline = null;
		int num_of_boats = 0;
		int num_of_fishing_spots = 0;
		int indice = 0;
		
		int[] array = null; //para o número de barcos e para o número de spots de peixes
		int[] array1 = null; // para guardar os valores dos barcos
		int[] array2  = null; //para guardar os valores dos spots de peixes
	
		readline = reader.readLine();
		String[] arrayValores = readline.split(" ");
		array = Arrays.stream(arrayValores).mapToInt(Integer::parseInt).toArray(); //guardar num array o valor do numero de barcos e numero de spots
		
		if(array.length != 2) {  // Para verificar que são introduzidos 2 valores inicias: número de barcos e número de spots
			System.out.println("Error, just two integers please");
			System.exit(0);	
			
		}else {	
			num_of_boats = array[0];
			num_of_fishing_spots = array[1];
			
			if(num_of_boats < 1 || num_of_boats > 4000) {  //limite para o número de barcos
				System.out.println("Error in number of boats (1 >= B <= 4000)");
				System.exit(0);
			}
			
			if(num_of_fishing_spots < 1 || num_of_fishing_spots > 4000) {  //limite para o número de spots de peixes disponiveis disponiveis
				System.out.println("Error in number of fishing spots (1 >= S <= 4000)");
				System.exit(0);
			}
		}
		
		Boats boat[] = new Boats[num_of_boats];
		Spots spot[] = new Spots[num_of_fishing_spots];

		while(indice < num_of_boats){ //leitura de valores do input para o numero de barcos dado
			
			readline = reader.readLine();
			String[] arrayValores1 = readline.split(" ");	
			array1 = Arrays.stream(arrayValores1).mapToInt(Integer::parseInt).toArray();
				
			//limites para os valores das coordenadas e do rating dos barcos 
			if(array1.length != 3) {
				System.out.println("Error, this line needs: coordinates and boat rating (x y rating)");
				System.exit(0);
				
			}else if(array1[0] < 1 || array1[0] > 10000 || array1[1] < 1 || array1[1] > 10000) {
				System.out.println("Error, coordinates needs to be: 1 <= x, y <= 10 000");
				System.exit(0);
				
			}else if(array1[2] < 1 || array1[2] > 10000) {
				System.out.println("Error, range of RATING: 1 <= R <= 10 000");
				System.exit(0);
				
			}else {
				boat[indice] = new Boats(array1[0], array1[1], array1[2]);
				
			}	
		indice++;
		}
	
		indice = 0;
		
		while(indice < num_of_fishing_spots){ //leitura de valores do input para o numero de spots dado
			
			readline = reader.readLine();
			String[] arrayValores2 = readline.split(" ");	
			array2 = Arrays.stream(arrayValores2).mapToInt(Integer::parseInt).toArray();
			
			//limites para os valores das coordenadas e do amount de spots de peixes
			if(array2.length != 3) {
				System.out.println("Error, this line needs: coordinates and amount of fish in a fishing spot (x y amount)");
				System.exit(0);
				
			}else if(array2[0] < 1 || array2[0] > 10000 || array2[1] < 1 || array2[1] > 10000) {
				System.out.println("Error, coordinates needs to be: 1 <= x, y <= 10 000");
				System.exit(0);
				
			}else if(array2[2] < 1 || array2[2] > 10000) {
				System.out.println("Error, range of AMOUNT: 1 <= A <= 10 000");
				System.exit(0);
				
			}else {
				spot[indice] = new Spots(array2[0], array2[1], array2[2]);	
			}	
		indice++;
		}
		
		ordenarArrayRating(boat); //ordenar o array por RATING do menor para o maior, ajudando mais tarde nas decisoes das tabelas
		ordenarArrayAmount(spot); //ordenar o array por QUANTIDADE DE PEIXES do menor para o maior, também usado posteriormente nas decisões das tabelas
		
		int arrayaux[] = codFishing(boat,spot);  //array retornado da função codFishing com os três valores: total de peixe capturado, distância total percorrida, soma do rating dos barcos
		
		for(int p = 0; p < arrayaux.length; p++) { //Imprime o array final gerado pela funcao Cod Fishing com as 3 solucoes geradas pelo algoritmo (Distance, Amount, Rating)
			if(p == arrayaux.length - 1) {
				System.out.println(arrayaux[p]);
				
			}else {
				System.out.print(arrayaux[p] + " ");
			}
		}
	}
}

/*
//Exemplos de teste

2 2
10 20 120
30 10 60
10 10 20
30 20 30

Resultado: 50 40 180

3 2
30 10 60
10 20 120
20 20 10
30 20 30
10 10 20

Rsultado: 50 30 70
 */