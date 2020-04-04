#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[100001];
    int dp[100001];

    bool allMinus = true;
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];

        if (arr[i] >= 0)
        {
            allMinus = false;
        }
    }

    int temp = 0;
    if (allMinus)
    {
        sort(arr, arr + n + 1);
        cout << arr[n - 1];
        return 0;
    }

    dp[1] = arr[1];
    int result = dp[1];

    for (int i = 2; i <= n; i++)
    {
        dp[i] = max(dp[i - 1] + arr[i], 0);
        result = max(result, dp[i]);
    }

    cout << result;
    return 0;
}