#include <stdio.h>

double tr(double n);
int fact(int N);

int main(void)
{
    int c;
    int i, n;
    printf("Enter N : \n");
    scanf("%i",&n);
    for(i = 0; i < n; i++)
    {
        c = (int)tr(i);
        if( i % 5 == 0)
        {
            printf("%-2i\n", c);
            printf("%i\n", c);
        }
    }


    int j;
    for(j = 0 ; j <= 10; j++)
        printf("the factorial of %i is: %i \n",j,fact(j));
    return 0;
}

double tr(double n)
{
    double c = (n*(n + 1))/2;
    return c;
}

int fact(int N)
{
    int c = 1;
    int i;
    for(i = N; i > 0; i--)
    {
        c = c * i;
    }
    return c;
}
