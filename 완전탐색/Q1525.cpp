#include <iostream>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

bool check(string s, vector<string> vec)
{
    return find(vec.begin(), vec.end(), s) == vec.end() ? false : true;
}
int main()
{
    string input = "";
    for (int i = 0; i < 9; i++)
    {
        int n;
        cin >> n;
        input += to_string(n);
    }

    int dir[4] = {-1, 1, -3, 3};

    queue<string> que;
    set<string> visited;

    int count = 0;
    int index;

    string str;
    char temp;

    visited.insert(input);
    que.push(input);

    while (!que.empty())
    {
        int size = que.size();

        for (int i = 0; i < size; i++)
        {

            str = que.front();
            que.pop();

            if (str == "123456780")
            {
                cout << count;
                return 0;
            }

            index = str.find("0");
            string s;

            for (int i = 0; i < 4; i++)
            {
                int swapIndex = index + dir[i];
                if (swapIndex < 0 || swapIndex >= 9 || (index % 3 == 0 && i == 0) || (index % 3 == 2) && i == 1)
                {
                    continue;
                }
                s = str;
                swap(s[index], s[swapIndex]);
                if (visited.count(s) == 0)
                {
                    visited.insert(s);
                    que.push(s);
                }
            }
        }
        count++;
    }

    cout << -1;
    return 0;
}