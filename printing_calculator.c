
#include <stdio.h>

int main(void)
{
    float m, acc;
    char s, end;
    acc = 1;
    printf("Enter number + operator : ");
    while(end != 'E')
    {
        scanf("%f %c",&m,&s);
        if(s == 'S')
           acc = m;
        else if(s == '+')
           acc = acc + m;
        else if(s == '*')
           acc = acc * m;
        else if(s == '-')
           acc = acc - m;
        else if(s == '/')
           acc = acc / m;
        else if(s == 'E')
           end = 'E';
        else
        {
            printf("Failure !\n");
            end = 'E';
        }
        printf("= %f \n", acc);
    }
    printf("End of calculation. \n");
}



