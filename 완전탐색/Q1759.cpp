#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int visited[123] = {0};
char arr[16];
char temp[16];

int L, C;

bool check()
{
    int consonant = 0; // 자음
    int vowel = 0;     //  모음

    for (int i = 0; i < L; i++)
    {
        char c = temp[i];

        if (c == 97 || c == 101 || c == 105 || c == 111 || c == 117)
        {
            vowel++;
        }
        else
        {
            consonant++;
        }

        if (vowel >= 1 && consonant >= 2)
        {
            return true;
        }
    }
    return false;
}

void dfs(int index, int depth)
{
    if (depth == L)
    {
        if (check())
        {
            for (int i = 0; i < L; i++)
            {
                cout << temp[i];
            }
            cout << "\n";
        }

        return;
    }

    for (int i = index; i < C; i++)
    {
        temp[depth] = arr[i];
        dfs(i + 1, depth + 1);
    }
}
int main()
{
    cin >> L >> C;

    for (int i = 0; i < C; i++)
    {
        char c;
        cin >> c;
        arr[i] = c;
    }

    sort(arr, arr + C);
    dfs(0, 0);

    return 0;
}