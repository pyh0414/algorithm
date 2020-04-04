#include <iostream>

using namespace std;

int arr[1001] = {0};
int dp[1001] = {0};
int incDp[1001] = {0};
int decDp[1001] = {0};

int n;

int max(int n1, int n2)
{
    return n1 > n2 ? n1 : n2;
}

void check(int index)
{

    int cnt;

    for (int i = n; i >= index; i--)
    {
        cnt = 0;
        decDp[i] = 1;
        for (int j = i; j <= n; j++)
        {
            if (arr[i] > arr[j])
            {
                cnt = max(cnt, decDp[j]);
            }
        }
        decDp[i] += cnt;
    }

    for (int i = 1; i <= index; i++)
    {
        cnt = 0;
        incDp[i] = 1;

        int cnt2 = 0;

        for (int j = 1; j < i; j++)
        {
            if (arr[i] > arr[j])
            {
                cnt = max(cnt, incDp[j]);
            }
        }
        incDp[i] += cnt;
    }
}

int main()
{
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
        incDp[i] = decDp[i] = 1;
    }

    for (int i = 1; i <= n; i++)
    {
        check(i);
    }

    int result = 0;

    for (int i = 1; i <= n; i++)
    {
        result = max(result, incDp[i] + decDp[i] - 1);
    }

    cout << result;
    return 0;
}