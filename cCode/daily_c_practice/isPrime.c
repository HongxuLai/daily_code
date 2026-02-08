#include <stdio.h>
#include <stdlib.h>
int main()
{
    int n;
    printf("Input range n: ");
    scanf("%d", &n);
    char *isPrime = (char *)malloc(n * (sizeof(char)));
    int x;
    int i;
    if (isPrime == NULL) 
    {
        printf("Memory allocation failed!\n");
        return 1; 
    }
    for(i = 0; i < n; i++)
    {
        isPrime[i] = 1;
    }
    for (x = 2; x < n; x++)
    {
        if (isPrime[x])
        {
            for (i = 2; i * x < n; i++)
            {
                isPrime[i * x] = 0;
            }
        }
    }
    for (i = 2; i < n; i ++)
    {
        if (isPrime[i])
        {
            printf("%d\t", i);
        }
    }
    printf(" \n");
    return 0;
    free(isPrime);
}