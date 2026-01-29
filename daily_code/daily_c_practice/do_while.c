#include <stdio.h>
int main()
{
    int x;
    printf("Input: ");
    scanf("%d", &x);
    int n = 0;
    do // always do such thing at least once because 0 is also a digit
    {
        x /= 10;
        n++;
    }
    while (x > 0); // check condition after doing at least once
    printf("Number of digits: %d\n", n);
    return 0;
}