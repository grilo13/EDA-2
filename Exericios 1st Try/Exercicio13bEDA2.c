#include <stdio.h>

#define TAM 50000

int procura(int n, int s, int v[s])
{
    int i = 0;
    
    while(i < s && v[i] != n){
        i++;
    }
    if(i < s){
        return i;
    }
    return -1;
}


int main()
{
    int vetor[TAM];

    for(int i = 0, j = 2; i < TAM; i++, j=j+2){
        vetor[i]=j;
    }

    for (int x = 1; x <= 20; x++){

        int p = procura(2 * x, TAM, vetor);

        if (p == -1){
            printf("Não encontrou %d\n", 2 * x);
        }else if(vetor[p] != 2 * x){
            printf("Encontrou %d na posição errada: %d\n", 2 * x  , p);
        }
    }

    printf("Menor %d \n", procura(1, TAM, vetor));
    printf("Maior %d \n", procura(2*TAM + 1, TAM, vetor));
    printf("Entre o menor e o minimo: %d \n", procura(133333,TAM, vetor));
    return 0; 
}

