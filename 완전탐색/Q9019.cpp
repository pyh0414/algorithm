#include <iostream>
#include <queue>

using namespace std;

int main()
{

    int t;
    cin >> t;

    while (t--)
    {

        int n1, n2;
        cin >> n1 >> n2;

        queue<pair<int, string>> que;
        que.push(make_pair(n1, ""));

        bool visited[10000] = {0};
        visited[n1] = true;

        while (!que.empty())
        {
            int num = que.front().first;
            string str = que.front().second;
            que.pop();

            if (num == n2)
            {
                cout << str << "\n";
                break;
            }

            int newNum;

            // D
            newNum = (2 * num) % 10000;
            if (!visited[newNum])
            {
                que.push(make_pair(newNum, str + "D"));
                visited[newNum] = true;
            }

            // S
            newNum = (num - 1) < 0 ? 9999 : num - 1;
            if (!visited[newNum])
            {
                que.push(make_pair(newNum, str + "S"));
                visited[newNum] = true;
            }

            // L
            newNum = (num % 1000 / 100) * 1000 + (num % 1000 % 100 / 10) * 100 + (num % 10) * 10 + (num / 1000);
            if (!visited[newNum])
            {
                que.push(make_pair(newNum, str + "L"));
                visited[newNum] = true;
            }

            newNum = (num % 10) * 1000 + (num / 1000) * 100 + (num % 1000 / 100) * 10 + (num % 1000 % 100 / 10);
            if (!visited[newNum])
            {
                que.push(make_pair(newNum, str + "R"));
                visited[newNum] = true;
            }
        }
    }
    return 0;
}
