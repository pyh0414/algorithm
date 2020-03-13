#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
vector<int> vec;

int f1() // 100부터 시작하는 경우
{
    return abs(100 - N);
}

bool possible(int n) // 누르면 안되는 숫자를 눌렀는지
{
    if (n == 0)
    {
        if (find(vec.begin(), vec.end(), 0) == vec.end())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    while (n)
    {
        if (find(vec.begin(), vec.end(), n % 10) != vec.end())
        {
            return false;
        }
        n /= 10;
    }
    return true;
}
int f2()
{ // 그냥 처음부터 숫자를 만드는 경우

    int result = 984321;
    int num;
    for (int i = 0; i <= 1000001; i++)
    {
        if (possible(i))
        {
            int clickCount = abs(i - N);
            if (result > clickCount)
            {
                result = clickCount;
                num = i;
            }
        }
    }
    return result + to_string(num).size();
}

int main()
{
    cin >> N >> M;
    int n;

    for (int i = 0; i < M; i++)
    {
        cin >> n;
        vec.push_back(n);
    }
    cout << min(f1(), f2());
    return 0;
}
