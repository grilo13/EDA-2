#include <stdio.h>
#include <math.h>

void fatorizar(unsigned int n){

  if(n > 0){
       while (n%2 == 0) 
    { 
        printf("%d ", 2); 
        n = n/2; 
    } 

    for (int i = 3; i <= sqrt(n); i = i+2) 
    { 
   
        while (n%i == 0) 
        { 
            printf("%d ", i); 
            n = n/i; 
        } 
    } 

    if (n > 2)
    {
        printf ("%u ", n); 
    }
 
  } else {

      return;
  }
}

int main(){
  int i, n;

  scanf("%u", &n);
  unsigned int numero[n];

  for(i=0;i<n;i++){
    scanf("%u", &numero[i]);
  }

  for(i=0;i<n;i++){
    printf("%u: ", numero[i]);
    fatorizar(numero[i]);
    printf("\n");
  }
}