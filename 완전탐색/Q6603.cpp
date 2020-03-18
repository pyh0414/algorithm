#include <iostream>

using namespace std;

int arr[14];
int temp[6];
int k;

void recur(int index, int depth)
{

    if (depth == 6)
    {
        for (int k = 0; k < 6; k++)
        {
            cout << temp[k] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = index; i < k; i++)
    {
        temp[depth] = arr[i];
        recur(i + 1, depth + 1);
    }
}

int main()
{

    while (1)
    {
        cin >> k;
        if (k == 0)
        {
            break;
        }

        for (int i = 0; i < k; i++)
        {
            int n;
            cin >> n;
            arr[i] = n;
        }

        recur(0, 0);

        cout << "\n";
    }

    return 0;
}