#include <iostream>

using namespace std;

int types[4][3][2] = {

    {{0, 0}, {1, 0}, {0, 1}}, //┌─
    {{0, 0}, {0, 1}, {1, 1}}, // ─┐
    {{0, 0}, {1, 0}, {1, 1}}, // └─
    {{0, 0}, {1, 0}, {1, -1}} // ─┘

};
int height, width;
int map[20][20];

bool set(int y, int x, int type, int delta) // y,x,위치에서 type 도형(┌─,─┐,└─,─┘)을 놓을 수 있는지 검사
{
    bool ok = true;
    for (int i = 0; i < 3; i++)
    {
        int ny = y + types[type][i][0];
        int nx = x + types[type][i][1];

        if (ny < 0 || ny >= height || nx < 0 || nx >= width) // 도형을 놓는 위치가 배열에서 벗어나는지
        {
            ok = false;
        }
        else if ((map[ny][nx] += delta) > 1) // 도형을 놓는 위치가 벽인지
        {
            ok = false;
        }
    }
    return ok;
}

int cover() // map[h][w]==0인 위치에서 여러 도형을 계속 놓아봄.
{
    int y = -1, x = -1;

    for (int h = 0; h < height; h++)
    {
        for (int w = 0; w < width; w++)
        {
            if (map[h][w] == 0)
            {
                x = w;
                y = h;
                break;
            }
        }
        if (y != -1)
        {
            break;
        }
    }
    if (y == -1) // x==-1이라는 말은, 0이 없다. 즉 모든 칸을 블럭으로 다 채웠다는 의미이기 떄문, 1가지 경우 찾음 !
    {
        return 1;
    }

    int count = 0;

    for (int type = 0; type < 4; type++) // 현재 위치에서 4가지 타입의 도형을 모두 놓아봄.
    {

        if (set(y, x, type, 1))
        {
            count += cover();
        }

        set(y, x, type, -1); // 덮었던 블록을 다시 지운다.
    }

    return count;
}

int main()
{
    int test_case;
    cin >> test_case;

    char text[20];

    for (int i = 0; i < test_case; i++)
    {
        cin >> height >> width;
        for (int h = 0; h < height; h++)
        {
            cin >> text;
            for (int w = 0; w < width; w++)
            {
                map[h][w] = (text[w] == '#') ? 1 : 0;
            }
        }

        cout << cover() << endl;
    }
    return 0;
}
