// #include <bits/stdc++.h>
// #include <algorithm>
// using namespace std;
// int main()
// {
//     //learn Binary Search
//     // int n;
//     // cin >> n;
//     // int a[n];

//     // for (int i = 0; i < n; i++)
//     // {
//     //     cin >> a[i];
//     // }

//     // int val;
//     // cin >> val;    
//     // int flag =0;

//     // int l=0;
//     // int r=n-1;
//     // while (l<=r)
//     // {
//     //     int mid = (l+r)/2;
//     //     if(a[mid] == val )
//     //     {
//     //         flag = 1;
//     //         break;
//     //     }
//     //     else if( a[mid] > val )
//     //     {
//     //         r = mid-1;
//     //     }
//     //     else if( a[mid] < val )
//     //     {
//     //         l = mid+1;
//     //     }
//     // }

//     // if(flag == 1)
//     // {
//     //     cout << "Found";
//     // }
//     // else
//     // {
//     //     cout << "Not Found";
//     // }


//     //Z. Binary Search
//     // https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/Z
//     //time complexity - NlogN = 10^5 * 17 = 1.7 * 10^6  //1.7 * 10^6 < 10^7
//     int n, tc;
//     cin >> n >> tc;
//     int a[n];

//     for (int i = 0; i < n; i++)
//     {
//         cin >> a[i];
//     }

//     sort(a, a+n);

//     while (tc--){
//         int val;
//         cin >> val;    
//         int flag =0;

//         int l=0;
//         int r=n-1;
//         while (l<=r)
//         {
//             int mid = (l+r)/2;
//             if(a[mid] == val )
//             {
//                 flag = 1;
//                 break;
//             }
//             else if( a[mid] > val )
//             {
//                 r = mid-1;
//             }
//             else
//             {
//                 l = mid+1;
//             }
//         }

//         if(flag == 1)
//         {
//             cout << "found" << endl;
//         }
//         else
//         {
//             cout << "not found" << endl;
//         }
//     }

//     return 0;
// }


#include <bits/stdc++.h>
using namespace std;
int main()
{
    cout << "i am from br search" << endl;
    return 0;
}