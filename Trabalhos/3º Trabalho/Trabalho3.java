/**
 * 
 * @author Pedro Grilo 43012 and Diogo Castanho 42496
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Arco {
	
	//Arco (U,V) tem como U o vértice source, e como V o vértice destination
	// weight representa o peso do arco -> no caso do trabalho representa a bolsa com as moedas
	
	private Vertice source;  
	
	private Vertice destination;
	
	private int bag_coins;
	
	public Arco(Vertice source, Vertice destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.bag_coins = weight;
    }

	public Vertice getSource() {
		return source;
	}

	public void setSource(Vertice source) {
		this.source = source;
	}

	public Vertice getDestination() {
		return destination;
	}

	public void setDestination(Vertice destination) {
		this.destination = destination;
	}

	public int getBagCoins() {
		return bag_coins;
	}

	public void setBagCoins(int bag_coins) {
		this.bag_coins = bag_coins;
	}

	@Override
	public String toString() {
		return "Arco [source=" + source + ", destination=" + destination + ", bag_coins=" + bag_coins + "]";
	}
}

class Vertice {
	
	private int label;   //A,B,C....
	
	private Vertice source;  //nó inicial
	
	private Vertice predecessor; //o vértice pai desse mesmo vértice -> predecessor de v nesse caminho
	
	private int distance;  //distancia do caminho mais curto desde o vértice source ao vértice dado
	
	public Vertice(int label) {
		this.label = label;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public Vertice getSource() {
		return source;
	}

	public void setSource(Vertice source) {
		this.source = source;
	}

	public Vertice getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertice predecessor) {
		this.predecessor = predecessor;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Vertice [label=" + label + ", source=" + source + ", predecessor=" + predecessor + ", distance="
				+ distance + "]";
	}	

}

class Graph {
	
	private Vertice[] verticesAvailable;  // vertices existentes para o grafo
	private Arco[] arcosAvailable;     	  // arcos existentes para o grafo

    public Graph(Vertice[] verticesAvailable, Arco[] arcosAvailable) {
        this.verticesAvailable = verticesAvailable;
        this.arcosAvailable = arcosAvailable;
    }
    
    /*
     * Argumentos da função :
     * - Vertice entrance -> vértice inicial do nosso grafo
     * - int number_vertices -> número de vertices existentes
     * - int number_arcos -> número de arcos existentes
     * - Arco[] arcos -> array com todos os arcos criados a partir do input
     * - Vertice[] vertices -> array com todos os vertices criados a partir do input
     */
    public boolean BellManFord(Vertice entrance, int number_vertices, int number_arcos, Arco[] arcos, Vertice[] vertices) {  // função principal onde é aplicado o algoritmo de BellmanFord
    	
        initialize_single_source(entrance, number_vertices, vertices);
       
        int[] store_distances = new int[number_vertices];   // array adicional para guardar os valores das distancias de um vértice até ao vértice inicial
        java.util.Arrays.fill(store_distances, Integer.MAX_VALUE);
        
        store_distances[0] = 0;  //distancia do vértice inicial para ele próprio é 0
        
        	for(int p = 1; p < number_vertices - 1; p++) {   
            	
            	for(int j = 0; j < number_arcos; j++) { // ciclo que irá ver todos os arcos para todos os vértices existentes, aplicando o relaxamento a todos os arcos
            		
            		if (arcos[j].getSource().getDistance() + arcos[j].getBagCoins() < arcos[j].getDestination().getDistance() && arcos[j].getSource().getDistance() != Integer.MAX_VALUE) {   
            			
            			arcos[j].getDestination().setDistance(arcos[j].getBagCoins()+arcos[j].getSource().getDistance());
            			
            			// guarda o valor da distância para um vértice j de chegada (apenas para efeitos de teste)
            			store_distances[arcos[j].getDestination().getLabel()] = store_distances[arcos[j].getSource().getLabel()] + arcos[j].getBagCoins();  
            			
                    	arcos[j].getDestination().setPredecessor(arcos[j].getSource());
       
            		}
            	}
            }
        	
        	
        	/* Ciclo para todos os arcos novamente para detetar se existem arcos com ciclos negativos.
        	 * Um ciclo negativo ocorre quando se encontra um caminho melhor para além da melhor solução da distância já encontrada
        	*/
        	for(int k = 0; k < number_arcos; k++) {
        		
        		if (arcos[k].getSource().getDistance() + arcos[k].getBagCoins() < arcos[k].getDestination().getDistance() && arcos[k].getSource().getDistance() != Integer.MAX_VALUE) {
        			
            		return true; // se encontrar um ciclo negativo retorna true 
            	}
        	}
        

        
        if(store_distances[number_vertices -1] < 0) {
        	return true; // se o valor da distância do ultimo vértice até ao vertice de entrada for menor que 0,o Dirk perdeu dinheiro para chegar ao final do labirinto
        }
            		
        
        return false; // se o valor for false, o Dirk não perde dinheiro até chegar ao final do labirinto
    }

    private void initialize_single_source(Vertice entrance, int number_vertices, Vertice[] vertices) {   // inicialização dos valores dos vértices -> distância e predecessor
    	
        entrance.setDistance(0);  // distância do vértice de entrada é 0 para ele próprio
        
        for(int i = 1; i < number_vertices - 1; i++) { // para o resto dos vértices
        	vertices[i].setDistance(Integer.MAX_VALUE); // a distância do caminho mais curto entre esse vertice e o de entrada começa em + infinito
            vertices[i].setPredecessor(null);  // o valor do vértice predecessor começa em null -> ainda não sabemos qual é
        }
    }	
}


public class Trabalho3 {
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
    			
		String[] tokens = input.readLine().split(" ");
	        
	    int rooms = Integer.parseInt(tokens[0]); // número de quartos existentes
	    
	    int corridors = Integer.parseInt(tokens[1]); // número de corredores existentes
	        
	   	Arco[] array_arcos = new Arco[corridors];  //array para guardar os arcos existentes
	   
	    Vertice[] array_vertices = new Vertice[rooms];  //array para guardar os vértices existentes
	    
	    for(int j = 0; j < rooms; j++) {	 // criação dos vértices existentes -> de 0 a Número de Rooms -1
	    	Vertice Vertice = new Vertice(j);
	    	
	    	array_vertices[j] = Vertice;  //adiciona oa array o vértice criado com a label "j"
	    }
	    
	    for(int index = 0; index < corridors; index++) {  // ciclo que irá correr para todos os corredores existentes -> para todos os arcos no input
	    	
	    	String[] values = input.readLine().split(" ");
	 	    	
	    	int i = Integer.parseInt(values[0]);   // valor i, que será vertice source de um arco

	    	int j = Integer.parseInt(values[1]);   // valor j, que será vertice destination de um arco
	    	
	    	String letter = values[2]; // letra destinada a saber se tem ponte ou bolsa de moedas
	    	
	    	int G = 0;
	    	
	    	if(letter.equals("B")) {   // se a letra do input for B
	    		G = Integer.parseInt(values[3]);  //coloca o valor do peso do arco num valor normal -> porque tem a bolsa com o dinheiro
	    		
	    	} else if(values[2].equals("C")) {  // se a letra do input for C
	    		G = - Integer.parseInt(values[3]);   //coloca o valor do peso do arco num valor negativo -> porque tem um crocodilo e temos de levantar a ponte
	    	}
	    	
	    	array_arcos[index] = new Arco(array_vertices[i], array_vertices[j], G);  // adiciona ao array de arcos o arco criado com os vertices i e j criados, e G como valor do peso do arco
	    }
	    
	    Graph graph = new Graph(array_vertices, array_arcos);
	    
        boolean value = graph.BellManFord(array_vertices[0], rooms, corridors, array_arcos, array_vertices);  // chamada da função "principal", true para perder dinheiro / false não perder
        
        if(value == true) {
        	System.out.println("yes"); //pode perder dinheiro
        } else {
        	System.out.println("no"); //não perde dinheiro
        }
    }
}

/*
 * 
 * 
 * Exemplo 1
5 7
1 4 C 7 
0 1 B 5
0 2 B 2
1 3 C 2
2 3 B 6
3 2 C 3
3 4 B 1

OUTPUT: yes

* Exemplo 2
5 7
1 4 C 5
0 1 B 5
0 2 B 2
1 3 C 2
2 3 B 6
3 2 C 3
3 4 B 1

OUTPUT: no

Exemplo 3 - dificil - ciclo negativo
4 4
0 1 B 2
1 2 B 1
2 1 C 3
1 3 B 5

OUTPUT: yes
 */
    
    