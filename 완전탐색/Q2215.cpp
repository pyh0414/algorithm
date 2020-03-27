#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

int main()
{

    int A, B, C;
    cin >> A >> B >> C;

    bool visited[201][201][201] = {0};
    vector<int> result;
    queue<pair<pair<int, int>, int>> q;

    q.push(make_pair(make_pair(0, 0), C));

    while (!q.empty())
    {
        int a = q.front().first.first;
        int b = q.front().first.second;
        int c = q.front().second;

        q.pop();

        if (visited[a][b][c])
        {
            continue;
        }
        visited[a][b][c] = 1;

        if (a == 0)
        {
            result.push_back(c);
        }

        // A->B
        if (a + b > B) // b에 가득 담을 수 있는 경우(a+b에서 b에 먼저 다 채우고, 남는걸 a에 채운다)
            q.push(make_pair(make_pair(a + b - B, B), c));
        else // b에 가득 못담는 경우(최대한 넣을 수 있는 만큼 넣는다)
            q.push(make_pair(make_pair(0, a + b), c));

        // A->C
        if (a + c > C) // c에 가득 담을 수 있는 경우(a+c에서 c에 먼저 다 채우고, 남는걸 c에 채운다)
            q.push(make_pair(make_pair(a + c - C, b), C));
        else // c에 가득 못담는 경우
            q.push(make_pair(make_pair(0, b), a + c));

        // B->A
        if (b + a > A) // a에 가득 담을 수 있는 경우(b+a에서 a에 먼저 다 채우고, 남는걸 b에 채운다)
            q.push(make_pair(make_pair(A, b + a - A), c));
        else // a에 가득 못담는 경우
            q.push(make_pair(make_pair(b + a, 0), c));

        // B->C
        if (b + c > C) // c에 가득 담을 수 있는 경우(b+c에서 c에 먼저 다 채우고, 남는걸 b에 채운다)
            q.push(make_pair(make_pair(a, b + c - C), C));
        else // c에 가득 못담는 경우
            q.push(make_pair(make_pair(a, 0), b + c));

        // C->A
        if (c + a > A) // a에 가득 담을 수 있는 경우(c+a에서 a에 먼저 다 채우고, 남는걸 c에 채운다)
            q.push(make_pair(make_pair(A, b), c + a - A));
        else // a에 가득 못담는 경우
            q.push(make_pair(make_pair(c + a, b), 0));

        // C->B
        if (c + b > B) // b에 가득 담을 수 있는 경우(c+b에서 b에 먼저 다 채우고, 남는걸 c에 채운다)
            q.push(make_pair(make_pair(a, B), c + b - B));
        else // b에 가득 못담는 경우
            q.push(make_pair(make_pair(a, c + b), 0));
    }

    sort(result.begin(), result.end());
    for (int i = 0; i < result.size(); i++)
    {
        cout << result[i] << " ";
    }

    return 0;
}