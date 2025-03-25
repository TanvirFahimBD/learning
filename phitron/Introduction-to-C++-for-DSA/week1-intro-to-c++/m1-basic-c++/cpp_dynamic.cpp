#include <bits/stdc++.h>
using namespace std;

//* static variable -static memory
// int *p;
// void func()
// {
//     int x = 10;
//     p = &x;
//     cout << "func :" << *p << endl;
//     return;
// }

// int main()
// {
//     func();
//     cout << "main :" << *p << endl;
//     return 0;
// }

//* dynamic variable - heap memory
int *p;
// void func()
// {
//     int *x = new int;
//     *x = 10;
//     p = x;
//     cout << "func :" << *p << endl;
//     return;
// }

// int main()
// {
//     func();
//     cout << "main :" << *p << endl;
//     return 0;
// }

//* static - dynamic array
// int main()
// {
//     // int a[5];  //static array

//     int *a = new int[5]; // dynamic array
//     for (int i = 0; i < 5; i++)
//     {
//         cin >> a[i];
//     }

//     for (int i = 0; i < 5; i++)
//     {
//         cout << a[i] << " ";
//     }

//     return 0;
// }

//* return dynamic array
// int *func()
// {
//     // int a[5];
//     int *a = new int[5];
//     for (int i = 0; i < 5; i++)
//     {
//         cin >> a[i];
//     }
//     return a;
// }

// int main()
// {
//     int *x = func();
//     for (int i = 0; i < 5; i++)
//     {
//         cout << x[i] << " ";
//     }

//     return 0;
// }

//* dynamic array sizes increase
int main()
{
    int *a = new int[3];
    for (int i = 0; i < 3; i++)
    {
        cin >> a[i];
    }

    int *b = new int[5];
    for (int i = 0; i < 3; i++)
    {
        b[i] = a[i];
    }
    b[3] = 50;
    b[4] = 100;
    delete[] a;

    for (int i = 0; i < 5; i++)
    {
        cout << b[i] << " ";
    }

    return 0;
}