#include <iostream>

using namespace std;

int main()
{

    int q = 0, w = 0, e = 0;
    int a, b, c;
    cin >> a >> b >> c;

    int max = 15 * 28 * 19;
    int result = 1;

    while (true)
    {

        q++;
        q %= 16;
        if (q == 0)
        {
            q = 1;
        }

        w++;
        w %= 29;
        if (w == 0)
        {
            w = 1;
        }

        e++;
        e %= 20;
        if (e == 0)
        {
            e = 1;
        }

        if (q == a && w == b && e == c)
        {
            break;
        }
        result++;
    }
    cout << result;
    return 0;
}