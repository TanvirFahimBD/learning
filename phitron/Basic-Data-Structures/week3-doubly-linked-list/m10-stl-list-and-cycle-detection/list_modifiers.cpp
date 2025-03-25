#include <bits/stdc++.h>
using namespace std;

int main()
{
    // assign 
    // list<int> l1 = {10, 20, 30};
    // list<int> l2 = l1;
    // // l2 = l1;
    // l2.assign(l1.begin(), l1.end());
    // for(int val: l2){
    //     cout << val << " ";
    // }    

    //push back & push front 
    //pop back & pop front 
    // list<int> l1 = {10, 20, 30};
    // l1.push_back(40);
    // l1.push_front(100);
    // l1.pop_back();
    // l1.pop_front();

    // PROERTY ACCESS
    // cout << *next(l1.begin(), 2);

    //INSERT
    // list<int> l2 = {100, 200, 300};
    // // l1.insert(next(l1.begin(),2), 300);
    // l1.insert(next(l1.begin(),2), l2.begin(), l2.end());

    // for(int val: l1){
    //     cout << val << " ";
    // }
    
    // list<int> l = {10, 20, 30, 40, 20, 60, 20};

    //ERASE
    // l.erase(next(l.begin(),3), next(l.begin(),5));

    //REPLACE
    // replace(l.begin(), l.end(), 20, 100);
    // for(int val: l){
    //     cout << val << " ";
    // }
    
    //FIND
    list<int> l = {10, 20, 30, 40, 20, 60, 20};
    auto it = find(l.begin(), l.end(), 20);
    if(it == l.end()){
        cout <<  "not found";
    }else{
        cout << "found";
    }

    return 0;
}