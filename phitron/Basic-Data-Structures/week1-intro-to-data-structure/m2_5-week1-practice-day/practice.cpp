#include <bits/stdc++.h>
#include <algorithm>
using namespace std;
int main()
{
    //F. Reversing
    //https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/F
    // int x;
    // cin >> x;
    // vector<int> v(x); 
    // for (int i = 0; i < x; i++)
    // {
    //     cin >> v[i];
    // }
    
    // for (int i = x-1; i >= 0; i--)
    // {
    //     cout << v[i] << " ";
    // }
 
    //C. Replacement
    //https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/C
    // int x;
    // cin >> x;
    // vector<int> v(x); 
    // vector<int> v2; 
    // for (int i = 0; i < x; i++)
    // {
    //     cin >> v[i];
    // }
    
    // for (int i = 0; i < x; i++)
    // {
    //     if(v[i]==0){
    //         v2.push_back(0);
    //     }
    //     else if(v[i]>0){
    //         v2.push_back(1);
    //     }
    //     else if(v[i]<0){
    //         v2.push_back(2);
    //     }
    // }
    
    // for (int i =0; i <x; i++)
    // {
    //     cout << v2[i] << " ";
    // }

    //D. Counting Elements
    //https://codeforces.com/group/MWSDmqGsZm/contest/329103/problem/D
    // int x;
    // cin >> x;
    // vector<int> v(x); 
    // for (int i = 0; i < x; i++)
    // {
    //     cin >> v[i];
    // }
    
    // int sum = 0;
    // for (int i = 0; i < x; i++)
    // {
    //     auto res = find(v.begin(),v.end(),v[i]+1);
    //     if(res != v.end()){
    //         sum++;
    //     }
    // }

    // cout << sum << endl;

    //J. Count Letters
    //https://codeforces.com/group/MWSDmqGsZm/contest/219856/problem/J
    // string str;
    // cin >> str;
    // vector<int> v(26);

    // for (int i = 0; i < str.length(); i++)
    // {
    //     v[str[i] - 'a']++;
    // }
    
    // for (int i = 0; i < v.size(); i++)
    // {
    //     if(v[i] > 0){
    //         cout << static_cast<char>(i+'a') << " : " << v[i] << endl;
    //     }
    // }
    

    //Y. Range sum query
    //https://codeforces.com/group/MWSDmqGsZm/contest/219774/problem/Y
    int x, y;
    cin >> x  >> y;
    vector<long long int> v(x+1);
    vector<long long int> v2(x+1);

    for (int i = 1; i <= x; i++)
    {
        cin >> v[i];
    }

    v2[1] = v[1];
    for (int i = 2; i <= x; i++)
    {
        v2[i] = v2[i-1]+v[i];
    }
    
    while (y--)
    {
        int a, b;
        cin >> a >> b;
        long long int res=0;
        if(a == 1){
            res = v2[b];
        }
        else{
            res = v2[b] - v2[a-1];
        }

        cout << res << endl;
    }

    return 0;
}