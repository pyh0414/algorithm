#include <iostream>
#include <algorithm>

using namespace std;

int main()
{

    int dp[10001] = {0};
    int wines[10001] = {0};

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> wines[i];
    }

    dp[1] = wines[1];

    if (n > 1)
    {
        dp[2] = wines[1] + wines[2];
    }

    for (int i = 3; i <= n; i++)
    {
        dp[i] = max(dp[i - 1], max(wines[i] + dp[i - 2], wines[i] + wines[i - 1] + dp[i - 3]));
    }

    cout << dp[n];
    return 0;
}