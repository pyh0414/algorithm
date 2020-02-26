#include <iostream>
#include <queue>
#include <stack>
#include <cstdio>
#include <vector>
#include <cstring>
#include <string>
#include <math.h>
#include <algorithm>
#include <map>
 
using namespace std;
 
#define INF 987654321
 
// linked[i][j] = 1 i번 스위치와 j번 시계가 연결되어 있다
// linked[i][j] = 0 i번 스위치와 j번 시계가 연결되어 있지 않다
 
const int linked[10][16] = {
 
    { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
 
    { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 },
 
    { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
 
    { 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
 
    { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0 },
 
    { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
 
    { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
 
    { 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
 
    { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
 
    { 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 }
 
};
 
vector<int> nowClock;
 
// 모두 12시를 가리키고 있는지 검사
bool twelve()
{
    for (auto i : nowClock)
    {
        if (i != 12) return false;
    }
 
    return true;
}
 
// 버튼을 누른다.
void push(int whichButton)
{
    for (int i = 0; i < nowClock.size(); i++)
    {
        if (linked[whichButton][i] == 1)
        {
            nowClock.at(i) += 3;
 
            if (nowClock.at(i) == 15){
                nowClock.at(i) = 3;
            }
        }
    }
}
 
int solve(int Button)
{
    // 0 ~ 9번 버튼까지 작업 완료.(누른 경우, 안 누른 경우의 작업까지 모두 포함.)
    if (Button == 10)
    {
        return twelve() ? 0 : INF;
    }
    
    int ret = INF;
 
    // 스위치를 0번 누르는 경우부터 3번 누르는 경우까지 모두 시도한다. i번 = 몇 번
    for (int i = 0; i < 4; i++)
    {
        ret = min(ret, i + solve(Button + 1));
        push(Button);
    }
 
    // push(Button)이 4번 호출되었으니, nowClock은 원래와 같은 상태가 된다.
 
    return ret;
}
 
int main(void)
{
    int T = 0, time = 0;
 
    scanf("%d", &T);
 
    while (T--)
    {
        if (!nowClock.empty()) nowClock.clear();
 
        for (int i = 0; i < 16; i++)
        {
            scanf("%d", &time);
 
            nowClock.push_back(time);
        }
 
        int get = solve(0);
 
        if (get == INF) printf("-1\n");
        else printf("%d\n", get);
    }
    
    return 0;
}
