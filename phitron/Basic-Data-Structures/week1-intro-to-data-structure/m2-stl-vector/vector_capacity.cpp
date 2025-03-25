#include <bits/stdc++.h>
using namespace std;
int main()
{
    // vector<int> v; 
    // cout << v.capacity() << endl; 
    // v.push_back(10);
    // cout << v.capacity() << endl; 

    // vector<int> v; 
    // v.push_back(10);
    // v.push_back(20);
    // v.push_back(30);
    // cout << v.size() << endl; 
    // v.clear();
    // cout << v.size() << endl; 
    // cout << v[0] << endl; 
    // v[0] = 100;
    // cout << v[0] << endl; 

    vector<int> v; 
    v.push_back(10);
    v.push_back(20);
    v.push_back(30);
    v.resize(6,100);
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    

    return 0;
}