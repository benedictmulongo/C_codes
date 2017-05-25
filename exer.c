
#include <stdio.h>
#include <string.h>

int gen(char c [], int N);

int main(void)
{
    double F, C;
    F = 27;
    C = (F- 32) / 1.8;

    printf("The %f  Fahrenheit degree is : %f Celsius \n", F,C);
    int N = 4;
    int i;
    char a [] = "*";
    char b [] = " *";
    strcat(a,b);
    gen("*",3);
//    for( i = 0; i < N; i++)
//    {
//        printf(a);
//    }
}

int gen(char c [], int N)
{
    printf("%s\n",c);
    char f [] = "*";
    strcat(f,c);
    if(N > 0)
    {
        gen(f,N--);
    }
    else
    {
        return 0;
    }
}

