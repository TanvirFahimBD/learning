// https://docs.google.com/document/d/1opBWGSgS0Kc51mwh9xWCF7n1TXwiadYF/edit
#include <bits/stdc++.h>
using namespace std;

// https : // codeforces.com/group/MWSDmqGsZm/contest/329103/problem/G
// G.Even Hate Odd
// int main()
// {
//     int t;
//     cin >> t;
//     while (t--)
//     {
//         int n, evenC = 0, oddC = 0, res = 0;
//         cin >> n;
//         int ar[n];

//         for (int i = 0; i < n; i++)
//         {
//             cin >> ar[i];
//         }

//         if (n % 2 != 0)
//         {
//             cout << -1 << endl;
//         }
//         else
//         {
//             for (int i = 0; i < n; i++)
//             {
//                 if (ar[i] % 2 == 0)
//                 {
//                     evenC++;
//                 }
//                 else
//                 {
//                     oddC++;
//                 }
//             }

//             if (evenC == n || oddC == n)
//             {
//                 res = n / 2;
//             }
//             else if (evenC == oddC)
//             {
//                 res = 0;
//             }
//             else if (evenC > oddC)
//             {
//                 res = (evenC - oddC) / 2;
//             }
//             else if (evenC < oddC)
//             {
//                 res = (oddC - evenC) / 2;
//             }

//             cout << res << endl;
//         }
//     }

//     return 0;
// }

// https://codeforces.com/group/MWSDmqGsZm/contest/223205/problem/H
// H. N Times
// int main()
// {
//     int t;
//     cin >> t;
//     while (t--)
//     {
//         int n;
//         cin >> n;
//         char c;
//         cin >> c;

//         for (int i = 0; i < n; i++)
//         {
//             cout << c << " ";
//         }
//         cout << endl;
//     }

//     return 0;
// }

// pricatice problem 1
// class Student
// {
// public:
//     string name;
//     int roll;
//     int marks;
// };

// bool cmp(Student l, Student r)
// {
//     if (l.marks == r.marks)
//     {
//         return l.roll < r.roll;
//     }
//     else
//     {
//         return l.marks > r.marks;
//     }
// }

// int main()
// {
//     int n;
//     cin >> n;
//     Student a[n];

//     for (int i = 0; i < n; i++)
//     {
//         cin >> a[i].name >> a[i].roll >> a[i].marks;
//     }

//     sort(a, a + n, cmp);

//     for (int i = 0; i < n; i++)
//     {
//         cout << a[i].name << " " << a[i].roll << " " << a[i].marks << endl;
//     }
//     return 0;
// }

// pricatice problem 2
// class Student
// {
// public:
//     string name;
//     int roll;
//     int marks;
// };

// int main()
// {
//     int n;
//     cin >> n;
//     Student a[n];

//     for (int i = 0; i < n; i++)
//     {
//         cin >> a[i].name >> a[i].roll >> a[i].marks;
//     }

//     for (int i = n - 1; i >= 0; i--)
//     {
//         cout << a[i].name << " " << a[i].roll << " " << a[i].marks << endl;
//     }
//     return 0;
// }

// pricatice problem 3
int main()
{
    string s1, s2;
    getline(cin, s1);
    cin >> s2;
    int cnt = 0;

    for (int i = 0; i < s1.size(); i++)
    {
        int temp = i;
        bool flag = true;
        if (s1[i] == s2[0])
        {
            i++;
            for (int j = 1; j < s2.size(); j++)
            {
                if (s2[j] != s1[i])
                {
                    flag = false;
                    break;
                }
                else
                {
                    i++;
                }
            }

            if (flag)
            {
                cnt++;
            }
            else
            {
                flag = true;
                i = temp;
            }
        }
    }

    cout << cnt << endl;

    return 0;
}