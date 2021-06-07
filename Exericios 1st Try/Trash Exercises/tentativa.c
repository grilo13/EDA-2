#include <stdio.h>
#include <math.h>


void fatorizar(unsigned int n){

    int fator = 2;

    while (fator <= sqrt(n)) 
    {
      while (n % fator == 0) 
        {
          n = n / fator; 
          printf("%d ", fator);
        }
      fator++; 
    
}
}


int main()
{
    int i, n;

  scanf("%u", &n);
  unsigned int numero[n];

  for(i=0;i<n;i++){
    scanf("%u", &numero[i]);
  }

  for(i=0;i<n;i++){
    printf("%u: ",numero[i]);fatorizar(numero[i]);
    printf("\n");
  }

  return 0;
}