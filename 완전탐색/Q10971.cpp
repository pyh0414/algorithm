#include <iostream>
#include <algorithm>

using namespace std;
int n;
int visited[11];
int arr[11][11];
int startAt;
int result = 987654321;

void travel(int node, int depth, int sum)
{
    if (depth == n - 1 && arr[node][startAt])
    {
        result = min(result, sum + arr[node][startAt]);
        return;
    }
    else
    {
        for (int i = 0; i < n; i++)
        {
            if (!visited[i] && arr[node][i])
            {
                visited[i] = true;
                travel(i, depth + 1, sum + arr[node][i]);
                visited[i] = false;
            }
        }
    }
}
int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        for (int k = 0; k < n; k++)
        {
            cin >> arr[i][k];
        }
    }

    for (int i = 0; i < n; i++)
    {
        startAt = i;
        visited[i] = true;
        travel(i, 0, 0);
        visited[i] = false;
    }

    cout << result;
    return 0;
}