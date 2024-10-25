#include <stdio.h>

int main()
{
    //* 9.3 - Array Insertion
    // int a[100000];
    // int length;
    // scanf("%d", &length);

    // for (int i = 0; i < length; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // int index, value;
    // scanf("%d%d", &index, &value);

    // length++;

    // for (int i = length - 1; i > index; i--)
    // {
    //     a[i] = a[i - 1];
    // }

    // a[index] = value;

    // for (int i = 0; i < length; i++)
    // {
    //     printf("%d ", a[i]);
    // }

    // return 0;

    //* 9.4 - Deleting an Element from an Array
    // int a[100000];
    // int length;
    // scanf("%d", &length);

    // for (int i = 0; i < length; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // int index;
    // scanf("%d", &index);

    // for (int i = index; i < length - 1; i++)
    // {
    //     a[i] = a[i + 1];
    // }

    // for (int i = 0; i < length - 1; i++)
    // {
    //     printf("%d ", a[i]);
    // }

    // return 0;

    //* 9.5 - Array Reverse With Two Arrays
    // int length;
    // scanf("%d", &length);
    // int a[length + 1], b[length + 1];

    // for (int i = 0; i < length; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = 0, j = length - 1; i < length; i++, j--)
    // {
    //     b[j] = a[i];
    // }

    // for (int j = 0; j < length; j++)
    // {
    //     printf("%d ", b[j]);
    // }

    // return 0;

    //* 9.6 - Array Reverse Using Single Array
    // int n, length = 0, temp = 0;
    // scanf("%d", &n);
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     scanf("%d", &a[i]);
    // }
    // for (int i = 0, j = n - 1; i <= j; i++, j--)
    // {
    //     temp = a[i];
    //     a[i] = a[j];
    //     a[j] = temp;
    // }

    // for (int i = 0; i < n; i++)
    // {
    //     printf("%d ", a[i]);
    // }

    // return 0;

    //* 9.6 - Array Reverse Using Single Array
    int n, length = 0, temp = 0;
    scanf("%d", &n);
    int a[n];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0, j = n - 1; i <= j; i++, j--)
    {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    for (int i = 0; i < n; i++)
    {
        printf("%d ", a[i]);
    }

    return 0;
}