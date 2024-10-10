#include <stdio.h>

int main()
{
    // * 5.2 - Grading System (Simple)
    // int mark;
    // scanf("%d", &mark);

    // if (mark >= 80 && mark <= 100)
    // {
    //     printf("You have got A+\n");
    // }
    // else if (mark >= 70 && mark <= 79)
    // {
    //     printf("You have got A\n");
    // }
    // else if (mark >= 60 && mark <= 69)
    // {
    //     printf("You have got A-\n");
    // }
    // else if (mark >= 50 && mark <= 59)
    // {
    //     printf("You have got B\n");
    // }
    // else if (mark >= 40 && mark <= 49)
    // {
    //     printf("You have got C\n");
    // }
    // else if (mark >= 33 && mark <= 39)
    // {
    //     printf("You have got D\n");
    // }
    // else if (mark >= 0 && mark <= 32)
    // {
    //     printf("You have got F\n");
    // }
    // else
    // {
    //     printf("Invalid mark\n");
    // }

    // * 5.3 - Grading System (Extended)

    int mark;
    scanf("%d", &mark);

    if (mark >= 33 && mark <= 100)
    {
        printf("You have Passed\n");

        if (mark >= 80 && mark <= 100)
        {
            printf("You have got A+\n");
            if (mark >= 90 && mark <= 100)
            {
                printf("Congrats! You have got also a Scholarship\n");
            }
        }
        else if (mark >= 70 && mark <= 79)
        {
            printf("You have got A\n");
        }
        else if (mark >= 60 && mark <= 69)
        {
            printf("You have got A-\n");
        }
        else if (mark >= 50 && mark <= 59)
        {
            printf("You have got B\n");
        }
        else if (mark >= 40 && mark <= 49)
        {
            printf("You have got C\n");
        }
        else if (mark >= 33 && mark <= 39)
        {
            printf("You have got D\n");
        }
    }
    else if (mark >= 0 && mark <= 32)
    {
        printf("You have Failed\n");
        printf("You have got F\n");
    }
    else
    {
        printf("Invalid mark\n");
    }

    return 0;
}