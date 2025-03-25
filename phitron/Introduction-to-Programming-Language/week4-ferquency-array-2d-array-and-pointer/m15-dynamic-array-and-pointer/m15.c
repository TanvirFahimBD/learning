#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main()
{
    //* 15 - 3. Working with Pointers
    // int a = 5;

    // int *b = &a;

    // printf("%d\n", &a);
    // printf("%d\n\n", b);

    // printf("%d\n", a);
    // printf("%d\n", *b);

    // *b = 3;
    // printf("%d\n", a);

    // int a = 5, b = 6;

    // printf("%d %d\n", a, b);

    // int *x = &a, *y = &b;

    // int temp = *x;
    // *x = *y;
    // *y = temp;

    // printf("%d %d\n", a, b);

    // return 0;

    //* 15 - 4. Pointer & Array
    // int arr[5] = {1, 2, 3, 4, 5};

    // int *p = arr;

    // printf("%d %d\n", &arr[0], p);
    // printf("%d %d\n", p + 1, p + 2);

    // int a = 6;
    // int *x = &a;
    // printf("%d %d\n", &a, x);

    // char b = 6;
    // char *y = &b;
    // printf("%d %d %d\n", &b, y, y + 1);

    // return 0;

    //* 15 - 6. Implemnting Dynamic Array
    int *arr = (int *)malloc(5 * sizeof(int));

    for (int i = 0; i < 5; i++)
    {
        arr[i] = i + 1;
    }

    for (int i = 0; i < 5; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    int *temp = arr;

    arr = (int *)realloc(arr, 10 * sizeof(int));

    if (arr == NULL)
    {
        arr = temp;
    }

    for (int i = 0; i < 10; i++)
    {
        arr[i] = i + 1;
    }

    for (int i = 0; i < 10; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;

    // int x = 10;
    // int *p = &x;
    // x++;
    // printf("%d", *p);
    // return 0;
    // int x = 10;
    // int *p = &x;
    // int y = 20;
    // *p = ++y;
    // x++;
    // printf("%d", x);
    // int x = 100;
    // int *p = &x;
    // printf("%d\n", p);
    // int a[4] = {1, 2, 3, 4};
    // int *p;
    // p = a + 2;
    // p++;
    // *p = 100;
    // for (int i = 0; i < 4; i++)
    // {
    //     printf("%d\n", a[i]);
    // }
    // int x, y, z;
    // x = 10, y = 20, z = 30;
    // int *p, *q;
    // p = &x;
    // q = &y;
    // *p = 40;
    // x = 50;
    // q = p;
    // printf("%d", *q);
    // return 0;
}