#include <stdio.h>
#include <stdlib.h>

//funciona
void mostra_resultado(long subsequencia[], long indice1, long indice2, long soma){
  if(indice1 == indice2){
    printf("s[%ld] = %ld", indice1+1, soma);

  }else if(indice1 != indice2){
    printf("s[%ld]", indice1+1);
    for(int i = indice1+1; i <= indice2;i++){
      printf(" + s[%d]", i+1);
    }
    printf(" = %ld", soma);
  }
}

//funciona
long soma_vetor(long sequencia[], long indice1, long indice2){
  long soma = 0;

  for(int i = indice1; i <= indice2; i++){
    soma += sequencia[i];
  }
  return soma;
}

//funciona
void iterador(long subsequencia[], long comprimento, long soma){
  long valor, itera_indice1 = 0, comp = 0;

  for(comp = 0; comp < comprimento; comp++){
    for(itera_indice1 = 0; itera_indice1 < comprimento-comp; itera_indice1++){
      valor = soma_vetor(subsequencia, itera_indice1, itera_indice1 + comp);
      if(valor == soma){
        mostra_resultado(subsequencia, itera_indice1, itera_indice1 + comp,soma);
        return;
      }
    }
  }
  if(valor != soma){
    printf("nenhuma subsequencia soma %ld", soma);
  }
}

int main()
{

  long n, soma;

  scanf("%ld", &n);
  long sequencia[n];

  if(n<1 || n>1000){
    return 0;
  }

  for(int i = 0; i < n; i++){
    scanf("%ld", &sequencia[i]);
  }

  for(int i = 0; i < n; i++){
    if(sequencia[i] <= -100000 || sequencia[i] >= 100000){
      return 0;
    }
  }

  scanf("%ld", &soma);

  if(soma <= -100000001  || soma >= 100000001){
    return 0;
  }

  iterador(sequencia, n, soma);
}
