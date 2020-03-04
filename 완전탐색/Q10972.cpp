#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<int> v1(n);

    for (int i = 0; i < n; i++)
    {
        cin >> v1[i];
    }

    vector<int> v2(v1);

    bool isReverse = true;
    for (int i = 0; i < n - 1; i++)
    {
        if (v1[i + 1] > v1[i])
        {
            isReverse = false;
            break;
        }
    }

    if (isReverse)
    {
        cout << -1;
        return 0;
    }

    bool isSame = false;
    bool passFirst = false;

    do
    {

        if (!passFirst)
        {
            passFirst = true;
        }

        if (isSame && passFirst)
        {
            for (int i = 0; i < n; i++)
            {
                cout << v1[i] << " ";
            }
            return 0;
        }
        bool flag = true;
        for (int i = 0; i < n; i++)
        {
            if (v1[i] != v2[i])
            {
                flag = false;
                break;
            }
        }
        if (flag)
        {
            isSame = true;
        }
    } while (next_permutation(v1.begin(), v1.end()));

    return 0;
}