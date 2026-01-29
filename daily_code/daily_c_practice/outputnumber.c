#include <stdio.h>
int main()
{
    int x;
    printf("Input: ");
    int number[100];
    double sum = 0;
    int cnt = 0;
    scanf("%d", &x);
    while (x != -1)
    {
        number[cnt] = x;
        cnt++;
        sum += x;
        scanf("%d", &x);
    }
    if (cnt > 0)
    {
        printf("%f\n", sum / cnt);
        int i;
        for (i = 0; i < cnt; i++)
        {
            if (number[i] > sum / cnt)
            {
                printf("%d \n", number[i]);
            }
        }

    }
}