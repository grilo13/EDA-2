#include <stdio.h>

void procura_binaria(int n, int s, int v[]){

    int low = 0;
    int high = s;
    int aux = 0;

    while(low <= high)
    {
        int index = low + (high-low)/2;

        if(v[index] == n)
        {            
            aux = 1;
            printf("Encontrado no indice %d.", index + 1);
            break;
        } 
        else if(v[index] < n)
        {
            low = index + 1;

        }
        else 
        {
            high = index - 1;

        }
    }
    if(aux == 0)
    {
        printf("Nao encontrado. ");
    }
    
}

int main(){

    int vetor[5] = {4,5,6,7,8};

    
    procura_binaria(6,5,vetor);
}