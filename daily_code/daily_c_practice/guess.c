#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
  srand(time(0));
  int a = rand() % 100 +1;
  int n = 0;
  int number;
  printf("Input: ");
  do
  {
    scanf("%d", &number);
    n++;
    if (number < a)
    {
        printf("Smaller! ");
    }
    else if (number >a)
    {
        printf("Bigger! ");
    }
  }
  while (a != number);
  printf("You are right! You guessed %d times!\n", n);
  return 0;
}