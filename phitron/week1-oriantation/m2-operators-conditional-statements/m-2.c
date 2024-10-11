#include <stdio.h>
#include <stdbool.h>

int main()
{
    // * arithmatic operations
    //  int a, b;
    //  scanf("%d", &a);
    //  scanf("%d", &b);
    //  printf("%d + %d = %d \n", a, b, a + b);
    //  printf("%d - %d = %d \n", a, b, a - b);
    //  printf("%d * %d = %d \n", a, b, a * b);
    //  printf("%d / %d = %d \n", a, b, a / b);
    //  printf("%d %% %d = %d \n", a, b, a % b);

    // exceptional cases
    // int a = 100000;
    // double b = 100000;
    // long long result = a * b;
    // printf("%lld", result);

    // int a = 100000, b = 100000;
    // long long result = 1ll * a * b;
    // printf("%lld", result);

    // printf("%d\n", 5 / 3);
    // printf("%f\n", 5 / 3.0);
    // printf("%d\n", 0 / 5);

    // create error
    //  printf("%d", 5 / 0);

    //* assignment operator
    // int a = 10;
    // printf("%d\n", a++);
    // printf("%d\n", a);
    // printf("%d\n", ++a);

    //* relational operator
    // int a = 10, b = 10;
    // bool isEqual = a == b;
    // bool flag = a >= b;
    // printf("%d\n", isEqual);
    // printf("%d\n", flag);

    //* Logical operator
    // bool res = 2 < 5;
    // bool res2 = (2 < 5) && (3 > 10);
    // bool res3 = (2 < 5) || (3 > 10);
    // bool res4 = !(2 < 5);
    // printf("%d\n", res);
    // printf("%d\n", res2);
    // printf("%d\n", res3);
    // printf("%d\n", res4);

    //* conditional statement
    // int a = 5;
    // printf("Before if\n");
    // if (a < 3)
    // {
    //     printf("Inside if\n");
    // }

    // printf("After if\n");

    // int eggPrice = 100;
    // if (eggPrice <= 50)
    // {
    //     printf("Bug 4 eggs");
    // }
    // else
    // {
    //     printf("Buy 2 eggs");
    // }

    //* if else ladder
    // int eggPrice = 70;
    // if (eggPrice <= 80)
    // {
    //     printf("Bug 4 eggs");
    // }
    // else if (eggPrice <= 40)
    // {
    //     printf("Bug 2 eggs");
    // }
    // else
    // {
    //     printf("Buy 1 egg");
    // }

    //* nested if else ladder
    // int tourDays = 4;
    // if (tourDays == 2)
    // {
    //     bool hasBoat = true;
    //     if (hasBoat)
    //     {
    //         printf("Go haor");
    //     }
    //     else
    //     {
    //         printf("Go hill area");
    //     }
    // }
    // else if (tourDays == 4)
    // {

    //     bool hasBoat = true;
    //     if (hasBoat)
    //     {
    //         printf("Go remote area");
    //     }
    //     else
    //     {
    //         printf("Go sea beach");
    //     }
    // }
    // else
    // {
    //     printf("No time for tour");
    // }

    //* switch  case
    // int tourDays = 2, haveMoney = 0;
    // switch (tourDays)
    // {
    // case 4:
    //     switch (haveMoney)
    //     {
    //     case 1:
    //         printf("Go for tour\n");
    //         break;
    //     default:
    //         printf("Family time\n");
    //     }
    //     break;

    // default:
    //     printf("Task to do\n");
    // }

    double a = 15 / 4;
    printf("%lf", a);

    return 0;
}