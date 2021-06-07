#include <stdio.h>

int subArraySum(int arr[], int n, int sum) 
{ 
    int curr_sum = arr[0];
    int start_index = 0;    
  
    for (int i = 1; i <= n; i++) 
    { 
        while(curr_sum > sum && start_index < i-1)
        {
           curr_sum = curr_sum - arr[start_index];
           start_index++;
        }
        
        if(curr_sum == sum)
        {
            if(start_index == i - 1)
            {
                printf("s[%d] = %d", start_index + 1, sum);
            } 
            else 
            {
                while(start_index < i - 1)
                {
                    printf("s[%d] + ", start_index + 1);
                    start_index++;
                }
                printf("s[%d] = %d", start_index + 1, sum);
            }
            return 1;
        }
        if(i < n)
        {
           curr_sum = curr_sum + arr[i];
        }
    } 
    printf("nenhuma subsequência soma %d", sum); 
    return 0; 
} 


int main(){

    int valor_soma;
    int tamanho;

    scanf("%d ", &tamanho);

    int arr[tamanho];

    for(int i = 0; i < tamanho; i++){
        scanf("%d ", &arr[i]);
    }

    scanf("%d", &valor_soma);

    subArraySum(arr,tamanho, valor_soma);

    return 0; 
} 