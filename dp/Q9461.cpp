#include <iostream>

using namespace std;

int main()
{

    int t;
    cin >> t;

    long long dp[101] = {0};

    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;

    for (int i = 4; i <= 100; i++)
    {
        dp[i] = dp[i - 2] + dp[i - 3];
    }
    while (t--)
    {
        int n;
        cin >> n;

        cout << dp[n] << "\n";
    }
    return 0;
}