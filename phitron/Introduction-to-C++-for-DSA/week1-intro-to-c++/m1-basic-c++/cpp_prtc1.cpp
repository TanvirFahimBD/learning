#include <bits/stdc++.h>
using namespace std;

// int main()
// {
// https://codeforces.com/group/MWSDmqGsZm/contest/219432/problem/E
// E.Max
// int n;
// cin >> n;
// int arr[n];
// for (int i = 0; i < n; i++)
// {
//     cin >> arr[i];
// }
// int mx = INT_MIN;
// for (int i = 0; i < n; i++)
// {
//     // if (arr[i] > mx)
//     // {
//     //     mx = arr[i];
//     // }
//     mx = max(arr[i], mx);
// }
// cout << mx << endl;

// https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/F
// F. Reversing
// int n;
// cin >> n;
// int arr[n];
// for (int i = 0; i < n; i++)
// {
//     cin >> arr[i];
// }

// for (int i = 0, j = n - 1; i < n / 2; i++, j--)
// {
//     // int temp = arr[i];
//     // arr[i] = arr[j];
//     // arr[j] = temp;
//     swap(arr[i], arr[j]);
// }

// for (int i = 0; i < n; i++)
// {
//     cout << arr[i] << " ";
// }

// https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/M
// M. Capital or Small or Digit
// char c;
// cin >> c;
// if (c >= '0' && c <= '9')
// {
//     cout << "IS DIGIT" << endl;
// }
// else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
// {
//     cout << "ALPHA" << endl;
//     if (c >= 'a' && c <= 'z')
//     {
//         cout << "IS SMALL" << endl;
//     }
//     else if (c >= 'A' && c <= 'Z')
//     {
//         cout << "IS CAPITAL" << endl;
//     }
// }

// https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/C
// C. Simple Calculator
// int x, y;
// cin >> x >> y;
// int sum = x + y;
// long long mul = 1LL * x * y;
// int sub = x - y;

// cout << x << " + " << y << " = " << sum << endl;
// cout << x << " * " << y << " = " << mul << endl;
// cout << x << " - " << y << " = " << sub << endl;

// https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/K
// K. Max and Min
// int x, y, z, min, max;
// cin >> x >> y >> z;

// if ((x <= y) && (x <= z))
// {
//     min = x;
// }
// else if ((y <= x) && (y <= z))
// {
//     min = y;
// }
// else
// {
//     min = z;
// }

// if ((x >= y) && (x >= z))
// {
//     max = x;
// }
// else if ((y >= x) && (y >= z))
// {
//     max = y;
// }
// else
// {
//     max = z;
// }

// return 0;
// }

// https://docs.google.com/document/d/1oHwyJVnvl6wFvXi-NAKLUab_I4rzrTkw/edit

// int *get_array(int n)
// {
//     int *arr = new int[n];
//     for (int i = 0; i < n; i++)
//     {
//         cin >> arr[i];
//     }

//     return arr;
// }

// int main()
// {
//     int n;
//     cin >> n;
//     int *a = get_array(n);

//     for (int i = 0; i < n; i++)
//     {
//         cout << a[i] << " ";
//     }

//     return 0;
// }

int main()
{
    int n, m;
    cin >> n;
    int *a = new int[n];

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    cin >> m;
    int *b = new int[m];

    for (int i = 0; i < n; i++)
    {
        b[i] = a[i];
    }

    delete[] a;

    for (; n < m; n++)
    {
        cin >> b[n];
    }

    for (int i = 0; i < m; i++)
    {
        cout << b[i] << " ";
    }

    return 0;
}