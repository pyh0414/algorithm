#include <iostream>
#include <math.h>
#include <algorithm>

using namespace std;

int main()
{

    int n;
    cin >> n;

    int dp[100001] = {0};

    for (int i = 1; i <= n; i++)
    {
        dp[i] = i; // 먼저 가장 최악의 경우인 1^2로 구성되는 방법
        for (int j = 1; j <= sqrt(i); j++)
        {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }

    cout << dp[n];
    return 0;
}