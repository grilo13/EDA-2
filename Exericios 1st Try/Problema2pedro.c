#include <stdio.h>


void resultado(int sub[], int indice1, int indice2, int soma)
{
  if(indice1 == indice2)
  {
    printf("s[%d] = %d\n",indice1+1,soma);
  }
  else if(indice1 != indice2)
  {
    if(indice2-indice1>1)
    {
      printf("s[%d] +",indice1+1);
      for(int i = indice1+1; i <= indice2;i++)
      {
        if(i==indice2)
        {
          printf(" ... + s[%d]", i+1);
        }
      }
      printf(" = %d\n",soma);
    }else
    {
      printf("s[%d] + s[%d] = %d\n",indice1 + 1 ,indice2+1, soma);
    }
  }
}

int somatorio(int sequencia[], int indice1, int indice2){
  int soma = 0;

  for(int i = indice1; i <= indice2; i++){
    soma += sequencia[i];
  }
  return soma;
}



void iterar(int sub[], int tamanho, int soma){
  int valor,retira = 0;
  for(int comp = 0; comp < tamanho; comp++)
  {
    for(int itera_indice1 = 0; itera_indice1 < tamanho-retira; itera_indice1++)
    {
      int indice2 = itera_indice1+comp;
      valor = somatorio(sub, itera_indice1, indice2);
      if(valor == soma)
      {
        resultado(sub, itera_indice1, indice2, soma);
        return;
      }
    }
  retira++;
  }
  if(valor != soma)
  {
    printf("nenhuma subsequencia soma %d\n", soma);
  }
}



int main()
{
  int n, soma;


  scanf("%d", &n);
  int sequencia[n];

  for(int i = 0; i < n; i++)
  {
    scanf(" %d", &sequencia[i]);
  }

  scanf(" %d", &soma);

  iterar(sequencia, n, soma);
  return 0;
}
