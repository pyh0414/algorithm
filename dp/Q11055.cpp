#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    int arr[1001] = {0};
    int dp[1001] = {0};

    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
    }

    int mx = 0;
    for (int i = 1; i <= n; i++)
    {
        int sum = 0;
        for (int j = 1; j < i; j++)
        {
            if (arr[i] > arr[j])
            {
                sum = max(sum, dp[j]);
            }
        }
        dp[i] = sum + arr[i];
        mx = max(mx, dp[i]);
    }

    cout << mx;
    return 0;
}