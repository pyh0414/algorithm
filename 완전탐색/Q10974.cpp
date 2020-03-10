#include <iostream>
#include <vector>

using namespace std;
int n;
int check[9] = {0};

void dfs(vector<int> &v)
{

    if (v.size() == n)
    {
        for (int i = 0; i < v.size(); i++)
        {
            cout << v[i] << " ";
        }
        cout << "\n";
        return;
    }
    else
    {
        for (int i = 1; i <= n; i++)
        {
            if (!check[i])
            {
                v.push_back(i);
                check[i] = true;
                dfs(v);
                v.pop_back();
                check[i] = false;
            }
        }
    }
}

int main()
{
    cin >> n;
    vector<int> v;
    dfs(v);
    return 0;
}