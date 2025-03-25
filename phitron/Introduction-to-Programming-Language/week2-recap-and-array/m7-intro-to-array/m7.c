#include <stdio.h>
#include <limits.h>

int main()
{
    // 7.4 Initializing an Accessing and Array
    // char a[5];
    // for (int i = 0; i < 5; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = 0; i < 5; i++)
    // {
    //     printf("%d ", a[i]);
    // }

    // 7.6 Sum and Average of An Array Elements
    // char a[5];
    // int sum = 0;
    // double avg = 0;
    // for (int i = 0; i < 5; i++)
    // {
    //     scanf("%d", &a[i]);
    // }

    // for (int i = 0; i < 5; i++)
    // {
    //     sum += a[i];
    // }

    // avg = (double)sum / 5;

    // printf("%d\n", sum);
    // printf("%.2lf", avg);

    // 7.7 Min Max of an Array
    // int a[5], min = INT_MAX, max = INT_MIN;
    int a[5], min, max;

    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &a[i]);
    }

    min = a[0];
    max = a[0];

    for (int i = 1; i < 5; i++)
    {
        if (a[i] < min)
        {
            min = a[i];
        }

        if (a[i] > max)
        {
            max = a[i];
        }
    }

    printf("%d\n", min);
    printf("%d", max);

    return 0;
}