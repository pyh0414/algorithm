#include <iostream>
#include <vector>

using namespace std;

int main()
{

    int n;
    cin >> n;
    vector<int> v(n);

    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }

    int index1 = n - 1;

    while (index1 > 0 && v[index1] > v[index1 - 1])
    {
        index1--;
    }

    if (index1 == 0)
    {
        cout << -1;
        return 0;
    }

    int index2 = n - 1;

    while (v[index1 - 1] < v[index2])
    {
        index2--;
    }

    swap(v[index1 - 1], v[index2]);
    index2 = n - 1;

    while (index1 < index2)
    {
        swap(v[index1], v[index2]);
        index1++;
        index2--;
    }

    for (int i = 0; i < n; i++)
    {
        cout << v[i] << " ";
    }

    return 0;
}