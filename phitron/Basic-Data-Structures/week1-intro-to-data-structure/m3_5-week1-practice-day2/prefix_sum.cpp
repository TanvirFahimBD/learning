// #include <bits/stdc++.h>
// #include <algorithm>
// using namespace std;
// int main()
// {
//     //Y. Range sum query
//     //https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/Y
//     int x, y;
//     cin >> x  >> y;
//     vector<long long int> v(x+1);
//     vector<long long int> v2(x+1);

//     for (int i = 1; i <= x; i++)
//     {
//         cin >> v[i];
//     }

//     v2[1] = v[1];
//     for (int i = 2; i <= x; i++)
//     {
//         v2[i] = v2[i-1]+v[i];
//     }
    
//     while (y--)
//     {
//         int a, b;
//         cin >> a >> b;
//         long long int res=0;
//         if(a == 1){
//             res = v2[b];
//         }
//         else{
//             res = v2[b] - v2[a-1];
//         }

//         cout << res << endl;
//     }

//     return 0;
// }

#include <bits/stdc++.h>
using namespace std;
int main()
{
    cout << "i am the pref sum" << endl;
    return 0;
}