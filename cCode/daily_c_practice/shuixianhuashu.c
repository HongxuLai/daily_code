#include <stdio.h>
int main()
{
    int n;
    printf("Input: ");
    scanf("%d", &n);
    int first = 1;
    int i = 1;
    while (i < n)
    {
        first *= 10;
        i ++;
    }
    i = first;
    while (i < first * 10)
    {
        int t = i;
        int sum = 0;
        while (t > 0)
        {
            int d = t % 10;
            int pd = 1;
            for (int k = 0; k < n; k++)
            {
                pd *= d;
            }
            sum += pd;
            t /= 10;
        }
        if (sum == i)
        {
            printf("%d\n", i);
        }
        i++;
    }
    return 0;
}