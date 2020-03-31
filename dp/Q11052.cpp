#include <iostream>
#include <algorithm>

using namespace std;

int main()
{

    int card[10002];
    int dp[1001];
    int N;

    cin >> N;

    for (int i = 1; i <= N; i++)
    {
        cin >> card[i];
    }

    dp[1] = card[1];

    for (int i = 2; i <= N; i++)
    {
        int mx = -1;
        for (int j = 1; j < i; j++)
        {
            mx = max(mx, dp[i - j] + dp[j]);
        }
        dp[i] = max(card[i], mx);
    }

    cout << dp[N];
    return 0;
}