#include <iostream>

using namespace std;

int dp[101][101];

int main()
{
    int n;
    cin >> n;

    // 길이가 1이고, 끝이 i인 숫자는 하나밖에 없다(1,2,3,4,5,6,7,8,9)
    for (int i = 1; i <= 9; i++)
    {
        dp[1][i] = 1;
    }

    int mod = 1000000000;
    // i : 자리수
    // j : i자리수의 마지막 숫자

    for (int i = 2; i <= n; i++)
    {
        for (int j = 0; j <= 9; j++)
        {
            if (j == 0)
                dp[i][j] = dp[i - 1][j + 1];

            else if (j == 9)
                dp[i][j] = dp[i - 1][j - 1];

            else
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]);

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