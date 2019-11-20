// https://algospot.com/judge/problem/read/TSP1

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define MAX 8



double dist[MAX][MAX];
int n; // 도시의 수

double tsp(vector<int> &path, vector<bool> &visited, double currentLength){
    if(path.size()==n){
        return currentLength;
    }
    double result = numeric_limits<double>::max();

    for(int next=0;next<n;next++){
        
        if(visited[next]){
            continue;
        }

        int here = path.back();
        path.push_back(next);
        visited[next]=true;
        double candidate = tsp(path,visited,currentLength+dist[here][next]);
        result = min(result,candidate);
        visited[next]=false;
        path.pop_back();
    }
    return result;
}

int main(){

    int test_case;
    double result;
    cin >> test_case;

    for(int i=0;i<test_case;i++){
        cin >> n;
        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
                cin >> dist[y][x];
            }
        }
        double answer = numeric_limits<double>::max();

        for(int k=0;k<n;k++){
            vector<int> path(1,k);
            vector<bool> visited(n,false);
            visited[k]=true;
            result = tsp(path,visited,0.0000000000);

            if(answer > result){
                answer = result;
            }
        }
        cout << "\n";
        printf("%0.10f\n",answer);

    }

}