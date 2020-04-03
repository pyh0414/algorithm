#include <iostream>
#include <algorithm>

using namespace std;

int main()
{

    int T;
    cin >> T;

    int dp[2][100001] = {0};
    int arr[2][100001] = {0};

    while (T--)
    {
        int n;
        cin >> n;

        for (int i = 1; i <= n; i++) // 위쪽
        {
            cin >> dp[0][i];
        }
        for (int i = 1; i <= n; i++) // 아래쪽
        {
            cin >> dp[1][i];
        }

        int topMax = dp[0][1];
        int bottomMax = dp[1][1];

        for (int i = 2; i <= n; i++)
        {
            dp[0][i] = bottomMax + dp[0][i]; // 위쪽
            dp[1][i] = topMax + dp[1][i];    // 아래쪽

            topMax = max(topMax, dp[0][i]);
            bottomMax = max(bottomMax, dp[1][i]);
        }

        cout << max(dp[0][n], dp[1][n]) << "\n";
    }
    return 0;
}