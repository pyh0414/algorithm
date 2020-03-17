#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int getSum(vector<int> &v)
{
    int sum = 0;
    for (int i = 0; i < v.size() - 1; i++)
    {
        sum += abs(v[i] - v[i + 1]);
    }

    return sum;
}
int main()
{
    int t;
    cin >> t;
    vector<int> v(t);

    for (int i = 0; i < t; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    int result = 0;

    do
    {
        result = max(result, getSum(v));
    } while (next_permutation(v.begin(), v.end()));

    cout << result;
    return 0;
}