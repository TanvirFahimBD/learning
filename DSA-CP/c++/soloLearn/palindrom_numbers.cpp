#include <iostream>
#include <string>
using namespace std;

bool isPalindrome(int x) {
    int num, count_num, get_num;
    get_num = x;
    string temp_num;
    num = x;

    while(num> 0)
        {
            count_num = num%10;
            num = num/10;
            temp_num += to_string(count_num);
        }

    if(temp_num == to_string(get_num))
    {
        return 1;
    }
    else
    {
        return 0;
    }

}

int main() {
    int n;
    cin >>n;

    if(isPalindrome(n)) {
        cout <<n<<" is a palindrome";
    }
    else {
        cout << n<<" is NOT a palindrome";
    }
    return 0;
}
