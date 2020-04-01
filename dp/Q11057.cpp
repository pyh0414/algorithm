#include <iostream>

using namespace std;

int main()
{

    int dp[1001][10];
    int mod = 10007;

    int n;
    cin >> n;

    for (int i = 0; i <= 9; i++)
    {
        dp[1][i] = 1;
    }

    for (int i = 2; i <= n; i++) // i : 숫자의 길이
    {
        for (int j = 0; j <= 9; j++) // j : 숫자에서 제일 오른쪽값
        {
            if (j == 0)
                dp[i][j] = dp[i - 1][j];
            else
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

            dp[i][j] %= mod;
        }
    }

    int result = 0;
    for (int i = 0; i <= 9; i++)
    {
        result = (result + dp[n][i]) % mod;
    }

    cout << result;

    return 0;
}