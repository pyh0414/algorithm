#include <iostream>
#include <queue>

using namespace std;

int main()
{

    int me, you;
    cin >> me >> you;
    queue<int> que;
    que.push(me);

    int time = 0;
    bool visited[100001] = {0};
    bool isFind = false;
    while (1)
    {
        int size = que.size();

        for (int i = 0; i < size; i++)
        {
            me = que.front();
            que.pop();

            if (me == you)
            {
                isFind = true;
                break;
            }

            if (me > 0 && !visited[me - 1])
            {
                visited[me - 1] = true;
                que.push(me - 1);
            }
            if (me < 100000 && !visited[me + 1])
            {
                visited[me + 1] = true;
                que.push(me + 1);
            }

            if (me * 2 <= 100000 && !visited[me * 2])
            {
                visited[me * 2] = true;
                que.push(me * 2);
            }
        }
        if (isFind)
        {
            break;
        }
        time++;
    }
    cout << time;
    return 0;
}