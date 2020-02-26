#include <iostream>
#include <algorithm>

using namespace std;

int arr[1001] = {0};
int dp[1001] = {0};

int main()
{
    int T;

    cin >> T;
    int result = 0;
    for (int i = 1; i <= T; i++)
    {
        cin >> arr[i];
    }

    for (int i = 1; i <= T; i++)
    {
        int cur = 0;
        for (int j = 0; j < i; j++)
        {
            if (arr[i] > arr[j])
            {
                cur = max(cur, dp[j]);
            }
        }
        dp[i] = cur + 1;
        result = max(result, dp[i]);
    }

    cout << result;
    return 0;
}