#include <iostream>

using namespace std;
int T, n, l; // T : testcase, n : 학생 수, l : 관계 수

int recur(bool relation[10][10], bool students[10])
{

    int firstStudent = -1;

    for (int i = 0; i < n; i++)
    {
        if (!students[i])
        {
            firstStudent = i;
            break;
        }
    }

    if (firstStudent == -1)
    {
        return 1;
    }

    int ret = 0;
    for (int otherStudent = firstStudent + 1; otherStudent < n; otherStudent++)
    {
        if (relation[firstStudent][otherStudent] && !students[otherStudent])
        {
            students[otherStudent] = students[firstStudent] = true;
            ret += recur(relation, students);
            students[otherStudent] = students[firstStudent] = false;
        }
    }

    return ret;
}

int main()
{

    cin >> T;

    while (T--)
    {
        cin >> n >> l;
        int x, y;
        bool relations[10][10] = {false};
        bool students[10] = {false};

        while (l--)
        {
            cin >> y >> x;
            relations[y][x] = true;
        }
        cout << recur(relations, students) << "\n";
    }
}