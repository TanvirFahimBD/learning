#include <stdio.h>
#include <string.h>
#include <math.h>

//* 18-3.Print 1 To N
// void fun(int x, int n)
// {
//     if (x > n)
//     {
//         printf("\n");
//         return;
//     }
//     printf("%d\n", x);
//     printf("Before function call X= %d\n", x);
//     fun(x + 1, n);
//     printf("After function call X= %d\n", x);
// }

// int main()
// {
//     fun(1, 6);

//     return 0;
// }

//* 18-4. Understanding Call Flow and Return
// void fun2()
// {
//     printf("Inside Func2\n");
// }

// void fun1()
// {
//     printf("Before Func1\n");
//     fun2();
//     printf("After Func1\n");
// }

// int main()
// {
//     printf("Before Main\n");
//     fun1();
//     printf("After Main\n");
//     return 0;
// }

//* 18-5. Printing N to 1
// void fun(int x, int n)
// {
//     if (x > n)
//     {
//         return;
//     }

//     fun(x + 1, n);
//     printf("%d\n", x);
// }

// int main()
// {
//     fun(1, 10);
//     return 0;
// }

//* 18-6. Sum of an Array
// int a[100000], sum;

// int goToIndex(int i, int n)
// {
//     if (i == n)
//     {
//         return;
//     }

//     sum += a[i];
//     goToIndex(i + 1, n);
// }

// int main()
// {
//     int n;
//     scanf("%d\n", &n);

//     for (int i = 0; i < n; i++)
//     {
//         scanf("%d", &a[i]);
//     }

//     sum = 0;

//     goToIndex(0, n);

//     printf("%d\n", sum);
//     return 0;
// }

//* 18-6. Sum of an Array
int a[100000];

int getSum(int i, int n)
{
    if (i == n)
    {
        return 0;
    }

    return a[i] + getSum(i + 1, n);
}

int main()
{
    int n;
    scanf("%d\n", &n);

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    int res = getSum(0, n);

    printf("%d\n", res);
    return 0;
}
