#include <stdio.h>
int main(void) 
{
    double num, maxNum;
    do 
    {
        printf("Enter a number: ");
        scanf("%lf", &num);
        if (num > maxNum) 
        {
            maxNum = num;
        }
    } while (num < 0);
    printf("The largest positive number entered was: %lf", maxNum);
    return 0;
}