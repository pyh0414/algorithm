#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[100001];
    int dp[100001];

    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }

    int temp = 0;

    dp[1] = arr[1];
    int result = dp[1];

    for (int i = 2; i <= n; i++)
    {
        dp[i] = max(dp[i - 1] + arr[i], arr[i]);
        result = max(result, dp[i]);
    }

    cout << result;
    return 0;
}