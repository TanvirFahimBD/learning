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

    // int mark;
    // scanf("%d", &mark);

    // if (mark >= 33 && mark <= 100)
    // {
    //     printf("You have Passed\n");

    //     if (mark >= 80 && mark <= 100)
    //     {
    //         printf("You have got A+\n");
    //         if (mark >= 90 && mark <= 100)
    //         {
    //             printf("Congrats! You have got also a Scholarship\n");
    //         }
    //     }
    //     else if (mark >= 70 && mark <= 79)
    //     {
    //         printf("You have got A\n");
    //     }
    //     else if (mark >= 60 && mark <= 69)
    //     {
    //         printf("You have got A-\n");
    //     }
    //     else if (mark >= 50 && mark <= 59)
    //     {
    //         printf("You have got B\n");
    //     }
    //     else if (mark >= 40 && mark <= 49)
    //     {
    //         printf("You have got C\n");
    //     }
    //     else if (mark >= 33 && mark <= 39)
    //     {
    //         printf("You have got D\n");
    //     }
    // }
    // else if (mark >= 0 && mark <= 32)
    // {
    //     printf("You have Failed\n");
    //     printf("You have got F\n");
    // }
    // else
    // {
    //     printf("Invalid mark\n");
    // }

    // * 5.4 - Capital, Small or DIgit
    // char value;
    // scanf("%c", &value);

    // if (value >= '0' && value <= '9')
    // {
    //     printf("IS DIGIT\n");
    // }
    // else
    // {
    //     printf("ALPHA\n");
    //     if (value >= 'A' && value <= 'Z')
    //     {
    //         printf("IS CAPITAL\n");
    //     }
    //     else if (value >= 'a' && value <= 'z')
    //     {
    //         printf("IS SMALL\n");
    //     }
    // }

    // * 5.5 - Odd Even Positive Negative
    // int value;
    // scanf("%d", &value);

    // if (value % 2 == 0)
    // {
    //     printf("Odd\n");
    //     if (value >= 0)
    //     {
    //         printf("Positive\n");
    //     }
    //     else
    //     {
    //         printf("Negative\n");
    //     }
    // }
    // else
    // {
    //     printf("Even\n");
    //     if (value >= 0)
    //     {
    //         printf("Positive\n");
    //     }
    //     else
    //     {
    //         printf("Negative\n");
    //     }
    // }

    // * 5.6 - Minimum and Maximum
    int num1, num2, num3;
    scanf("%d %d %d", &num1, &num2, &num3);

    // min
    if (num1 <= num2 && num1 <= num3)
    {
        printf("%d", num1);
    }
    else if (num2 <= num1 && num2 <= num3)
    {
        printf("%d", num2);
    }
    else
    {
        printf("%d", num3);
    }

    printf(" ");

    // max
    if (num1 >= num2 && num1 >= num3)
    {
        printf("%d", num1);
    }
    else if (num2 >= num1 && num2 >= num3)
    {
        printf("%d", num2);
    }
    else
    {
        printf("%d", num3);
    }

    return 0;
}