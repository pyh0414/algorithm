#include <iostream>
#include <vector>
#include <queue>
#include <math.h>

using namespace std;

int main()
{

    bool primeCheck[10000] = {0};

    for (int i = 2; i <= sqrt(10000); i++)
    {
        for (int j = i + i; j <= 10000; j += i)
        {
            primeCheck[j] = true; // 소수는 false, 소수아니면 true
        }
    }

    int t;
    cin >> t;

    while (t--)
    {

        int n1, n2;
        cin >> n1 >> n2;

        bool visited[10000] = {0};
        queue<int> que;
        que.push(n1);
        int arr[4];
        bool isFind = false;
        int count = 0;

        while (!que.empty())
        {
            int size = que.size();
            for (int k = 0; k < size; k++)
            {
                int num = que.front();
                que.pop();

                if (num == n2)
                {
                    isFind = true;
                    break;
                }

                for (int i = 0; i < 4; i++)
                {
                    for (int j = 0; j <= 9; j++)
                    {
                        if (i == 0 && j == 0) // 천의 자리는 예외처리
                        {
                            continue;
                        }
                        arr[0] = num / 1000;
                        arr[1] = num % 1000 / 100;
                        arr[2] = num % 1000 % 100 / 10;
                        arr[3] = num % 10;

                        arr[i] = j;

                        int newNum = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];

                        if (!visited[newNum] && !primeCheck[newNum])
                        {
                            visited[newNum] = 1;
                            que.push(newNum);
                        }
                    }
                }
            }
            if (isFind)
            {
                break;
            }
            count++;
        }

        isFind ? cout << count << "\n" : cout << "Impossible\n";
    }

    return 0;
}