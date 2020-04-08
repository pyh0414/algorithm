#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[301] = {0};
    long long dp[301] = {0};

    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }

    dp[1] = arr[1];
    dp[2] = arr[2] + arr[1];

    for (int i = 3; i <= n; i++)
    {
        dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
    }

    // dp[i-2] + arr[i] : i-2번째 i번째 칸에서 오는 경우
    // dp[i-3] + arr[i-1] + arr[i] : i-1번째 칸에서 i번째로 오는 경우
    cout << dp[n];

    return 0;
}
