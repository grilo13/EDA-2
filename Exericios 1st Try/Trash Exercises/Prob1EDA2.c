#include <stdio.h>
#include <math.h>

void fatorizar(unsigned int n){
  printf("%d = ", n);
  int resultado = 0;
  unsigned int j = 2;



  for(int i = 2; i <= ((int)floor(sqrt(n))); i++) {
      if (n % i == 0) {
       resultado++;
       break;
      }
    }

    if(resultado != 0){

        while(n > 1){

        if(n % j == 0){
          printf("%u ", j);
          n /= j;
        }else{
          j++;
        }
     }

    }else{

      printf("%u ", n);
    }
    
   /*for(int i=2; i<((int)floor(sqrt(n)))+1; i++)
   {
        if(n % i == 0){

        printf("%d ", i);
        n = n/i;

    }   else {

        n = n;

    }

   }*/

  /*int i = 2;

  while(i<((int)floor(sqrt(n))+1)){

      while(n % i == 0){

          if(n > 1){

              n = n / i;
              printf("%u ", i);
          }
      }
  }*/
}

int main()
{
  int numero,i;
  unsigned int numero1;

  scanf("%d", &numero);

  if(numero>1000){
    return 0;
  }

  for(i=0; i<numero;i++){
    scanf("%u", &numero1);
    fatorizar(numero1);
    printf("\n");
  }
}