#include <bits/stdc++.h>
using namespace std;
int main()
{
    // = or assign
    // vector<int> v = {1, 5, 7, 20}; 
    // vector<int> v2 = v; 
    // for (int i = 0; i < v2.size(); i++)
    // {
    //     cout << v[i] << " ";
    // }

    // for (int x: v2)
    // {
    //     cout << x << " ";
    // }

    //pop_back
    // vector<int> v = {1, 5, 7, 20}; 
    // v.pop_back();
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }

    //insert
    // vector<int> v = {1, 5, 7, 20}; 
    // v.insert(v.begin()+2, 100);
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }
    
    //insert2
    // vector<int> v = {1, 5, 7, 20}; 
    // vector<int> v2 = {100, 200, 300}; 
    // v.insert(v.begin()+2, v2.begin(),v2.end());
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }

    //erase
    // vector<int> v = {1, 5, 7, 20}; 
    // v.erase(v.begin()+2);
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }
    
    //erase2
    // vector<int> v = {1, 5, 7, 20}; 
    // v.erase(v.begin()+1,v.begin()+3);
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }
  
    //replace
    // vector<int> v = {1, 2, 3, 2, 5, 2}; 
    // // replace(v.begin(),v.end(), 2, 100);
    // replace(v.begin(),v.end()-1, 2, 100);
    // for (int x: v)
    // {
    //     cout << x << " ";
    // }
    
    //find
    // vector<int> v = {1, 2, 3, 2, 5, 2}; 
    // vector<int> ::iterator it = find(v.begin(),v.end(), 2);
    // auto it = find(v.begin(),v.end(), 2);
    // if (it == v.end())
    // {
    //     cout << "not found ";
    // }else{
    //     cout << "found";
    // }
    // cout << *it << endl;


    // vector<int> v = {1, 2, 3, 10, 5, 9}; 
    // cout << v[3] << endl;
    // cout << v.at(3) << endl;

    // cout << v.back()<< endl;
    // cout << v[v.size()-1] << endl;

    // cout << v.front()<< endl;
    // cout << v[0]<< endl;

    vector<int> v = {1, 2, 3, 10, 9, 11}; 
    for (auto it = v.begin(); it < v.end(); it++)
    {
        cout << *it << " ";
    }
    
    return 0;
}