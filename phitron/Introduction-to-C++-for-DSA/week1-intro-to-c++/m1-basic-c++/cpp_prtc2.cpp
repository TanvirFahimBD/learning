#include <bits/stdc++.h>
using namespace std;
int main()
{
    // https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/V
    // V. Comparison
    // int a, b;
    // char c;
    // cin >> a;
    // cin >> c;
    // cin >> b;

    // if (c == '>')
    // {
    //     if (a > b)
    //     {
    //         cout << "Right";
    //     }
    //     else
    //     {
    //         cout << "Wrong";
    //     }
    // }
    // else if (c == '<')
    // {
    //     if (a < b)
    //     {
    //         cout << "Right";
    //     }
    //     else
    //     {
    //         cout << "Wrong";
    //     }
    // }
    // else if (c == '=')
    // {
    //     if (a == b)
    //     {
    //         cout << "Right";
    //     }
    //     else
    //     {
    //         cout << "Wrong";
    //     }
    // }

    // https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/W
    // W. Mathematical Expression
    // int a, b;
    // char c1, c2;
    // long long int r1, res;
    // cin >> a;
    // cin >> c1;
    // cin >> b;
    // cin >> c2;
    // cin >> r1;

    // if (c1 == '+')
    // {
    //     res = 1LL * (a + b);
    //     if (a + b == r1)
    //     {
    //         cout << "Yes";
    //     }
    //     else
    //     {
    //         cout << res;
    //     }
    // }
    // else if (c1 == '-')
    // {
    //     res = a - b;
    //     if (a - b == r1)
    //     {
    //         cout << "Yes";
    //     }
    //     else
    //     {
    //         cout << res;
    //     }
    // }
    // else if (c1 == '*')
    // {
    //     res = 1LL * (a * b);
    //     if (a * b == r1)
    //     {
    //         cout << "Yes";
    //     }
    //     else
    //     {
    //         cout << res;
    //     }
    // }

    // https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/G
    // G. Palindrome Array
    // int n, flag = 0;
    // cin >> n;
    // int a[n];

    // for (int i = 0; i < n; i++)
    // {
    //     cin >> a[i];
    // }

    // for (int i = 0, j = n - 1; i < n / 2; i++, j--)
    // {
    //     if (a[i] != a[j])
    //     {
    //         flag = 1;
    //         break;
    //     }
    // }

    // if (flag == 1)
    // {
    //     cout << "NO";
    // }
    // else
    // {
    //     cout << "YES";
    // }

    // https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/I
    // I. Smallest Pair
    // int t, n;
    // long long int minPrev, minNow = INT_MAX;
    // cin >> t;

    // while (t)
    // {
    //     cin >> n;
    //     int a[n + 1];
    //     for (int i = 1; i <= n; i++)
    //     {
    //         cin >> a[i];
    //     }

    //     for (int i = 1; i <= n; i++)
    //     {
    //         for (int j = i + 1; j <= n; j++)
    //         {
    //             minPrev = a[i] + a[j] + j - i;

    //             minNow = min(minNow, minPrev);
    //         }
    //     }

    //     cout << minNow;

    //     t--;
    // }

    // https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/H
    // H. Sorting
    int n;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    sort(a, a + n);
    for (int i = 0; i < n; i++)
    {
        cout << a[i] << " ";
    }

    return 0;
}