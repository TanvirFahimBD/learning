#include <bits/stdc++.h>
using namespace std;

int main()
{
    // list<int> l(10,5);
    // cout << l.size();
    // cout << *l.begin();

    // for (auto it = l.begin(); it != l.end(); it++)
    // {
    //     cout << *it << " ";
    // }
    
    // for(int val : l){
    //     cout << val << " ";
    // }

    // //keep list
    // list<int> l = {1, 5, 6, 3};
    // list<int> l2(l);

    // for(int val: l2){
    //     cout << val << " ";
    // }    

    // //keep array
    // int arr[] = {10, 30, 50};
    // list<int> l2(arr, arr+3);

    // for(int val: l2){
    //     cout << val << " ";
    // }    

    // //keep vector
    // vector<int> v = {100, 300, 500};
    // list<int> l2(v.begin(), v.end());

    // for(int val: l2){
    //     cout << val << " ";
    // }    
    
    vector<int> v = {100, 200, 300};
    list<int> l2(v.begin(), v.end());

    //clear
    // l2.clear();

    // empty
    // if(l2.empty()){
    //     cout << "Empty now" << endl;
    // }
    
    //resize
    // l2.resize(2);
    l2.resize(5, 500);
    for(int val: l2){
        cout << val << " ";
    }    

    
    return 0;
}