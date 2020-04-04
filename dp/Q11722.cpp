#include <iostream>
#include <algorithm>

using namespace std;

int arr[1001] = {0};
int dp[1001] = {0};

int main()
{
    int n;
    int result = 0;

    cin >> n;

    int arr1[1001] = {0};
    int arr[1001] = {0};
    int dp[1001] = {0};

    for (int i = 1; i <= n; i++)
    {
        cin >> arr1[i];
    }

    for (int i = n; i >= 1; i--)
    {
        arr[n - i + 1] = arr1[i];
    }

    for (int i = 1; i <= n; i++)
    {
        int cnt = 0;
        dp[i] = 1;
        for (int j = 1; j < i; j++)
        {
            if (arr[i] > arr[j])
            {
                cnt = max(cnt, dp[j]);
            }
        }
        dp[i] += cnt;
        result = max(result, dp[i]);
    }

    cout << result;
    return 0;
}