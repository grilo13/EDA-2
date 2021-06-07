#include <stdio.h>
#include <math.h>

void fatorizar(unsigned int n){

  unsigned int fator = 2, resultado = 0;

    for(int i = 2; i <= ((int)floor(sqrt(n))); i++) {
      if (n % i == 0) {
       resultado++;
       break;
      }
    }

    if(resultado != 0){
      while(n > 1){
        if(n % fator == 0){
          printf("%u ", fator);
          n /= fator;
        }else{
          fator++;
        }
      }
    }else{
      printf("%u ", n);
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
