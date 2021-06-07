#include <stdio.h>

void fatorizar(int n){

    for(int i = 2; n >1; i++){

        while(n % i == 0){

            printf("%d ", i);
            n = n / i;

        }
    }
}

int main(){

    int numero, i;
    int num[1000];

    scanf("%d", &numero);

    if(numero>1000){
        return 0;
    }

    for(i = 0; i<numero;i++){
        scanf("%d", &num[i]);
    }
    for(int j = 0; j<numero;j++){
        printf("%d = ", num[i]);
        fatorizar(num[i]);
    }

}