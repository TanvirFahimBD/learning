#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
int main()
{
    //https://docs.google.com/document/d/1SInJU7vWMgmLO-lulcQ2aGAeLze-0632fS8Iz-14t_A/edit?tab=t.0#heading=h.z8qn1l3vmegh
    //Problem-1: Running Sum of an Array
    // int x;
    // cin >> x ;
    // vector<long long int> v(x);
    // vector<long long int> v2(x);

    // for (int i =0; i < x; i++)
    // {
    //     cin >> v[i];
    // }

    // v2[0] = v[0];
    // cout << v2[0] << " ";
    // for (int i = 1; i < x; i++)
    // {
    //     v2[i] = v2[i-1]+v[i];
    //     cout << v2[i] << " ";
    // }


    // Problem 2: Equilibrium Index
    int x;
    cin >> x;
    vector<int> v(x);
    vector<int> v2(x);

    for (int i = 0; i < x; i++)
    {
        cin >> v[i];
    }

    v2[0] = v[0];
    for (int i = 1; i < x; i++)
    {
        v2[i] = v2[i-1] + v[i];
    }
    
    int flag = 0, indexPos = 0;
    for (int i = 0; i < x; i++)
    {
        int res = 0, lowPart = 0, heighPart = 0;
        if(i != 0){
            res = (v2[x-1]-v2[i]) - v2[i-1];
            if(res == 0){
                flag = 1;
                indexPos = i;
                break;
            }
        }
    }

    if(flag == 1){
        cout << indexPos;
    }

    //Problem-3: Search Query
    // int x;
    // cin >> x;
    // int a[x];

    // for (int i =0; i < x; i++)
    // {
    //     cin >> a[i];
    // }
    
    // sort(a, a+x);
    // int tc;
    // cin >> tc;

    // while(tc--){
    //     int val;
    //     cin >> val;

    //     int flag = 0;
    //     int l = 0;
    //     int r = x-1;
    //     while(l<=r){
    //         int mid = (l+r)/2;

    //         if(a[mid] == val ){
    //             flag = 1;
    //             break;
    //         }
    //         else if(a[mid] < val ){
    //             l = mid + 1;
    //         }
    //         else if(a[mid] > val ){
    //             r = mid - 1;
    //         }
    //     }

    //     if(flag == 1){
    //         cout << "YES" << endl;
    //     }else{
    //         cout << "NO" << endl;
    //     }

    // }

    //Problem-4: Complexity Analysis
    // 1.O(logN)
    // 2.O(N*N)
    // 3.O(N*N*N)
    // 4.O(N*logN)
    // 5.O(N*N)

    //Problem-5: Summation from 1 to N
    // https://codeforces.com/group/MWSDmqGsZm/contest/219158/problem/G
    // G. Summation from 1 to N
    // int n;
    // cin >> n;
    // long long int res=0;
    // res = (1LL  * n * (n+1)) /2;
    // cout << res;

    return 0;
}
