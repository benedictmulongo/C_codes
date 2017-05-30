#include <stdio.h>
//This program find the sum of every digits in an arbitrary integer
// the user enter in the console
int main(void)
{
    int nom;
    printf("Enter a arbitrary integer, and find the sum of each of its digits : ");
    scanf("%i", &nom);
    int number = nom;
    //int nom = 14552;
    int mod = nom % 10;
    int div = nom / 10;
    int sum = 0;
    while(div != 0)
    {
        div = nom / 10;
        mod = nom % 10;
        nom = div;
        sum += mod;
        printf("mod : %i and div = %i \n",mod,div);
        printf("sum : %i and number = %i \n",sum,nom);
    }
    printf("The sum of each digits of %i is :  %i \n",number,sum);
    return 0;
}
