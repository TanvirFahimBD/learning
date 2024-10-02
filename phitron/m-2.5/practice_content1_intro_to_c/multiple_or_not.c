#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int num1, num2;
    scanf("%d", &num1);
    scanf("%d", &num2);
    if (num1 % num2 == 0)
    {
        printf("Yes");
    }
    else if (num2 % num1 == 0)
    {
        printf("Yes");
    }
    else
    {
        printf("No");
    }
    return 0;
}
