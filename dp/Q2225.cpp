#include <iostream>

using namespace std;

int main()
{

    int N, K;
    cin >> N >> K;
    long long dp[201][201] = {0};

    int mod = 1000000000;

    for (int i = 0; i <= 200; i++)
    {
        dp[1][i] = 1; // 1개 더해서 그 값이 b인 경우는 무조건 하나임
    }

    // dp[a][b] = c 의 의미는 "a개 더해서 그 합이 b가 되는 경우의 수는 c개 입니다." 이다.

    for (int i = 2; i <= K; i++)
    {
        for (int j = 0; j <= N; j++)
        {
            for (int l = 0; l <= j; l++)
            {
                dp[i][j] += dp[i - 1][j - l];
            }
            dp[i][j] %= mod;
        }
    }

    cout << dp[K][N];

    return 0;
}