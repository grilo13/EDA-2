#include <stdio.h>

//funciona
void mostra_resultado(int subsequencia[], int indice1, int indice2, int soma){
  if(indice1 == indice2){
    printf("s[%d] = %d", indice1+1, soma);
  }else if(indice1 != indice2){
    printf("s[%d]", indice1);
    for(int i = indice1+1; i < indice2;i++){
      printf(" + s[%d]", i);
    }
    printf(" = %d", soma);
  }else if(indice1 == 0 && indice2 == -1){
    
    printf("Nenhuma subsequencia soma %d\n", soma);
  }
}

//funciona
int soma_vetor(int sequencia[], int indice1, int indice2){
  int soma = 0;
  for(int i = indice1; i <= indice2; i++){
    soma += sequencia[i];
  }
  return soma;
}

//errada
void iterador(int subsequencia[], int comprimento, int soma){
  int valor, itera_indice = 0, itera_comprimento = 0;

  valor = soma_vetor(subsequencia, itera_indice, itera_comprimento);

  if(valor == soma){
    mostra_resultado(subsequencia,itera_indice,itera_comprimento,soma);
  }else{
    for(itera_comprimento = 0; itera_comprimento < comprimento && valor != soma; itera_comprimento++){
      for(itera_indice = 1; itera_indice < comprimento && valor != soma; itera_indice++){
        valor = soma_vetor(subsequencia, itera_indice, itera_indice + itera_comprimento);
      }
    }
    if(itera_comprimento == 0 && itera_indice == 1){
      itera_indice --;
      itera_comp--;
      mostra_resultado(subsequencia,itera_indice,itera_comprimento,soma);
    }else{
      mostra_resultado(subsequencia,itera_indice,itera_indice+itera_comprimento,soma);
    }
  }
}


int main()
{

  int n, soma;

  scanf("%d \n", &n);
  int sequencia[n];

  if(n<1 || n>1000){
    return 0;
  }

  for(int i = 0; i < n; i++){
    scanf("%d", &sequencia[i]);
  }

  scanf("%d", &soma);

  iterador(sequencia,n,soma);
}
