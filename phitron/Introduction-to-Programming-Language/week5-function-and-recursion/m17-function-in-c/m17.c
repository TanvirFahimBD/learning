#include <stdio.h>
#include <string.h>
#include <math.h>

//* 17-3 Return + Parameter
// int add(int a, int b)
// {
//     int sum = a + b;
//     return sum;
// }

// int main()
// {
//     int result = add(10, 20);
//     printf("%d\n", result);

//     return 0;
// }

//* 17-4 Return + No Parameter
// int a = 10, b = 30;
// int add()
// {
//     int sum = a + b;
//     return sum;
// }
// double getPi()
// {
//     return 3.14159;
// }

// int main()
// {
//     // int result = add();
//     // printf("%d\n", result);

//     double piRes = getPi();
//     printf("%lf\n", piRes);

//     return 0;
// }

//* 17-5 No Return + Parameter
// void alphaCheck(char c)
// {
//     if ('a' <= c && c <= 'z')
//         printf("Lower\n");
//     else
//         printf("Upper\n");
// }

// int main()
// {
//     alphaCheck('F');
//     alphaCheck('z');

//     return 0;
// }

//* 17-6 No Return + No Parameter
// void add()
// {
//     int a, b;
//     scanf("%d %d", &a, &b);
//     int sum = a + b;
//     printf("%d\n", sum);
// }

// int main()
// {
//     add();

//     return 0;
// }

//* 17-7 Usefull Built in Functions

// int main()
// {
//     double a = 10.50;

//     printf("%lf\n", ceil(a));
//     printf("%lf\n", floor(a));
//     printf("%lf\n", round(a));
//     printf("%lf\n", sqrt(25));
//     printf("%lf\n", pow(2, 3));

//     return 0;
// }

//* 17- 8 Variable Scope
// int a = 10, b = 50;

// int add(a, b)
// {
//     printf("Add %p %p\n", &a, &b);
// }

// int main()
// {
//     // int a = 10, b = 50;

//     printf("Main %p %p\n", &a, &b);
//     add(a, b);

//     return 0;
// }

//* 17-9 Pointers with Function
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
    printf("swap add %p %p\n", x, y);
    printf("swap val %d %d\n", *x, *y);
}

int main()
{
    int a = 10, b = 67;
    printf("Main add %p %p\n", &a, &b);
    printf("Main val %d %d\n", a, b);
    swap(&a, &b);
    return 0;
}
