#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void fator(unsigned int a) {

	printf("%d: ", a);

    if(a >= 1 && a<=(pow(2,32)-1)) {
        while(a % 2 == 0){
            printf("%d ", 2);
            a=a/2;
        }

        for(int i = 3; i<=sqrt(a);i=i+2){
            while(a%i == 0){
                printf("%d ", i);
                a=a/i;
            }
        }
        if(a >2){
            printf("%u ", a);
        }

    } else  {
      printf(" ");
    }

	/*for(int i=2; a>1; i++){
		for(int j=2; a>1; j++){
			while(a%j==0){
				printf("%d ", j);
				a /= j;
				}
			}
		}*/
} 

int main() {

	int n;
	int num[1000];

	scanf("%d", &n);

	for(int i=0; i<n; i++) {
		scanf("%d", &num[i]);
	}

	for(int j=0;j<n;j++){
        fator(num[j]);
        printf("\n");
  }
}