#include <stdio.h>
int main() {
  int sum = 0;
  int n = 0;
  int a;
  printf("Input: ");
  scanf("%d", &a);
  while (a != -1) {
    sum += a;
    n++;
    scanf("%d", &a);
  }
  float mean = 1.0 * sum / n;
  printf("Mean number is %f\n", mean);
}