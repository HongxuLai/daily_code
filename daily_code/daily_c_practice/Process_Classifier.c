#include <stdio.h>
int main(void)
{
    int pid;
    printf("Input: ");
    scanf("%d", &pid);
    if (0 <= pid && pid <= 100)
    {
        printf("system process\n");
    }
    else if (101 <= pid && pid <= 10000)
    {
        printf("user process\n");
    }
    else 
    {
        printf("invalid\n");
    }
}
