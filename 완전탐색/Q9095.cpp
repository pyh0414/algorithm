#include <iostream>

using namespace std;

int n;

int dfs(int sum)
{

    if (sum >= n)
    {
        if (sum > n)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    return dfs(sum + 1) + dfs(sum + 2) + dfs(sum + 3);
}

int main()
{

    int t;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        cin >> n;
        cout << dfs(0) << "\n";
    }
    return 0;
}